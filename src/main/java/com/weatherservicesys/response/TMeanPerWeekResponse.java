package com.weatherservicesys.response;

import java.util.List;

import com.weatherservicesys.util.Info;

public class TMeanPerWeekResponse {
	private Info info;
	private List<TMeanPerWeekEntity> meanTempPerWeek;

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

	public List<TMeanPerWeekEntity> getMeanTempPerWeek() {
		return meanTempPerWeek;
	}

	public void setMeanTempPerWeek(List<TMeanPerWeekEntity> meanTempPerWeek) {
		this.meanTempPerWeek = meanTempPerWeek;
	}

}
