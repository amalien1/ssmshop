package com.zzw.pojo;
/**
 * 购物车内商品类
 * @author amalien
 *
 */
public class CartItem {
	private Integer pid;
	private String pimage;
	private String pname;
	private Double price;
	private Integer counts;
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
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
	public void setCounts(Integer count) {
		this.counts = count;
	}
	@Override
	public String toString() {
		return "CartItem [pid=" + pid + ", pimage=" + pimage + ", pname=" + pname + ", price=" + price + ", count="
				+ counts + "]";
	}
	public CartItem(Integer pid, String pimage, String pname, Double price, Integer counts) {
		super();
		this.pid = pid;
		this.pimage = pimage;
		this.pname = pname;
		this.price = price;
		this.counts = counts;
	}
	public CartItem() {
		super();
	}
	
}
