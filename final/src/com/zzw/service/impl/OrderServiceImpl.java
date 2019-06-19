package com.zzw.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzw.dao.CartDao;
import com.zzw.dao.OrderDao;
import com.zzw.dao.OrderItemDao;
import com.zzw.pojo.CartItem;
import com.zzw.pojo.Order;
import com.zzw.pojo.OrderItem;
import com.zzw.service.OrderService;
@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderDao orderDao;
	@Autowired
	private OrderItemDao orderItemDao;
	@Autowired
	private CartDao cartDao;
	@Override
	public List<Order> selectOrderByUsername(String username) {
		return orderDao.selectOrderByUsername(username);
	}
	@Override
	public void addOrder(String username,String typeflag, Order order, OrderItem orderItem) {
/*		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		simpleDateFormat.format(new Date());*/
		Integer oid;
		order.setUsername(username);
		order.setState(1);
		order.setOrdertime(new Date());
		if("1".equals(typeflag)){//非购物车单件物品
			order.setTotalprice(orderItem.getPrice());
			orderDao.insertOrder(order);
			oid =order.getOid();
			orderItem.setOid(oid);
			orderItemDao.insertOrderItem(orderItem);
		}else if("0".equals(typeflag)){//购物车一起支付
			orderDao.insertOrder(order);
			oid=order.getOid();
			double totalPrice=0;
			List<CartItem> cartItemList = cartDao.selectCartItemByUsername(username);
			for (CartItem cartItem : cartItemList) {
				orderItem.setPimage(cartItem.getPimage());
				orderItem.setPname(cartItem.getPname());
				orderItem.setPrice(cartItem.getPrice());
				orderItem.setCounts(cartItem.getCounts());
				orderItem.setOid(oid);
				System.out.println(orderItem);
				orderItemDao.insertOrderItem(orderItem);
				totalPrice+=cartItem.getPrice();
				System.out.println(cartItem);
			}
			order.setTotalprice(totalPrice);
			System.out.println(order);
			orderDao.updateTotalPrice(order);
		}
	}
	@Override
	public void updateOrderState(Integer oid) {
		orderDao.updateOrderState(oid);
	}
	@Override
	public List<Order> selectAll() {
		return orderDao.selectAll();
	}
	@Override
	public void changeOrderState(Integer oid,Integer state) {
		if(state==1){
			orderDao.updateOrderState(oid);
		}else{
			orderDao.changeOrderState(oid);
		}
	}
	@Override
	public void deleteOrder(Integer oid) {
		orderDao.deleteOrder(oid);
	}

}
