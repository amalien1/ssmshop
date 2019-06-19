package com.zzw.pojo;

import java.util.List;
/**
 * 购物车类
 * @author amalien
 *
 */
public class Cart {
	private Double totalPrice;
	private List<CartItem> list;
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public List<CartItem> getList() {
		return list;
	}
	public void setList(List<CartItem> list) {
		this.list = list;
	}
	
}
