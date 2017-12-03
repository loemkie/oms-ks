package com.oms.entity;
/**
 * 对话信息
 * @author loemkie
 *
 */
public class Dialog extends BaseEntity<Dialog>{
	private static final long serialVersionUID = 1L;
	public static final String type="2";//对话记录
	Long id;// 对话记录ID
	Long recId;// 访客信息ID
	Integer recType;// 消息类型（1：访客消息，2：客服消息，3：系统消息，4：访问轨迹，5：机器人消息）
	String sender;// 消息发送者
	String addTime;// 消息发送时间
	String recContent;// 消息内容
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getRecId() {
		return recId;
	}
	public void setRecId(Long recId) {
		this.recId = recId;
	}
	public Integer getRecType() {
		return recType;
	}
	public void setRecType(Integer recType) {
		this.recType = recType;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getAddTime() {
		return addTime;
	}
	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}
	public String getRecContent() {
		return recContent;
	}
	public void setRecContent(String recContent) {
		this.recContent = recContent;
	}

	

}
