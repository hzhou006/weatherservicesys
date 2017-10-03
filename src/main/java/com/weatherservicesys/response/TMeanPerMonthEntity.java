package com.weatherservicesys.response;

public class TMeanPerMonthEntity {
	private int monthNum;
	private String cityName;
	private String station;
	private String latitude;
	private String longitude;
	private String elevation;
	private double tMinMeanF;
	private double tMaxMeanF;
	private double tMinMeanC;
	private double tMaxMeanC;

	public int getMonthNum() {
		return monthNum;
	}

	public void setMonthNum(int monthNum) {
		this.monthNum = monthNum;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	public String getStation() {
		return station;
	}

	public void setStation(String station) {
		this.station = station;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getElevation() {
		return elevation;
	}

	public void setElevation(String elevation) {
		this.elevation = elevation;
	}

	public double gettMinMeanF() {
		return tMinMeanF;
	}

	public void settMinMeanF(double tMinMeanF) {
		this.tMinMeanF = tMinMeanF;
	}

	public double gettMaxMeanF() {
		return tMaxMeanF;
	}

	public void settMaxMeanF(double tMaxMeanF) {
		this.tMaxMeanF = tMaxMeanF;
	}

	public double gettMinMeanC() {
		return tMinMeanC;
	}

	public void settMinMeanC(double tMinMeanC) {
		this.tMinMeanC = tMinMeanC;
	}

	public double gettMaxMeanC() {
		return tMaxMeanC;
	}

	public void settMaxMeanC(double tMaxMeanC) {
		this.tMaxMeanC = tMaxMeanC;
	}

}
