package com.oms.entity;

import java.util.List;

public class VisitorInfo extends BaseEntity<VisitorInfo> {
	private static final long serialVersionUID = 1L;
	public static final String key = "visitorName";
	public static final String type="4";//访客信息
	Long recId;// 访客回话信息的唯一标识
	String visitorId;// 访客ID，访客的唯一标识
	String visitorName;// 访客名称
	String curEnterTime;// 当前进入网站时间
	String firstVisitTime;// 最初访问时间
	Long siteId;// 当前会话所属站点ID
	String siteName;// 当前会话所属站点名称
	String curFirstViewPage;// 本次最初访问网页
	String preVisitTime;// 上一次访问时间
	Integer totalVisitTime;// 累计来访次数
	String firstCsId;// 初次接待客服
	String diaPage;// 发起对话网址
	String joinCsIds;// 参与接待客服
	Integer curStayTime;// 访客停留时间（秒 ）
	String sourceIp;// 访客来源IP
	String sourceProvince;// 来源省市
	String sourceIpInfo;// 访客来源IP信息（网络接入商）
	String sourceUrl;// 来源网页
	String sourceType;// 来源类型
	String searchEngine;// 搜索引擎
	String keyword;// 搜索关键词
	String requestType;// 对话请求方式（rt_v：访客请求，rt_c：客服请求，rt_ct：本公司跨站点转接，rt_ot：跨公司转接）
	String endType;// 对话结束方式（et_v_e：访客主动结束，et_c_e：客服主动结束，et_c_r：客服拒绝对话，et_t_s：跨站点转接转出，et_t_c：跨公司转接转出，et_c_o：客服网络断网，et_c_q：客服退出系统，et_d_t：对话状态超时）
	String diaStartTime;// 对话开始时间
	String diaEndTime;// 对话结束时间
	String dialogType;// 对话类型（dt_v_ov：仅访问网站，dt_v_nm：访客无消息，dt_c_na：客服未接受，dt_c_nm：客服无消息，dt_d_o：其他有效对话，dt_d_n：一般对话，dt_d_g：较好对话，dt_d_b：更好/极佳对话）
	String terminalType;// 终端类型（tt_pc：电脑，tt_ppc：平板电脑，tt_mb：手机）
	Integer visitorSendNum;// 访客发送消息数
	Integer csSendNum;// 客服发送消息数
	Integer curVisitorPages;// 当前访问页数
	Integer preVisitPages;// 上次访问页数
	String operatingSystem;// 操作系统
	String browser;// 浏览器
	String info;// 对话说明
	List<Dialog> dialogs;// 对话记录

	public Long getRecId() {
		return recId;
	}

	public void setRecId(Long recId) {
		this.recId = recId;
	}

	public String getVisitorId() {
		return visitorId;
	}

	public void setVisitorId(String visitorId) {
		this.visitorId = visitorId;
	}

	public String getVisitorName() {
		return visitorName;
	}

	public void setVisitorName(String visitorName) {
		this.visitorName = visitorName;
	}

	public String getCurEnterTime() {
		return curEnterTime;
	}

	public void setCurEnterTime(String curEnterTime) {
		this.curEnterTime = curEnterTime;
	}

	public String getFirstVisitTime() {
		return firstVisitTime;
	}

	public void setFirstVisitTime(String firstVisitTime) {
		this.firstVisitTime = firstVisitTime;
	}

	public Long getSiteId() {
		return siteId;
	}

	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public String getCurFirstViewPage() {
		return curFirstViewPage;
	}

	public void setCurFirstViewPage(String curFirstViewPage) {
		this.curFirstViewPage = curFirstViewPage;
	}

	public String getPreVisitTime() {
		return preVisitTime;
	}

	public void setPreVisitTime(String preVisitTime) {
		this.preVisitTime = preVisitTime;
	}

	public Integer getTotalVisitTime() {
		return totalVisitTime;
	}

	public void setTotalVisitTime(Integer totalVisitTime) {
		this.totalVisitTime = totalVisitTime;
	}

	public String getFirstCsId() {
		return firstCsId;
	}

	public void setFirstCsId(String firstCsId) {
		this.firstCsId = firstCsId;
	}

	public String getDiaPage() {
		return diaPage;
	}

	public void setDiaPage(String diaPage) {
		this.diaPage = diaPage;
	}

	public String getJoinCsIds() {
		return joinCsIds;
	}

	public void setJoinCsIds(String joinCsIds) {
		this.joinCsIds = joinCsIds;
	}

	public Integer getCurStayTime() {
		return curStayTime;
	}

	public void setCurStayTime(Integer curStayTime) {
		this.curStayTime = curStayTime;
	}

	public String getSourceIp() {
		return sourceIp;
	}

	public void setSourceIp(String sourceIp) {
		this.sourceIp = sourceIp;
	}

	public String getSourceProvince() {
		return sourceProvince;
	}

	public void setSourceProvince(String sourceProvince) {
		this.sourceProvince = sourceProvince;
	}

	public String getSourceIpInfo() {
		return sourceIpInfo;
	}

	public void setSourceIpInfo(String sourceIpInfo) {
		this.sourceIpInfo = sourceIpInfo;
	}

	public String getSourceUrl() {
		return sourceUrl;
	}

	public void setSourceUrl(String sourceUrl) {
		this.sourceUrl = sourceUrl;
	}

	public String getSourceType() {
		return sourceType;
	}

	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
	}

	public String getSearchEngine() {
		return searchEngine;
	}

	public void setSearchEngine(String searchEngine) {
		this.searchEngine = searchEngine;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	public String getEndType() {
		return endType;
	}

	public void setEndType(String endType) {
		this.endType = endType;
	}

	public String getDiaStartTime() {
		return diaStartTime;
	}

	public void setDiaStartTime(String diaStartTime) {
		this.diaStartTime = diaStartTime;
	}

	public String getDiaEndTime() {
		return diaEndTime;
	}

	public void setDiaEndTime(String diaEndTime) {
		this.diaEndTime = diaEndTime;
	}

	public String getDialogType() {
		return dialogType;
	}

	public void setDialogType(String dialogType) {
		this.dialogType = dialogType;
	}

	public String getTerminalType() {
		return terminalType;
	}

	public void setTerminalType(String terminalType) {
		this.terminalType = terminalType;
	}

	public Integer getVisitorSendNum() {
		return visitorSendNum;
	}

	public void setVisitorSendNum(Integer visitorSendNum) {
		this.visitorSendNum = visitorSendNum;
	}

	public Integer getCsSendNum() {
		return csSendNum;
	}

	public void setCsSendNum(Integer csSendNum) {
		this.csSendNum = csSendNum;
	}

	public Integer getCurVisitorPages() {
		return curVisitorPages;
	}

	public void setCurVisitorPages(Integer curVisitorPages) {
		this.curVisitorPages = curVisitorPages;
	}

	public Integer getPreVisitPages() {
		return preVisitPages;
	}

	public void setPreVisitPages(Integer preVisitPages) {
		this.preVisitPages = preVisitPages;
	}

	public String getOperatingSystem() {
		return operatingSystem;
	}

	public void setOperatingSystem(String operatingSystem) {
		this.operatingSystem = operatingSystem;
	}

	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public List<Dialog> getDialogs() {
		return dialogs;
	}

	public void setDialogs(List<Dialog> dialogs) {
		this.dialogs = dialogs;
	}
}
