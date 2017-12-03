package com.oms.service;

import com.oms.entity.BaseEntity;
import com.oms.entity.Dialog;

public class DialogService extends AbstractDbService<Dialog> implements IDbService<Dialog> {
	public int save(BaseEntity<Dialog> entity) {
		entity.setType(Dialog.type);
		super.save(entity);
		return 0;
	}
}
