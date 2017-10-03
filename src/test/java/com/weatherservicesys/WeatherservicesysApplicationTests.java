package com.weatherservicesys;

import static org.junit.Assert.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.weatherservicesys.dao.WeatherDao;
import com.weatherservicesys.domain.WeatherBean;
import com.weatherservicesys.response.FetchAllCitysResponse;
import com.weatherservicesys.response.FetchByNameResponse;
import com.weatherservicesys.response.FetchMinMaxByDatesResponse;
import com.weatherservicesys.response.TMeanPerMonthResponse;
import com.weatherservicesys.response.TMeanPerWeekResponse;
import com.weatherservicesys.service.impl.WeatherServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WeatherservicesysApplicationTests {
	@Autowired
	private WeatherDao weatherDao;

	@Mock
	private List<WeatherBean> weatherBeanList;

	@Mock
	private TMeanPerWeekResponse tmeanPerWeekResponse;

	@Mock
	private TMeanPerMonthResponse tmeanPerMonthResponse;

	@Autowired
	private WeatherServiceImpl weatherService;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testMockCreation() {
		assertNotNull(weatherService);
		assertNotNull(weatherDao);
	}

	@Test
	public void fetchAllCitys() {
		FetchAllCitysResponse response = weatherService.fetchAllCitys();
		assertEquals(23, response.getListName().size());
	}

	@Test
	public void fetchByNameTesting() {
		FetchByNameResponse response = weatherService.fetchByName("BERKHOUT, NL");
		assertEquals("BERKHOUT, NL", response.getWeatherData().get(0).getName());
		assertEquals("BERKHOUT, NL", response.getWeatherData().get(2).getName());
		assertEquals("BERKHOUT, NL", response.getWeatherData().get(5).getName());
	}

	@Test
	public void fetchMinMaxTempByTwoDatesTesting() throws ParseException {

		FetchMinMaxByDatesResponse response = weatherService.FetchMinMaxByDates("2016-09", "2017-09");
		DateFormat df = new SimpleDateFormat("yyyy-MM");
		Date startDate;
		Date endDate;
		startDate = df.parse("2016-09");
		endDate = df.parse("2017-09");
		weatherBeanList = weatherDao.findMinMaxByTwoDates(startDate, endDate);
		assertEquals(weatherBeanList.size(), response.getList().size());
		assertEquals(weatherBeanList.get(0).getId(), response.getList().get(0).getId());
		assertEquals(weatherBeanList.get(0).getName(), response.getList().get(0).getCityName());
	}

	@Test
	public void calculateMeanTempPerWeekTesting() {
		tmeanPerWeekResponse = weatherService.calculateMeanTempPerWeek("2016-09", "2017-09");
		assertEquals(1090, tmeanPerWeekResponse.getMeanTempPerWeek().size());
	}

	@Test
	public void calculateMeanTempPerMonthTesting() {
		tmeanPerMonthResponse = weatherService.calculateMeanTempPerMonth("2016-09", "2017-09");
		assertEquals(253, tmeanPerMonthResponse.getMeanTempPerMonth().size());
	}
}
