package com.zzw.pojo;
/**
 * 订单物品类
 * @author amalien
 *
 */
public class OrderItem {
	private Integer oiid;
	private String pimage;
	private String pname;
	private Double price;
	private Integer counts;
	private Integer oid;
	public Integer getOiid() {
		return oiid;
	}
	public void setOiid(Integer oiid) {
		this.oiid = oiid;
	}
	public String getPimage() {
		return pimage;
	}
	public void setPimage(String pimage) {
		this.pimage = pimage;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getCounts() {
		return counts;
	}
	public void setCounts(Integer counts) {
		this.counts = counts;
	}
	public Integer getOid() {
		return oid;
	}
	public void setOid(Integer oid) {
		this.oid = oid;
	}
	@Override
	public String toString() {
		return "OrderItem [oiid=" + oiid + ", pimage=" + pimage + ", pname=" + pname + ", price=" + price + ", counts="
				+ counts + ", oid=" + oid + "]";
	}
	
}
