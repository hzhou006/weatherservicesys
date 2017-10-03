package com.weatherservicesys.response;

public class FetchMinMaxByDatesEntity {
	private int id;
	private String cityName;
	private String station;
	private String latitude;
	private String longitude;
	private String elevation;
	private int tMinF;
	private int tMaxF;
	private int tMinC;
	private int tMaxC;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int gettMinF() {
		return tMinF;
	}

	public void settMinF(int tMinF) {
		this.tMinF = tMinF;
	}

	public int gettMaxF() {
		return tMaxF;
	}

	public void settMaxF(int tMaxF) {
		this.tMaxF = tMaxF;
	}

	public int gettMinC() {
		return tMinC;
	}

	public void settMinC(int tMinC) {
		this.tMinC = tMinC;
	}

	public int gettMaxC() {
		return tMaxC;
	}

	public void settMaxC(int tMaxC) {
		this.tMaxC = tMaxC;
	}

}
