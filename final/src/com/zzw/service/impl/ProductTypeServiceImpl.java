package com.zzw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzw.dao.ProductTypeDao;
import com.zzw.pojo.ProductType;
import com.zzw.service.ProductTypeService;
@Service
public class ProductTypeServiceImpl implements ProductTypeService {
	@Autowired
	private ProductTypeDao productTypeDao;
	@Override
	public List<ProductType> selectAll() {
		
		return productTypeDao.selectAll();
	}
	@Override
	public ProductType selectProductTypeById(Integer id) {
		return productTypeDao.selectProductTypeById(id);
	}
	@Override
	public boolean updateProductType(ProductType productType) {
		if(null!=productTypeDao.selectProductTypeByName(productType.getTypename())){
			return false;
		}
		productTypeDao.updateProductType(productType);
		return true;
	}
	@Override
	public void deleteProductTypeById(Integer id) {
		productTypeDao.deleteProductTypeById(id);
	}
	@Override
	public boolean addProductType(ProductType productType) {
		if(null!=productTypeDao.selectProductTypeByName(productType.getTypename())){
			return false;
		}
		productTypeDao.addProductType(productType);
		return true;
	}

}
