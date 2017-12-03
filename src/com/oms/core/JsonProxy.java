/**
 * JsonProxy.java
 *
 * Copyright 2011 Baidu, Inc.
 *
 * Baidu licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package com.oms.core;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.oms.entity.BaseEntity;
import com.oms.exception.ApiException;
import com.oms.parse.JsonParser;
import com.oms.util.ObjToStringUtil;

import net.sf.json.JSONObject;


/**
 * @author @author@ (@author-email@)
 * 
 * @version @version@, $Date: 2011-5-10$
 * 
 */
public class JsonProxy<I> implements InvocationHandler {
	protected static final Log log = LogFactory.getLog(JsonProxy.class);
    
    private Class<I> interfaces;
    private CommonService service;
    
    /**
     * @param interfaces
     */
    public JsonProxy(Class<I> interfaces, CommonService service) {
        super();
        this.interfaces = interfaces;
        this.service = service;
    }

    /**
     * Create the proxy instance of api client stub. Proxied by JsonProxy.
     * 
     * @param <T> The proxy instannce type.
     * @param interfaces The proxy instannce type class.
     * @param service The original object.
     * @return The proxied object.
     * @throws ApiException 
     * @throws Throwable 
     */
    @SuppressWarnings("unchecked")
    public static <T> T createProxy(Class<T> interfaces, CommonService service) throws ApiException {
        JsonProxy<T> proxy = new JsonProxy<T>(interfaces, service);
        return (T) Proxy.newProxyInstance(JsonProxy.class.getClassLoader(), new Class<?>[]{interfaces},
                proxy);
    }

    /* (non-Javadoc)
     * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[])
     */
    @SuppressWarnings("rawtypes")
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
      //解析并保存到数据库
      JSONObject json=(JSONObject) args[0];
      BaseEntity entity = JsonParser.parse(json);
      log.info("class="+entity.getClass()+ObjToStringUtil.objToString(entity));
      return entity;
    }
    
}
