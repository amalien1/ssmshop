package com.zzw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzw.dao.ProductDao;
import com.zzw.pojo.Product;
import com.zzw.pojo.QueryVo;
import com.zzw.service.ProductService;
@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDao productDao;
	@Override
	public List<Product> selectProductByQueryVo(QueryVo vo) {
		String price=vo.getProductPrice();
		if("".equals(vo.getProductName())){
			vo.setProductName(null);
		}
		if("".equals(vo.getProductType())){
			vo.setProductType(null);
		}
		if("".equals(vo.getProductPrice())){
			vo.setProductPrice(null);
		}
		if("0-500".equals(price)){
			vo.setProductPrice("<500");
		}else if("500-1000".equals(price)){
			vo.setProductPrice("between 500 and 1000");
		}else if("1000-2000".equals(price)){
			vo.setProductPrice("between 1000 and 2000");
		}else if("2000以上".equals(price)){
			vo.setProductPrice(">2000");
		}
		System.out.println(vo);
		return productDao.selectProductByQueryVo(vo);
	}
	@Override
	public Integer count(QueryVo vo) {
		String price=vo.getProductPrice();
		if("".equals(vo.getProductName())){
			vo.setProductName(null);
		}
		if("".equals(vo.getProductType())){
			vo.setProductType(null);
		}
		if("".equals(vo.getProductPrice())){
			vo.setProductPrice(null);
		}
		if("0-500".equals(price)){
			vo.setProductPrice("<500");
		}else if("500-1000".equals(price)){
			vo.setProductPrice("between 500 and 1000");
		}else if("1000-2000".equals(price)){
			vo.setProductPrice("between 1000 and 2000");
		}else if("2000以上".equals(price)){
			vo.setProductPrice(">2000");
		}
		return productDao.count(vo);
	}
	@Override
	public void insertProduct(Product product) {
		productDao.insertProduct(product);
	}
	@Override
	public void deleteProductById(Integer id) {
		productDao.deleteProductById(id);
	}
	@Override
	public Product selectProductById(Integer id) {
		return productDao.selectProductById(id);
	}
	@Override
	public void updateProduct(Product product) {
		productDao.updateProduct(product);
	}

}
