package com.oms.parse;

import java.util.Iterator;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.oms.entity.BaseEntity;
import com.oms.entity.CusType;
import com.oms.entity.VisitorCard;
import com.oms.entity.VisitorInfo;

import net.sf.json.JSONObject;

/**
 * 解析器
 * @author loemkie
 *
 */
public class JsonParser {
	protected static final Log log = LogFactory.getLog(JsonParser.class);
	/**
	 * 转换JSON对象为实体
	 * @param json
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static BaseEntity parse(JSONObject json){
		BaseEntity entity=null;
		if(json.has(CusType.key)){//客户类型特有字段
			entity=new CusType();
		}else if(json.has(VisitorInfo.key)){//访客特有字段
			entity=new VisitorInfo();
		}else if(json.has(VisitorCard.key)){//名片特有字段
			entity=new VisitorCard();
		}
		//拷贝
		copy(entity,json);
		return entity;
	}
	/**
	 * 从JSON对象赋值实体
	 * @param entity
	 * @param json
	 */
	@SuppressWarnings("rawtypes")
	private static void copy(BaseEntity entity,JSONObject json){
		try {
			Iterator iterator = json.keys();
			String key = "";
			while (iterator.hasNext()) {
				key = (String) iterator.next();
				BeanUtils.setProperty(entity, key, json.get(key));
			}
				
		} catch (Exception e) {
			log.error("拷贝属性异常-"+e.getMessage(),e);
		}
	}
	@SuppressWarnings({ "rawtypes", "unused" })
	public static void main(String[] args) {
		String json="{typeid:'1',typename:'0'}";
		JSONObject jsonObject = JSONObject.fromObject(json);
		BaseEntity baseEntity=parse(jsonObject);
	}
}
