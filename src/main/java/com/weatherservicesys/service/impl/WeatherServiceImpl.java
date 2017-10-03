package com.weatherservicesys.service.impl;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.weatherservicesys.dao.WeatherDao;
import com.weatherservicesys.domain.WeatherBean;
import com.weatherservicesys.response.FetchAllCitysResponse;
import com.weatherservicesys.response.FetchByNameEntity;
import com.weatherservicesys.response.FetchByNameResponse;
import com.weatherservicesys.response.FetchMinMaxByDatesEntity;
import com.weatherservicesys.response.FetchMinMaxByDatesResponse;
import com.weatherservicesys.response.TMeanPerMonthEntity;
import com.weatherservicesys.response.TMeanPerMonthResponse;
import com.weatherservicesys.response.TMeanPerWeekEntity;
import com.weatherservicesys.response.TMeanPerWeekResponse;
import com.weatherservicesys.service.IWeatherService;
import com.weatherservicesys.util.Info;


@Service
public class WeatherServiceImpl implements IWeatherService {
	@Autowired
	WeatherDao weatherDao = null;

	@Override
	public FetchAllCitysResponse fetchAllCitys() {
		FetchAllCitysResponse response = new FetchAllCitysResponse();
		List<String> list = new ArrayList<>();
		List<WeatherBean> fetchAllCity = null;
		HashSet<String> set = new HashSet<>();
		try {
			fetchAllCity = weatherDao.findAllCitys();
			for (WeatherBean weatherBean : fetchAllCity) {

				if (set.contains(weatherBean.getName())) {
					continue;
				} else {
					set.add(weatherBean.getName());
					list.add(weatherBean.getName());
				}
			}
		} catch (Exception e) {
			response.setInfo(new Info("300", "error: " + e.getMessage()));
			return response;
		}
		response.setListName(list);
		response.setInfo(new Info("200", "success"));
		return response;
	}

	@Override
	public FetchByNameResponse fetchByName(String name) {
		FetchByNameResponse response = new FetchByNameResponse();
		List<WeatherBean> fetchByName = null;
		List<FetchByNameEntity> list = new ArrayList<>();
		try {
			fetchByName = weatherDao.findByName(name);
			for (WeatherBean weatherBean : fetchByName) {
				FetchByNameEntity entity = new FetchByNameEntity();
				entity.setId(weatherBean.getId());
				entity.setDate(String.valueOf(weatherBean.getDate()));
				entity.setElevation(weatherBean.getElevation());
				entity.setLatitude(weatherBean.getLatitude());
				entity.setLongitude(weatherBean.getLongitude());
				entity.setName(weatherBean.getName());
				entity.setStation(weatherBean.getStation());
				entity.setTmaxF(weatherBean.getTmax());
				entity.setTminF(weatherBean.getTmin());
				int minF = weatherBean.getTmin();
				int maxF = weatherBean.getTmax();
				int minC = ((minF - 32) * 5) / 9;
				int maxC = ((maxF - 32) * 5) / 9;
				entity.setTminC(minC);
				entity.setTmaxC(maxC);
				list.add(entity);
			}

		} catch (Exception e) {
			response.setInfo(new Info("300", "error: " + e.getMessage()));
			return response;
		}
		response.setWeatherData(list);
		response.setInfo(new Info("200", "success"));
		return response;
	}

