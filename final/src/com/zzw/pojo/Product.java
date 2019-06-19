package com.zzw.pojo;

/**
 * 商品类
 * @author amalien
 *
 */
public class Product {
	private Integer id;
	private String pname;
	private String ptype;
	private String price;
	private String pimage;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPtype() {
		return ptype;
	}
	public void setPtype(String ptype) {
		this.ptype = ptype;
	}
	

	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getPimage() {
		return pimage;
	}
	public void setPimage(String pimage) {
		this.pimage = pimage;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", pname=" + pname + ", ptype=" + ptype + ", price=" + price + ", pimage=" + pimage
				+ "]";
	}

	
}
