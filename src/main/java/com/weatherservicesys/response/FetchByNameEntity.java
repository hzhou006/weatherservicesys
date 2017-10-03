package com.weatherservicesys.response;

public class FetchByNameEntity {
	int id;
	String station;
	String name;
	String latitude;
	String longitude;
	String elevation;
	String date;
	int tmaxF;
	int tminF;
	int tmaxC;
	int tminC;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStation() {
		return station;
	}

	public void setStation(String station) {
		this.station = station;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getTmaxF() {
		return tmaxF;
	}

	public void setTmaxF(int tmaxF) {
		this.tmaxF = tmaxF;
	}

	public int getTminF() {
		return tminF;
	}

	public void setTminF(int tminF) {
		this.tminF = tminF;
	}

	public int getTmaxC() {
		return tmaxC;
	}

	public void setTmaxC(int tmaxC) {
		this.tmaxC = tmaxC;
	}

	public int getTminC() {
		return tminC;
	}

	public void setTminC(int tminC) {
		this.tminC = tminC;
	}

}
