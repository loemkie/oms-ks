package com.oms.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.log4j.Logger;

/**
 * <pre>
 * Java 常用流处理工具
 * </pre>
 * 
 * @project baidamei
 * @author cevencheng <cevencheng@gmail.com>
 * @create 2012-11-29 下午5:17:32
 */
public class StreamUtil {
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(StreamUtil.class);
	/**
	 * 将流另存为文件
	 * 
	 * @param is
	 * @param outfile
	 */
	public void streamSaveAsFile(InputStream is, File outfile) {
		FileOutputStream fos = null;
		try {
			File file = outfile;
			fos = new FileOutputStream(file);
			byte[] buffer = new byte[1024];
			int len;
			while((len = is.read(buffer)) > 0){
				fos.write(buffer, 0, len);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			try {
				is.close();
				fos.close();
			} catch (Exception e2) {
				e2.printStackTrace();
				throw new RuntimeException(e2);
			}
		}
	}
	/**
	 * Read an input stream into a string
	 * @param in
	 * @return
	 * @throws IOException
	 */
	public static String streamToString(InputStream in) throws IOException {
		StringBuffer out = new StringBuffer();
		byte[] b = new byte[4096];
		for (int n; (n = in.read(b)) != -1;) {
			out.append(new String(b, 0, n));
		}
		return java.net.URLDecoder.decode(out.toString(),"utf-8");
	}
	public static byte[] stream2Byte(InputStream is) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		int len = 0;
		byte[] b = new byte[1024];
		while ((len = is.read(b, 0, b.length)) != -1) {                     
		    baos.write(b, 0, len);
		}
		byte[] buffer =  baos.toByteArray();
		return buffer;
	}
	/** 
     * @方法功能 InputStream 转为 byte 
     * @param InputStream 
     * @return 字节数组 
     * @throws Exception 
     */  
    public static byte[] inputStream2Byte(InputStream inStream)  
            throws Exception {  
        // ByteArrayOutputStream outSteam = new ByteArrayOutputStream();  
        // byte[] buffer = new byte[1024];  
        // int len = -1;  
        // while ((len = inStream.read(buffer)) != -1) {  
        // outSteam.write(buffer, 0, len);  
        // }  
        // outSteam.close();  
        // inStream.close();  
        // return outSteam.toByteArray();  
        int count = 0;  
        while (count == 0) {  
            count = inStream.available();  
        }  
        byte[] b = new byte[count];  
        inStream.read(b);  
        return b;  
    }  
  
    /** 
     * @方法功能 byte 转为 InputStream 
     * @param 字节数组 
     * @return InputStream 
     * @throws Exception 
     */  
    public static InputStream byte2InputStream(byte[] b) throws Exception {  
        InputStream is = new ByteArrayInputStream(b);  
        return is;  
    }  
  
    /** 
     * @功能 短整型与字节的转换 
     * @param 短整型 
     * @return 两位的字节数组 
     */  
    public static byte[] shortToByte(short number) {  
        int temp = number;  
        byte[] b = new byte[2];  
        for (int i = 0; i < b.length; i++) {  
            b[i] = new Integer(temp & 0xff).byteValue();// 将最低位保存在最低位  
            temp = temp >> 8; // 向右移8位  
        }  
        return b;  
    }  
  
    /** 
     * @功能 字节的转换与短整型 
     * @param 两位的字节数组 
     * @return 短整型 
     */  
    public static short byteToShort(byte[] b) {  
        short s = 0;  
        short s0 = (short) (b[0] & 0xff);// 最低位  
        short s1 = (short) (b[1] & 0xff);  
        s1 <<= 8;  
        s = (short) (s0 | s1);  
        return s;  
    }  
  
    /** 
     * @方法功能 整型与字节数组的转换 
     * @param 整型 
     * @return 四位的字节数组 
     */  
    public static byte[] intToByte(int i) {  
        byte[] bt = new byte[4];  
        bt[0] = (byte) (0xff & i);  
        bt[1] = (byte) ((0xff00 & i) >> 8);  
        bt[2] = (byte) ((0xff0000 & i) >> 16);  
        bt[3] = (byte) ((0xff000000 & i) >> 24);  
        return bt;  
    }  
  