	@Override
	public FetchMinMaxByDatesResponse FetchMinMaxByDates(String start, String end) {
		FetchMinMaxByDatesResponse response = new FetchMinMaxByDatesResponse();
		List<WeatherBean> fetchByTwoDates = null;
		List<FetchMinMaxByDatesEntity> list = new ArrayList<>();
		Date startDate;
		Date endDate;
		try {
			DateFormat df = new SimpleDateFormat("yyyy-MM");
			startDate = df.parse(start);
			endDate = df.parse(end);
			fetchByTwoDates = weatherDao.findMinMaxByTwoDates(startDate, endDate);
			if (fetchByTwoDates == null) {
				response.setInfo(new Info("300", "error : WeatherBean is null"));
				return response;
			}
			for (WeatherBean weatherBean : fetchByTwoDates) {
				FetchMinMaxByDatesEntity entity = new FetchMinMaxByDatesEntity();
				entity.setId(weatherBean.getId());
				entity.setCityName(weatherBean.getName());
				entity.setStation(weatherBean.getStation());
				entity.setLatitude(weatherBean.getLatitude());
				entity.setLongitude(weatherBean.getLongitude());
				entity.setElevation(weatherBean.getElevation());
				entity.settMinF(weatherBean.getTmin());
				entity.settMaxF(weatherBean.getTmax());
				int minF = weatherBean.getTmin();
				int maxF = weatherBean.getTmax();
				int minC = ((minF - 32) * 5) / 9;
				int maxC = ((maxF - 32) * 5) / 9;
				entity.settMinC(minC);
				entity.settMaxC(maxC);
				list.add(entity);
			}
		} catch (Exception e) {
			response.setInfo(new Info("300", "error: " + e.getMessage()));
			return response;
		}
		response.setList(list);
		response.setInfo(new Info("200", "success"));
		return response;
	}

	@Override
	public TMeanPerWeekResponse calculateMeanTempPerWeek(String start, String end) {
		TMeanPerWeekResponse response = new TMeanPerWeekResponse();
		List<WeatherBean> fetchByTwoDates = null;
		List<TMeanPerWeekEntity> list = new ArrayList<>();
		HashMap<List<String>, List<String>> map = new HashMap<>();
		Date startDate;
		Date endDate;
		try {
			DateFormat df = new SimpleDateFormat("yyyy-MM");
			startDate = df.parse(start);
			endDate = df.parse(end);
			fetchByTwoDates = weatherDao.findMinMaxByTwoDates(startDate, endDate);
			if (fetchByTwoDates == null) {
				response.setInfo(new Info("300", "error : WeatherBean is null"));
				return response;
			}
			for (WeatherBean weatherBean : fetchByTwoDates) {
				List<String> key = new ArrayList<>();
				List<String> value = new ArrayList<>();
				Date d = weatherBean.getDate();
				Calendar cal = Calendar.getInstance();
				cal.setTime(d);
				int weekNum = cal.get(Calendar.WEEK_OF_YEAR);
				String city = weatherBean.getName();
				String station = weatherBean.getStation();
				String lat = weatherBean.getLatitude();
				String log = weatherBean.getLongitude();
				String elevation = weatherBean.getElevation();
				key.add(city);
				key.add(String.valueOf(weekNum));
				key.add(station);
				key.add(lat);
				key.add(log);
				key.add(elevation);
				int currMin = weatherBean.getTmin();
				int currMax = weatherBean.getTmax();
				if (map.containsKey(key)) {
					value.add(String.valueOf(Integer.parseInt(map.get(key).get(0)) + 1));
					value.add(String.valueOf(Integer.parseInt(map.get(key).get(1)) + currMin));
					value.add(String.valueOf(Integer.parseInt(map.get(key).get(2)) + currMax));
					map.put(key, value);
				}
				value.add(String.valueOf(1));
				value.add(String.valueOf(currMin));
				value.add(String.valueOf(currMax));
				map.put(key, value);
			}
			for (List<String> key : map.keySet()) {
				TMeanPerWeekEntity entity = new TMeanPerWeekEntity();
				double meanMin = Double.parseDouble(map.get(key).get(1)) / Double.parseDouble(map.get(key).get(0));
				double meanMax = Double.parseDouble(map.get(key).get(2)) / Double.parseDouble(map.get(key).get(0));
				DecimalFormat dft = new DecimalFormat("#.00");
				double minMeanF = Double.parseDouble(dft.format(meanMin));
				double maxMeanF = Double.parseDouble(dft.format(meanMax));
				double minMeanC = Double.parseDouble(dft.format(((minMeanF - 32) * 5) / 9));
				double maxMeanC = Double.parseDouble(dft.format(((maxMeanF - 32) * 5) / 9));
				entity.settMinMeanF(minMeanF);
				entity.settMaxMeanF(maxMeanF);
				entity.settMinMeanC(minMeanC);
				entity.settMaxMeanC(maxMeanC);
				entity.setCityName(key.get(0));
				entity.setStation(key.get(2));
				entity.setLatitude(key.get(3));
				entity.setLongitude(key.get(4));
				entity.setElevation(key.get(5));
				entity.setWeekNum(Integer.parseInt(key.get(1)));
				list.add(entity);
			}
		} catch (Exception e) {
			response.setInfo(new Info("300", "error: " + e.getMessage()));
			return response;
		}
		response.setMeanTempPerWeek(list);

		response.setInfo(new Info("200", "success"));
		return response;
	}

