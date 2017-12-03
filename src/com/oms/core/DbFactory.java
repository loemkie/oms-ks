package com.oms.core;

import com.oms.entity.BaseEntity;
import com.oms.entity.CusType;
import com.oms.entity.VisitorCard;
import com.oms.entity.VisitorInfo;
import com.oms.exception.ApiException;
import com.oms.exception.DbException;
import com.oms.service.CusTypeService;
import com.oms.service.IDbService;
import com.oms.service.VisitorCardService;
import com.oms.service.VisitorInfoService;

public class DbFactory {
	 /**
     * Get an instance of ServiceFactory, use <code>baidu-api.properties</code> as the configuration file.
     * 
     * @return ServiceFactory
     * @throws ApiException 
     */
    public static DbFactory getInstance() throws DbException {
        return new DbFactory();
    }
    @SuppressWarnings("rawtypes")
	public final  IDbService getService(BaseEntity entity) throws ApiException {
    	IDbService service = null;
    	if(entity instanceof CusType){
    		service = new CusTypeService();
    	}
    	else if(entity instanceof VisitorCard){
    		service = new VisitorCardService();
    	}
    	else if(entity instanceof VisitorInfo){
    		service = new VisitorInfoService();
    	}
    	return service;
    }
}
