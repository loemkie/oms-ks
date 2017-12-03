package com.oms.service;

import com.oms.entity.BaseEntity;
import com.oms.entity.CusType;

public class CusTypeService extends AbstractDbService<CusType> implements IDbService<CusType> {
	public int save(BaseEntity<CusType> entity) {
		entity.setType(CusType.type);
		super.save(entity);
		return 0;
	}
}
