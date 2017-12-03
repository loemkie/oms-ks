package com.oms.service;

import com.oms.entity.BaseEntity;

public abstract class AbstractDbService<T> {
	public int save(BaseEntity<T> entity) {
		//DbUtil.save(entity);
		return 0;
	}
}
