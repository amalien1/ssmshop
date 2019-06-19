package com.zzw.dao;

import com.zzw.pojo.OrderItem;
/**
 * 订单内商品dao
 * @author amalien
 *
 */
public interface OrderItemDao {
	//加入订单内商品
	public void insertOrderItem(OrderItem orderItem);
}
