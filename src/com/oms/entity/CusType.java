package com.oms.entity;
/**
 * 客户类型
 * @author loemkie
 *
 */
public class CusType extends BaseEntity<CusType>{
	private static final long serialVersionUID = 1L;
	public static final String key="typeid";
	public static final String type="1";//客户类型
	Long typeid;// 类型ID，客户类型的唯一标识
	String typename;// 类型名称
	Integer signPic;// 类型标识（小图标类型）

	public Long getTypeid() {
		return typeid;
	}

	public void setTypeid(Long typeid) {
		this.typeid = typeid;
	}

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public int getSignPic() {
		return signPic;
	}

	public void setSignPic(int signPic) {
		this.signPic = signPic;
	}
}
