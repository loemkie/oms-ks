package com.oms.service;

import com.oms.entity.BaseEntity;
import com.oms.entity.VisitorCard;

public class VisitorCardService extends AbstractDbService<VisitorCard> implements IDbService<VisitorCard> {
	public int save(BaseEntity<VisitorCard> entity) {
		entity.setType(VisitorCard.type);
		super.save(entity);
		return 0;
	}
}
