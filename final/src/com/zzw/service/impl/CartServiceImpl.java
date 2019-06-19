package com.zzw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzw.dao.CartDao;
import com.zzw.pojo.Cart;
import com.zzw.pojo.CartItem;
import com.zzw.service.CartService;
@Service
public class CartServiceImpl implements CartService {
	@Autowired
	private CartDao cartDao;
	@Override
	public Cart selectCartByUsername(String username) {
		Cart cart=new Cart();
		List<CartItem> list = cartDao.selectCartItemByUsername(username);
		cart.setList(list);
		double totalPrice=0;
		for (CartItem cartItem : list) {
			totalPrice+=cartItem.getPrice()*cartItem.getCounts();
			System.out.println(cartItem);
		}
		cart.setTotalPrice(totalPrice);
		return cart;
	}
	@Override
	public void addCartItem(String username, Integer pid) {
		if("".equals(cartDao.checkCartItem(username, pid))||null==cartDao.checkCartItem(username, pid)){
			cartDao.addCartItem(username, pid);
		}else{
			cartDao.addCartItemCount(username, pid);
		}
	}
	@Override
	public void deleteCartItem(String username, Integer pid) {
		cartDao.deleteCartItem(username, pid);
	}
	@Override
	public void clearCart(String username) {
		cartDao.clearCart(username);
	}
	

}
