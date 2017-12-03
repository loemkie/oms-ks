package com.oms.service;

import com.oms.entity.BaseEntity;
import com.oms.entity.VisitorInfo;

public class VisitorInfoService extends AbstractDbService<VisitorInfo> implements IDbService<VisitorInfo> {
	public int save(BaseEntity<VisitorInfo> entity) {
		entity.setType(VisitorInfo.type);
		super.save(entity);
		return 0;
	}
}
