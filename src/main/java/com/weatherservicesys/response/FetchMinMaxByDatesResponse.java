package com.weatherservicesys.response;

import java.util.List;

import com.weatherservicesys.util.Info;


public class FetchMinMaxByDatesResponse {
	private Info info;
    private List<FetchMinMaxByDatesEntity> list;
	public Info getInfo() {
		return info;
	}
	public void setInfo(Info info) {
		this.info = info;
	}
	public List<FetchMinMaxByDatesEntity> getList() {
		return list;
	}
	public void setList(List<FetchMinMaxByDatesEntity> list) {
		this.list = list;
	}

}
