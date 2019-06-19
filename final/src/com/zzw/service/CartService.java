package com.zzw.service;

import com.zzw.pojo.Cart;
/**
 * 购物车service
 * @author amalien
 *
 */
public interface CartService {
	//根据用户名查询购物车对象
	public Cart selectCartByUsername(String username);
	//用户商品添加至购物车
	public void addCartItem(String username,Integer pid);
	//从购物车中删除一个商品
	public void deleteCartItem(String username,Integer pid);
	//清空购物车
	public void clearCart(String username);
}
