package com.zzw.dao;

import java.util.List;

import com.zzw.pojo.ProductType;
/**
 * 商品类型dao
 * @author amalien
 *
 */
public interface ProductTypeDao {
	//查询所有
	public List<ProductType> selectAll();
	//根据id查询类别
	public ProductType selectProductTypeById(Integer id);
	//修改商品类别
	public void updateProductType(ProductType productType);
	//删除商品类别
	public void deleteProductTypeById(Integer id);
	//添加商品类别
	public void addProductType(ProductType productType);
	//根据商品类别名称查询
	public ProductType selectProductTypeByName(String typename);
}	
