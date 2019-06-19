package com.zzw.dao;

import java.util.List;

import com.zzw.pojo.Product;
import com.zzw.pojo.QueryVo;
/**
 * 商品dao
 * @author amalien
 *
 */
public interface ProductDao {
	//根据包装类分页查询产品
	public List<Product> selectProductByQueryVo(QueryVo vo);
	//根据包装类查询商品总数
	public Integer count(QueryVo vo);
	//添加商品
	public void insertProduct(Product product);
	//根据id删除商品
	public void deleteProductById(Integer id);
	//根据id查询商品信息
	public Product selectProductById(Integer id);
	//更新商品
	public void updateProduct(Product product);
}