	@Override
	public TMeanPerMonthResponse calculateMeanTempPerMonth(String start, String end) {
		TMeanPerMonthResponse response = new TMeanPerMonthResponse();
		List<WeatherBean> fetchByTwoDates = null;
		List<TMeanPerMonthEntity> list = new ArrayList<>();
		HashMap<List<String>, List<String>> map = new HashMap<>();
		Date startDate;
		Date endDate;
		try {
			DateFormat df = new SimpleDateFormat("yyyy-MM");
			startDate = df.parse(start);
			endDate = df.parse(end);
			fetchByTwoDates = weatherDao.findMinMaxByTwoDates(startDate, endDate);
			if (fetchByTwoDates == null) {
				response.setInfo(new Info("300", "error : WeatherBean is null"));
				return response;
			}
			for (WeatherBean weatherBean : fetchByTwoDates) {
				List<String> key = new ArrayList<>();
				List<String> value = new ArrayList<>();
				Date d = weatherBean.getDate();
				Calendar cal = Calendar.getInstance();
				cal.setTime(d);
				int monthNum = cal.get(Calendar.MONTH);
				String city = weatherBean.getName();
				String station = weatherBean.getStation();
				String lat = weatherBean.getLatitude();
				String log = weatherBean.getLongitude();
				String elevation = weatherBean.getElevation();
				key.add(city);
				key.add(String.valueOf(monthNum + 1));
				key.add(station);
				key.add(lat);
				key.add(log);
				key.add(elevation);
				int currMin = weatherBean.getTmin();
				int currMax = weatherBean.getTmax();
				if (map.containsKey(key)) {
					value.add(String.valueOf(Integer.parseInt(map.get(key).get(0)) + 1));
					value.add(String.valueOf(Integer.parseInt(map.get(key).get(1)) + currMin));
					value.add(String.valueOf(Integer.parseInt(map.get(key).get(2)) + currMax));
					map.put(key, value);
				}
				value.add(String.valueOf(1));
				value.add(String.valueOf(currMin));
				value.add(String.valueOf(currMax));
				map.put(key, value);
			}
			for (List<String> key : map.keySet()) {
				TMeanPerMonthEntity entity = new TMeanPerMonthEntity();
				double meanMin = Double.parseDouble(map.get(key).get(1)) / Double.parseDouble(map.get(key).get(0));
				double meanMax = Double.parseDouble(map.get(key).get(2)) / Double.parseDouble(map.get(key).get(0));
				DecimalFormat dft = new DecimalFormat("#.00");
				double minMeanF = Double.parseDouble(dft.format(meanMin));
				double maxMeanF = Double.parseDouble(dft.format(meanMax));
				double minMeanC = Double.parseDouble(dft.format(((minMeanF - 32) * 5) / 9));
				double maxMeanC = Double.parseDouble(dft.format(((maxMeanF - 32) * 5) / 9));
				entity.settMinMeanF(minMeanF);
				entity.settMaxMeanF(maxMeanF);
				entity.settMinMeanC(minMeanC);
				entity.settMaxMeanC(maxMeanC);
				entity.setCityName(key.get(0));
				entity.setStation(key.get(2));
				entity.setLatitude(key.get(3));
				entity.setLongitude(key.get(4));
				entity.setElevation(key.get(5));
				entity.setMonthNum(Integer.parseInt(key.get(1)));
				list.add(entity);
			}
		} catch (Exception e) {
			response.setInfo(new Info("300", "error: " + e.getMessage()));
			return response;
		}
		response.setMeanTempPerMonth(list);

		response.setInfo(new Info("200", "success"));
		return response;
	}
}
