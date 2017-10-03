package com.weatherservicesys.response;

import java.util.List;

import com.weatherservicesys.util.Info;


public class FetchByNameResponse {
	private Info info;
    private List<FetchByNameEntity> weatherData;
	public Info getInfo() {
		return info;
	}
	public void setInfo(Info info) {
		this.info = info;
	}
	public List<FetchByNameEntity> getWeatherData() {
		return weatherData;
	}
	public void setWeatherData(List<FetchByNameEntity> weatherData) {
		this.weatherData = weatherData;
	}
	
}
