package com.zzw.service;

import java.util.List;

import com.zzw.pojo.Order;
import com.zzw.pojo.OrderItem;
/**
 * 订单service
 * @author amalien
 *
 */
public interface OrderService {
	//根据用户名查询订单
	public List<Order> selectOrderByUsername(String username);
	//提交订单
	public void addOrder(String username,String typeflag,Order order,OrderItem orderItem);
	//确认收货
	public void updateOrderState(Integer oid);
	//查询所有订单
	public List<Order> selectAll();
	//更改订单状态
	public void changeOrderState(Integer oid,Integer state);
	//删除订单
	public void deleteOrder(Integer oid);
}
