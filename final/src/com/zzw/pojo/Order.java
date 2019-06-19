package com.zzw.pojo;

import java.util.Date;
import java.util.List;
/**
 * 订单类
 * @author amalien
 *
 */
public class Order {
	private Integer oid;
	private String name;
	private String address;
	private String phone;
	private Double totalprice;
	private Integer state;
	private String username;
	private Date ordertime;
	private List<OrderItem> orderItemList;
	private String stringTime;
	
	public String getStringTime() {
		return stringTime;
	}
	public void setStringTime(String stringTime) {
		this.stringTime = stringTime;
	}
	public Integer getOid() {
		return oid;
	}
	public void setOid(Integer oid) {
		this.oid = oid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Double getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(Double totalprice) {
		this.totalprice = totalprice;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public List<OrderItem> getOrderItemList() {
		return orderItemList;
	}
	public void setOrderItemList(List<OrderItem> orderItemList) {
		this.orderItemList = orderItemList;
	}

	public Date getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}
	@Override
	public String toString() {
		return "Order [oid=" + oid + ", name=" + name + ", address=" + address + ", phone=" + phone + ", totalprice="
				+ totalprice + ", state=" + state + ", username=" + username + ", odertime=" + ordertime + "]";
	}

	
	
}
