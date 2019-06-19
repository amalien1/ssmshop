package com.zzw.dao;

import java.util.List;

import com.zzw.pojo.Order;
/**
 * 订单dao
 * @author amalien
 *
 */
public interface OrderDao {
	//根据用户名查询订单信息
	public List<Order> selectOrderByUsername(String username);
	//加入订单
	public Integer insertOrder(Order order);
	//更改商品总价格
	public void updateTotalPrice(Order order);
	//确认收货
	public void updateOrderState(Integer oid);
	//查询所有订单
	public List<Order> selectAll();
	//删除订单
	public void deleteOrder(Integer oid);
	//更改订单状态
	public void changeOrderState(Integer oid);

}
