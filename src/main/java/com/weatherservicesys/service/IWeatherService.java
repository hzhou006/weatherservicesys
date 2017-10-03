package com.weatherservicesys.service;

import com.weatherservicesys.response.FetchAllCitysResponse;
import com.weatherservicesys.response.FetchByNameResponse;
import com.weatherservicesys.response.FetchMinMaxByDatesResponse;
import com.weatherservicesys.response.TMeanPerMonthResponse;
import com.weatherservicesys.response.TMeanPerWeekResponse;

public interface IWeatherService {
	 
     public FetchAllCitysResponse fetchAllCitys();
     
     public FetchByNameResponse fetchByName(String name);
     
     public FetchMinMaxByDatesResponse FetchMinMaxByDates(String start, String end);
     
     public TMeanPerWeekResponse calculateMeanTempPerWeek(String start, String end);
     
     public TMeanPerMonthResponse calculateMeanTempPerMonth(String start, String end);
     
}
