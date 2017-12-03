package com.oms.http.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Map.Entry;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.oms.core.DbFactory;
import com.oms.core.ServiceFactory;
import com.oms.entity.BaseEntity;
import com.oms.service.IDbService;
import com.oms.service.RealTimeService;
import com.oms.util.KsUtil;
import com.oms.util.StreamUtil;

import net.sf.json.JSONObject;

/**
 * 快商通数据
 * @author loemkie
 *
 */
public class JsonServlet2 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected static final Log log = LogFactory.getLog(JsonServlet2.class);
	private static ServiceFactory factory;
	private static DbFactory dbFactory;
	private static RealTimeService realTimeService;
	@SuppressWarnings("rawtypes")
	private static IDbService dbService;
	private static String url="";
	//初始化url
	static{
		Properties props = new Properties();
		String filePath="/ks-api.properties";
        try {
            props.load(JsonServlet2.class.getResourceAsStream(filePath));
            readConfig(props);
        } catch (Exception ioe) {
            log.error("Cannot access the config file [" + filePath + "].", ioe);
        }
	}
	 @SuppressWarnings("unchecked")

    private static void readConfig(Properties props) {
        for (Entry<Object, Object> entry : props.entrySet()) {
            String key = entry.getKey().toString();
            String value = entry.getValue().toString();
            if("push_url".equals(key)){
            	url=value;
            }
        }
    }
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			response.setContentType("text/html;charset=utf-8");
			request.setCharacterEncoding("utf-8");
			log.info("server:"+request.getServerName()+",ip:"+request.getRemoteAddr()+"-"+new Date().toString()+" 接收开始..");
			PrintWriter out = response.getWriter();
			//转发
			String json=StreamUtil.streamToString(request.getInputStream());
			KsUtil.httpPostWithJSON(url, json);
			out.println("ok");
			out.flush();
			out.close();
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			e.printStackTrace();
		}
	}
	/*@SuppressWarnings({ "unchecked", "rawtypes" })
	public void doPostBack(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			factory = ServiceFactory.getInstance();
			dbFactory = DbFactory.getInstance();
			realTimeService = factory.getService(RealTimeService.class);
			response.setContentType("text/html;charset=utf-8");
			request.setCharacterEncoding("utf-8");
			log.info("server:"+request.getServerName()+",ip:"+request.getRemoteAddr()+"-"+new Date().toString()+" 接收开始..");
			PrintWriter out = response.getWriter();
			String jsonData=StreamUtil.streamToString(request.getInputStream());
			jsonData="data={\"addtime\":\"2017-05-25 14:03:00\",\"compId\":120935,\"compName\":\"方-除皱-无创-浙江杭州\",\"cusType\":-1,\"lastChangeTime\":\"2017-05-25 14:03:00\",\"linkman\":\"方-除皱-无创-浙江杭州\",\"visitorId\":\"24d89e4c54ea4609861ff1d23a8c73dc\",\"loginName\":\"杭州美莱客服Miss胡\",\"userName\":\"黄雪燕\",\"nickName\":\"美丽顾问MS.胡.热线-微信17757170164\"}";
			log.info(jsonData);
			BaseEntity entity=null;
			if(StringUtils.isNotBlank(jsonData)){
				//1.解析成JSON对象
				JSONObject json = JSONObject.fromObject(jsonData.substring(5));
				//2.解析JSON对象为对应的实体类
				entity=realTimeService.parse(json);
				dbService=dbFactory.getService(entity);
				dbService.save(entity);
			}
			//log.error(json.toString());
			out.println("ok");
			out.flush();
			out.close();
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		}
	}
	*/
	public void destroy() {
		super.destroy();
	}
	public void init() throws ServletException {
	}
}
