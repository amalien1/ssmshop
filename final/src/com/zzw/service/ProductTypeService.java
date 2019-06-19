package com.zzw.service;

import java.util.List;

import com.zzw.pojo.ProductType;
/**
 * 商品类别service
 * @author amalien
 *
 */
public interface ProductTypeService {
	//选择所有类别
	public List<ProductType> selectAll();
	//根据id查询类别
	public ProductType selectProductTypeById(Integer id);
	//修改商品类别
	public boolean updateProductType(ProductType productType);
	//删除商品类别
	public void deleteProductTypeById(Integer id);
	//添加商品类别
	public boolean addProductType(ProductType productType);
}	
