package com.weatherservicesys.response;

import java.util.List;

import com.weatherservicesys.util.Info;


public class FetchAllCitysResponse {
    private Info info;
    private List<String> listName;
	public Info getInfo() {
		return info;
	}
	public void setInfo(Info info) {
		this.info = info;
	}
	public List<String> getListName() {
		return listName;
	}
	public void setListName(List<String> listName) {
		this.listName = listName;
	}
    
}
