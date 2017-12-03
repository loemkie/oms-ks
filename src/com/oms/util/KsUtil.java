package com.oms.util;

import java.net.URLEncoder;
import java.security.DigestException;
import java.util.Arrays;
import java.util.Date;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;

/**
 * 快商通工具类
 * 
 * @author loemkie
 *
 */
public class KsUtil {
	private static final long serialVersionUID = 1L;
	private static final String APPLICATION_JSON = "application/json";
	private static final String CONTENT_TYPE_TEXT_JSON = "text/json";
	private static final String UTF_8 = "UTF-8";
	public static String createKsSign(String appKey, String appSecret, String token, String timestamp) throws DigestException {
		String[] vs = { appKey, appSecret, token, timestamp };
		Arrays.sort(vs);
		String str = vs[0] + vs[1] + vs[2] + vs[3];
		
		return MD5.SHA1Encode(str);
	}


	public static void httpPostWithJSON(String url, String json) throws Exception {
		// 将JSON进行UTF-8编码,以便传输中文
		String encoderJson = URLEncoder.encode(json, UTF_8);
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(url);
		httpPost.addHeader(HTTP.CONTENT_TYPE, APPLICATION_JSON);

		StringEntity se = new StringEntity(encoderJson);
		se.setContentType(CONTENT_TYPE_TEXT_JSON);
		se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, APPLICATION_JSON));
		httpPost.setEntity(se);
		httpclient.execute(httpPost);
	}
	public static void main(String[] args) {
		String appKey = "f559e1696b494645a5afb2b1b3afaec2";
		String appSecret = "47ba40f1b77c4d3b80a7bf0deb18c9ca";
		String token = "SpQjxP";
//		String timestamp = "1450421849765";
		String timestamp= new Long(new Date().getTime()).toString();
		System.out.println("timestamp:" + timestamp);
		try {
			System.out.println("kssign:" + createKsSign(appKey, appSecret, token, timestamp));
			System.out.println("http://kefu8.kuaishang.cn/bs/ksapi/getCusType.do?ak="+appKey+"&tt="+timestamp+"&kssign="+createKsSign(appKey, appSecret, token, timestamp));
		} catch (DigestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
