package com.hao.test.services;

import java.util.List;

import com.fqq.common.service.ServiceException;
import com.hao.test.models.CategoryInfo;
import com.hao.test.models.CategorySearchCriteria;
import com.hao.test.models.ProductInfo;

public interface CategoryService {
	void save(CategoryInfo category);

	CategoryInfo getById(Long id) throws ServiceException;

	List<CategoryInfo> search(CategorySearchCriteria sc);

	void update(CategoryInfo category);

	void addProductById(Long id, ProductInfo product) throws ServiceException;
	
}
