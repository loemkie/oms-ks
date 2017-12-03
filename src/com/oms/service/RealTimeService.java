/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.18.0.3036 modeling language!*/
package com.oms.service;

import com.oms.entity.BaseEntity;

import net.sf.json.JSONObject;

public interface RealTimeService {
	/**
	 * 解析并保存到数据库
	 * 
	 * @param jsonObject
	 * @return
	 */
	public BaseEntity<?> parse(JSONObject json);
}