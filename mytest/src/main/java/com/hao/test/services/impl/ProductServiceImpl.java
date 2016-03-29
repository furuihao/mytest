package com.hao.test.services.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hao.test.dao.ProductDao;
import com.hao.test.models.ProductInfo;
import com.hao.test.models.ProductSearchCriteria;
import com.hao.test.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	@Resource
	private ProductDao productDao;

	@Override
	public void save(ProductInfo product) {
		productDao.save(product);
	}

	@Override
	public List<ProductInfo> search(ProductSearchCriteria sc) {
		return productDao.search(sc);
	}

	@Override
	public List<ProductInfo> queryBySql() {
		List<ProductInfo> ps = productDao.queryBySql();
		for (ProductInfo productInfo : ps) {
			System.out.println(productInfo.getCategory().getName());
		}
		return ps;
	}

	public ProductDao getProductDao() {
		return productDao;
	}

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

}
