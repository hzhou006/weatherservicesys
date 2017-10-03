package com.weatherservicesys.util;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Info")
public class Info {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String code = null;
	@Column(length = 3000)
	private String description = null;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Info() {
	}

	public Info(String code, String description) {
		super();
		this.code = code;
		this.description = description;
	}

}
