package com.oms.service;

import com.oms.entity.BaseEntity;

public interface IDbService <T>{
	 public int save(BaseEntity<T> entity);  
}
