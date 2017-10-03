package com.weatherservicesys.response;

import java.util.List;

import com.weatherservicesys.util.Info;


public class TMeanPerMonthResponse {
	private Info info;
	private List<TMeanPerMonthEntity> meanTempPerMonth;

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

	public List<TMeanPerMonthEntity> getMeanTempPerMonth() {
		return meanTempPerMonth;
	}

	public void setMeanTempPerMonth(List<TMeanPerMonthEntity> meanTempPerMonth) {
		this.meanTempPerMonth = meanTempPerMonth;
	}

}
