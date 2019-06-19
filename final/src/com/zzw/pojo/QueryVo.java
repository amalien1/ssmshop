package com.zzw.pojo;
/**
 * 分页包装类
 * @author amalien
 *
 */
public class QueryVo {
	private String productName;
	private String productType;
	private String productPrice;
	//当前页
	private Integer page=1;
	//每页数
	private Integer size=5;
	//开始行
	private Integer startRow=0;
	//总记录数
	private Integer count;
	//总页数
	private Integer totalPage;
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public Integer getStartRow() {
		return startRow;
	}
	public void setStartRow(Integer startRow) {
		this.startRow = startRow;
	}
	
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	@Override
	public String toString() {
		return "QueryVo [productName=" + productName + ", productType=" + productType + ", productPrice=" + productPrice
				+ ", page=" + page + ", size=" + size + ", startRow=" + startRow + "]";
	}
	
}
