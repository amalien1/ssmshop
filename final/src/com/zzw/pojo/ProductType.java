package com.zzw.pojo;
/**
 * 商品类型类
 * @author amalien
 *
 */
public class ProductType {
	private Integer id;
	private String typename;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTypename() {
		return typename;
	}
	public void setTypename(String typename) {
		this.typename = typename;
	}
	@Override
	public String toString() {
		return "ProductType [id=" + id + ", typename=" + typename + "]";
	}
	
}
