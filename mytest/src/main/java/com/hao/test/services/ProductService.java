package com.hao.test.services;

import java.util.List;

import com.hao.test.models.ProductInfo;
import com.hao.test.models.ProductSearchCriteria;

public interface ProductService {
	void save(ProductInfo product);

	List<ProductInfo> search(ProductSearchCriteria sc);

	List<ProductInfo> queryBySql();
}
