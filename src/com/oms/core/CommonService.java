/**
 * VersionService.java
 *
 * Copyright @year@ @company@, Inc.
 *
 * @company@ licenses this file to you under the Apache License, version 2.0
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

import java.lang.reflect.Field;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;

import com.oms.exception.ApiException;
import com.oms.parse.JsonParser;


/**
 * Internal use only, please ignore.
 * 
 * @author @author@ (@author-email@)
 * 
 * @version @version@, $Date: 2010-7-30$
 * 
 */
public abstract class CommonService implements Config {
	protected static final Log log = LogFactory.getLog(CommonService.class);

    /**
     * Get the client side serivce using the Json protocol.
     * 
     * @param <T>
     *            The service interface
     * @param cls
     *            The service interface
     * @return The client side serivce stub.
     * @throws ApiException 
     * @throws Throwable 
     */
    public final <T> T getJsonService(Class<T> cls) throws ApiException {
        return JsonProxy.createProxy(cls, this);
    }

  

    /**
     * Get the client side serivce stub with the default version.
     * 
     * @param <T>
     *            The service interface
     * @param cls
     *            The service interface
     * @return The client side serivce stub.
     * @throws ApiException 
     * @throws Throwable 
     */
    public final <T> T getService(Class<T> cls) throws ApiException {
        //        if ("SOAP".equalsIgnoreCase(protocol)) {
        //            return getSoapService(cls);
        //        } else {
        return JsonProxy.createProxy(cls, this);
        //        }
    }

    

    /**
     * Please do not call this method directly, it will be called automatically when reading the configuration file.
     * 
     * @param key
     *            The configuration key
     * @param value
     *            The configuration value
     * 
     */
    public void setConfig(String key, String value) {
        try {
        	setField(CommonService.class.getDeclaredField(key), value);
        } catch (Exception e) {
            log.info("Can not set [" + key + "] into config field: " + e.toString());
        }
    }

   
    private void setField(Field field, String value) throws Exception {
        field.setAccessible(true);
        Class<?> cls = field.getType();
        if (cls.equals(int.class)) {
            field.setInt(this, Integer.parseInt(value));
        } else if (cls.equals(long.class)) {
            field.setLong(this, Long.parseLong(value));
        } else if (cls.equals(boolean.class)) {
            field.setBoolean(this, Boolean.parseBoolean(value));
        } else if (cls.equals(Integer.class)) {
            field.set(this, Integer.parseInt(value));
        } else if (cls.equals(Long.class)) {
            field.set(this, Long.parseLong(value));
        } else if (cls.equals(Boolean.class)) {
            field.set(this, Boolean.parseBoolean(value));
        } else {
            field.set(this, value);
        }
    }
}
