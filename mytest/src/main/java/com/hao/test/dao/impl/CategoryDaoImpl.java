package com.hao.test.dao.impl;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.fqq.common.dto.SearchCriteria;
import com.hao.test.dao.CategoryDao;
import com.hao.test.models.CategoryInfo;
import com.hao.test.models.CategorySearchCriteria;

@Repository
public class CategoryDaoImpl extends AbstractTesttDao<CategoryInfo> implements
		CategoryDao {

	@Override
	public DetachedCriteria CreateCriteria(SearchCriteria searchCriteria) {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(CategoryInfo.class);

		if (null != searchCriteria) {
			CategorySearchCriteria sc = (CategorySearchCriteria) searchCriteria;
			if (sc.getId() != null) {
				criteria.add(Restrictions.eq("id", sc.getId()));
			}
		}
		return criteria;
	}

}