    /** 
     * @方法功能 字节数组和整型的转换 
     * @param 字节数组 
     * @return 整型 
     */  
    public static int bytesToInt(byte[] bytes) {  
        int num = bytes[0] & 0xFF;  
        num |= ((bytes[1] << 8) & 0xFF00);  
        num |= ((bytes[2] << 16) & 0xFF0000);  
        num |= ((bytes[3] << 24) & 0xFF000000);  
        return num;  
    }  
  
    /** 
     * @方法功能 字节数组和长整型的转换 
     * @param 字节数组 
     * @return 长整型 
     */  
    public static byte[] longToByte(long number) {  
        long temp = number;  
        byte[] b = new byte[8];  
        for (int i = 0; i < b.length; i++) {  
            b[i] = new Long(temp & 0xff).byteValue();  
            // 将最低位保存在最低位  
            temp = temp >> 8;  
            // 向右移8位  
        }  
        return b;  
    }  
  
    /** 
     * @方法功能 字节数组和长整型的转换 
     * @param 字节数组 
     * @return 长整型 
     */  
    public static long byteToLong(byte[] b) {  
        long s = 0;  
        long s0 = b[0] & 0xff;// 最低位  
        long s1 = b[1] & 0xff;  
        long s2 = b[2] & 0xff;  
        long s3 = b[3] & 0xff;  
        long s4 = b[4] & 0xff;// 最低位  
        long s5 = b[5] & 0xff;  
        long s6 = b[6] & 0xff;  
        long s7 = b[7] & 0xff; // s0不变  
        s1 <<= 8;  
        s2 <<= 16;  
        s3 <<= 24;  
        s4 <<= 8 * 4;  
        s5 <<= 8 * 5;  
        s6 <<= 8 * 6;  
        s7 <<= 8 * 7;  
        s = s0 | s1 | s2 | s3 | s4 | s5 | s6 | s7;  
        return s;  
    }
    public static void main(String[] args) {
		String data="%7B%22recId%22%3A636063670%2C%22visitorId%22%3A%22c1f7fae4b5c04791a7a14df28c142f79%22%2C%22visitorName%22%3A%22%E6%B5%99%E6%B1%9F%E6%9D%AD%E5%B7%9E%7C%E5%8F%A3%E8%85%94%22%2C%22curEnterTime%22%3A%222017-05-25+09%3A26%3A19%22%2C%22curStayTime%22%3A62%2C%22sourceIp%22%3A%22115.192.75.27%22%2C%22sourceProvince%22%3A%22%E6%B5%99%E6%B1%9F%E6%9D%AD%E5%B7%9E%22%2C%22sourceIpInfo%22%3A%22%E7%94%B5%E4%BF%A1%22%2C%22requestType%22%3A%22rt_v%22%2C%22endType%22%3A%22et_v_e%22%2C%22diaStartTime%22%3A%222017-05-25+09%3A26%3A20%22%2C%22diaEndTime%22%3A%222017-05-25+09%3A27%3A21%22%2C%22terminalType%22%3A%22tt_mb%22%2C%22visitorSendNum%22%3A0%2C%22csSendNum%22%3A2%2C%22sourceUrl%22%3A%22http%3A%2F%2Fm.xhmylike.cn%2Fzt%2Fycjz%2F%3Fkqzx-jz-19630%22%2C%22sourceType%22%3A%22%E6%9C%AC%E7%AB%99%E9%93%BE%E6%8E%A5%22%2C%22searchEngine%22%3A%22%22%2C%22keyword%22%3A%22%22%2C%22firstCsId%22%3A%22%E6%9D%AD%E5%B7%9E%E7%BE%8E%E8%8E%B1%E5%8F%A3%E8%85%94%E4%BD%99%E5%8C%BB%E7%94%9F%5B%E6%9D%AD%E5%B7%9E%E7%BE%8E%E8%8E%B1%E5%8F%A3%E8%85%94%E4%BD%99%E5%8C%BB%E7%94%9F%EF%BC%88%E7%94%B5%E8%AF%9D%E4%B9%9F%E6%98%AF%E5%BE%AE%E4%BF%A1%EF%BC%9A15397127623%EF%BC%89%5D%22%2C%22joinCsIds%22%3A%22%E6%9D%AD%E5%B7%9E%E7%BE%8E%E8%8E%B1%E5%8F%A3%E8%85%94%E4%BD%99%E5%8C%BB%E7%94%9F%5B%E6%9D%AD%E5%B7%9E%E7%BE%8E%E8%8E%B1%E5%8F%A3%E8%85%94%E4%BD%99%E5%8C%BB%E7%94%9F%EF%BC%88%E7%94%B5%E8%AF%9D%E4%B9%9F%E6%98%AF%E5%BE%AE%E4%BF%A1%EF%BC%9A15397127623%EF%BC%89%5D%22%2C%22dialogType%22%3A%22dt_v_nm%22%2C%22firstVisitTime%22%3A%222017-05-25+09%3A26%3A19%22%2C%22preVisitTime%22%3A%22%22%2C%22totalVisitTime%22%3A1%2C%22diaPage%22%3A%22http%3A%2F%2Fm.xhmylike.cn%2Fzt%2Fycjz%2F%3Fkqzx-jz-19630%22%2C%22curFirstViewPage%22%3A%22http%3A%2F%2Fm.xhmylike.cn%2Fzt%2Fycjz%2F%3Fkqzx-jz-19630%22%2C%22curVisitorPages%22%3A1%2C%22preVisitPages%22%3A0%2C%22operatingSystem%22%3A%22iPhone%22%2C%22browser%22%3A%22Safari+10.0%22%2C%22info%22%3A%22%22%2C%22siteName%22%3A%22%E6%9D%AD%E5%B7%9E%E7%BE%8E%E8%8E%B1%E5%8F%A3%E8%85%94%E5%AE%98%E7%BD%91%22%2C%22siteId%22%3A30310%2C%22dialogs%22%3A%5B%7B%22addTime%22%3A%222017-05-25+09%3A26%3A27%22%2C%22dialogId%22%3A%22%22%2C%22id%22%3A690965835%2C%22recContent%22%3A%22%3Cspan+style%3D%5C%22color%3A%23000000%3Bfont-size%3A14px%3Bfont-family%3A%E5%BE%AE%E8%BD%AF%E9%9B%85%E9%BB%91%3B%5C%22%3E%3CFONT+size%3D3%3E%E6%82%A8%E5%A5%BD%EF%BC%81%E8%BF%99%E9%87%8C%E6%98%AF%E6%9D%AD%E5%B7%9E%E7%BE%8E%E8%8E%B1%E5%8F%A3%E8%85%94%E5%9C%A8%E7%BA%BF%3CFONT+color%3D%23ff0033%3E%E5%92%A8%E8%AF%A2%3C%5C%2FFONT%3E%E5%92%8C%3CFONT+color%3D%23ff0033%3E%E9%A2%84%E7%BA%A6%E4%B8%93%E5%AE%B6%3CFONT+color%3D%23000033%3E%E5%B9%B3%E5%8F%B0%3C%5C%2FFONT%3E%3C%5C%2FFONT%3E%EF%BC%8C%E6%88%91%E6%98%AF%E4%BD%99%E5%8C%BB%E7%94%9F%EF%BC%8C%E8%AF%B7%E9%97%AE%E6%9C%89%E4%BB%80%E4%B9%88%E5%8F%AF%E4%BB%A5%E5%B8%AE%E5%88%B0%E6%82%A8%EF%BC%9F%3C%5C%2FFONT%3E%3C%5C%2Fspan%3E%22%2C%22recId%22%3A636063670%2C%22recType%22%3A2%2C%22sender%22%3A%22%E6%9D%AD%E5%B7%9E%E7%BE%8E%E8%8E%B1%E5%8F%A3%E8%85%94%E4%BD%99%E5%8C%BB%E7%94%9F%EF%BC%88%E7%94%B5%E8%AF%9D%E4%B9%9F%E6%98%AF%E5%BE%AE%E4%BF%A1%EF%BC%9A15397127623%EF%BC%89%22%7D%2C%7B%22addTime%22%3A%222017-05-25+09%3A26%3A20%22%2C%22dialogId%22%3A%22%22%2C%22id%22%3A690965763%2C%22recContent%22%3A%22%3CDIV%3E%E6%82%A8%E5%A5%BD%EF%BC%8C%E6%88%91%E6%98%AF%E6%9D%AD%E5%B7%9E%E7%BE%8E%E8%8E%B1%E5%8F%A3%E8%85%94%E4%BD%99%E5%8C%BB%E7%94%9F%EF%BC%8C%E4%B8%BA%E6%82%A8%E6%8F%90%E4%BE%9B%E5%85%8D%E8%B4%B9%E5%9C%A8%E7%BA%BF%E5%92%A8%E8%AF%A2%EF%BC%88%E5%BE%AE%E4%BF%A1%EF%BC%9A%3CFONT+color%3D%23cc0033%3E15397127623%3C%5C%2FFONT%3E%E3%80%81QQ%EF%BC%9A%3CFONT+color%3D%23cc0033%3E2681074417%3C%5C%2FFONT%3E%EF%BC%8C%E5%A6%82%E9%9C%80%E8%A6%81%E7%94%B5%E8%AF%9D%E6%B2%9F%E9%80%9A%EF%BC%8C%E8%AF%B7%E7%95%99%E4%B8%8B%E5%A7%93%E5%90%8D%E5%92%8C%E8%81%94%E7%B3%BB%E6%96%B9%E5%BC%8F%EF%BC%8C%E6%88%91%E4%BC%9A%E7%AC%AC%E4%B8%80%E6%97%B6%E9%97%B4%E5%9B%9E%E7%94%B5%E6%82%A8%EF%BC%81%EF%BC%89%26nbsp%3B+%3C%5C%2FDIV%3E%22%2C%22recId%22%3A636063670%2C%22recType%22%3A2%2C%22sender%22%3A%22%E6%9D%AD%E5%B7%9E%E7%BE%8E%E8%8E%B1%E5%8F%A3%E8%85%94%E4%BD%99%E5%8C%BB%E7%94%9F%EF%BC%88%E7%94%B5%E8%AF%9D%E4%B9%9F%E6%98%AF%E5%BE%AE%E4%BF%A1%EF%BC%9A15397127623%EF%BC%89%22%7D%2C%7B%22addTime%22%3A%222017-05-25+09%3A26%3A19%22%2C%22dialogId%22%3A%22%22%2C%22id%22%3A690965750%2C%22recContent%22%3A%22%E5%81%9C%E7%95%990%E5%88%860%E7%A7%92%E5%90%8E+09%3A26%3A19+%E4%BB%8E%3A%3Ca+href%3Dhttp%3A%2F%2Fm.xhmylike.cn%2Fzt%2Fycjz%2F%3Fkqzx-jz-19630+title%3Dhttp%3A%2F%2Fm.xhmylike.cn%2Fzt%2Fycjz%2F%3Fkqzx-jz-19630+target%3D_blank%3E%2Fzt%2Fycjz%2F%3C%5C%2Fa%3E++%E8%BF%9B%E5%85%A5%3A%3Ca+href%3Dhttp%3A%2F%2Fm.xhmylike.cn%2Fzt%2Fycjz%2F%3Fkqzx-jz-19630+target%3D_blank+title%3D%5C%22http%3A%2F%2Fm.xhmylike.cn%2Fzt%2Fycjz%2F%3Fkqzx-jz-19630%5C%22%3E%2Fzt%2Fycjz%2F+%5B%3Fkqzx-jz-19630%5D%3C%5C%2Fa%3E+%22%2C%22recId%22%3A636063670%2C%22recType%22%3A4%2C%22sender%22%3A%22%22%7D%2C%7B%22addTime%22%3A%222017-05-25+09%3A26%3A19%22%2C%22dialogId%22%3A%22%22%2C%22id%22%3A690965751%2C%22recContent%22%3A%22+%E6%9D%AD%E5%B7%9E%E7%BE%8E%E8%8E%B1%E5%8F%A3%E8%85%94%E4%BD%99%E5%8C%BB%E7%94%9F%EF%BC%88%E7%94%B5%E8%AF%9D%E4%B9%9F%E6%98%AF%E5%BE%AE%E4%BF%A1%EF%BC%9A15397127623%EF%BC%89+%E6%AD%A3%E5%9C%A8%E4%B8%BA%E6%82%A8%E6%9C%8D%E5%8A%A1%22%2C%22recId%22%3A636063670%2C%22recType%22%3A3%2C%22sender%22%3A%22%22%7D%5D%7D";
		try {
			data=java.net.URLDecoder.decode(data,"utf-8");
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		} 
		System.out.println(data);
	}
}

	    			