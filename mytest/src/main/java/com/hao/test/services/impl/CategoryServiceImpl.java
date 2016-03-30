package com.hao.test.services.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fqq.common.service.ServiceException;
import com.hao.test.dao.CategoryDao;
import com.hao.test.models.CategoryInfo;
import com.hao.test.models.CategorySearchCriteria;
import com.hao.test.models.ProductInfo;
import com.hao.test.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Resource
	private CategoryDao categoryDao;

	public CategoryDao getCategoryDao() {
		return categoryDao;
	}

	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	@Override
	public void save(CategoryInfo category) {
		categoryDao.save(category);
	}

	@Override
	public CategoryInfo getById(Long id) throws ServiceException {
		CategoryInfo info = categoryDao.getById(id, CategoryInfo.class);
		if (info == null)
<<<<<<< HEAD
<<<<<<< HEAD
			throw new ServiceException("404", "没有找到对应记录123456");
=======
			throw new ServiceException("404", "没有找到对应记录");
>>>>>>> parent of d956a43... test
=======
			throw new ServiceException("404", "没有找到对应记录");
>>>>>>> parent of d956a43... test
		return info;
	}

	@Override
	public List<CategoryInfo> search(CategorySearchCriteria sc) {
		return categoryDao.search(sc);
	}

	@Override
	public void addProductById(Long id, ProductInfo product)
			throws ServiceException {
		CategoryInfo info = this.getById(id);
		info.getProducts().add(product);
		categoryDao.update(info);
	}

	@Override
	public void update(CategoryInfo category) {
		categoryDao.update(category);
	}

}
