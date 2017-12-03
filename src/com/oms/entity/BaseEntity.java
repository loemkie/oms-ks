package com.oms.entity;

import java.io.Serializable;

public abstract class BaseEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;
	String type;//属于哪个美莱
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
