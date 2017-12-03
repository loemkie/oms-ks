/**
 * ServiceFactory.java
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

import java.util.Map.Entry;
import java.util.Properties;

import com.oms.exception.ApiException;

/**
 * The Service Factory, please use this class to create client side service stub.
 * 
 * @author @author@ (@author-email@)
 * 
 * @version @version@, $Date: 2010-7-30$
 * 
 */
public class ServiceFactory extends CommonService {

    //    private static final GZIPInInterceptor IN = new GZIPInInterceptor();
    //    private static final GZIPOutInterceptor OUT = new GZIPOutInterceptor();

    /**
     * The default static block, initialize the GZIP threshold.
     */
    /*static {
        OUT.setThreshold(1024);
    }*/

    /**
     * Create ServiceFactory by default properties file: baidu-api.properties
     * @throws ApiException 
     */
    public ServiceFactory() throws ApiException {
        this("/ks-api.properties");
    }

    /**
     * Create ServiceFactory by the given properties file.
     * 
     * @param propertiesFileName
     *            The configuration file name. This file must be put in the classpath.
     * @throws ApiException 
     */
    public ServiceFactory(String propertiesFileName) throws ApiException {
        super();
        Properties props = new Properties();
        try {
            props.load(ServiceFactory.class.getResourceAsStream(propertiesFileName));
            readConfig(props);
        } catch (Exception ioe) {
            log.error("Cannot access the config file [" + propertiesFileName + "].", ioe);
        }
        log.info("Instantiate properties for [" + propertiesFileName + "] was successful.");
    }

    /**
     * Get an instance of ServiceFactory, use <code>baidu-api.properties</code> as the configuration file.
     * 
     * @return ServiceFactory
     * @throws ApiException 
     */
    public static ServiceFactory getInstance() throws ApiException {
        return new ServiceFactory();
    }

    /**
     * Get an instance of ServiceFactory, use the configuration file you provided.
     * 
     * @param propertiesFileName
     * @return ServiceFactory
     * @throws ApiException 
     */
    public static ServiceFactory getInstance(String propertiesFileName) throws ApiException {
        return new ServiceFactory(propertiesFileName);
    }

    public static ServiceFactory getInstance(boolean isSoap) throws ApiException {
        ServiceFactory service = new ServiceFactory();
        return service;
    }

    public static ServiceFactory getInstance(String username, String password, String token, String target)
            throws ApiException {
    	ServiceFactory service = new ServiceFactory();
        return service;
    }

    public static ServiceFactory getInstance(String username, String password, String token, String target,
            boolean isSoap) throws ApiException {
        ServiceFactory service = new ServiceFactory();
        return service;
    }

    // /////////////////////////////////////////////////////////////////////////////
    // Protected or private methods
    // /////////////////////////////////////////////////////////////////////////////

    @SuppressWarnings("unchecked")

    private void readConfig(Properties props) {
        for (Entry<Object, Object> entry : props.entrySet()) {
            String key = entry.getKey().toString();
            String value = entry.getValue().toString();
            super.setConfig(key, value);
        }
    }
}
