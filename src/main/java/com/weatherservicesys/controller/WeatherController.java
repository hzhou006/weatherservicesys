package com.weatherservicesys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.weatherservicesys.response.FetchAllCitysResponse;
import com.weatherservicesys.response.FetchByNameResponse;
import com.weatherservicesys.response.FetchMinMaxByDatesResponse;
import com.weatherservicesys.response.TMeanPerMonthResponse;
import com.weatherservicesys.response.TMeanPerWeekResponse;
import com.weatherservicesys.service.IWeatherService;

@RestController
@RequestMapping("/weatherData")
public class WeatherController {

	@Autowired
	private IWeatherService weatherService = null;

	@RequestMapping(value = "/fetchAllCitys", method = RequestMethod.GET)
	public FetchAllCitysResponse fetchAllCitys() {
		FetchAllCitysResponse response = new FetchAllCitysResponse();
		response = weatherService.fetchAllCitys();
		return response;
	}

	@RequestMapping(value = "/fetchByName", method = RequestMethod.GET)
	public FetchByNameResponse fetchByName(@RequestParam("name") String name) {
		FetchByNameResponse response = new FetchByNameResponse();
		response = weatherService.fetchByName(name);
		return response;
	}

	@RequestMapping(value = "/fetchMinMaxTempByTwoDates", method = RequestMethod.GET)
	public FetchMinMaxByDatesResponse fetchMinMaxByTwoDates(@RequestParam("startDate") String startDate,
			@RequestParam("endDate") String endDate) {
		FetchMinMaxByDatesResponse response = new FetchMinMaxByDatesResponse();
		response = weatherService.FetchMinMaxByDates(startDate, endDate);
		return response;
	}

	@RequestMapping(value = "/calculateMeanTempPerWeek", method = RequestMethod.GET)
	public TMeanPerWeekResponse calculateMeanTempPerWeek(@RequestParam("startDate") String startDate,
			@RequestParam("endDate") String endDate) {
		TMeanPerWeekResponse response = new TMeanPerWeekResponse();
		response = weatherService.calculateMeanTempPerWeek(startDate, endDate);
		return response;
	}

	@RequestMapping(value = "/calculateMeanTempPerMonth", method = RequestMethod.GET)
	public TMeanPerMonthResponse calculateMeanTempPerMonth(@RequestParam("startDate") String startDate,
			@RequestParam("endDate") String endDate) {
		TMeanPerMonthResponse response = new TMeanPerMonthResponse();
		response = weatherService.calculateMeanTempPerMonth(startDate, endDate);
		return response;
	}
}
