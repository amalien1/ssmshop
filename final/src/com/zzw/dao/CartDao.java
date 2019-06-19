package com.zzw.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zzw.pojo.CartItem;
/**
 * 购物车dao
 * @author amalien
 *
 */
public interface CartDao {
	//根据用户名查询购物车内容
	public List<CartItem> selectCartItemByUsername(String username);
	//查询物品是否已在购物车
	public String checkCartItem(@Param(value = "username") String username,@Param(value = "pid") Integer pid);
	//用户增加购物车已有商品数量
	public void addCartItemCount(@Param(value = "username") String username,@Param(value = "pid") Integer pid);
	//购物车增加新商品
	public void addCartItem(@Param(value = "username") String username,@Param(value = "pid") Integer pid);
	//删除商品
	public void deleteCartItem(@Param(value = "username") String username,@Param(value = "pid") Integer pid);
	//清空购物车
	public void clearCart(String username);
}
