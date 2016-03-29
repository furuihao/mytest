package com.hao.test.dao.impl;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.fqq.common.dto.SearchCriteria;
import com.hao.test.dao.ProductDao;
import com.hao.test.models.ProductInfo;
import com.hao.test.models.ProductSearchCriteria;

@Repository
public class ProductDaoImpl extends AbstractTesttDao<ProductInfo> implements
		ProductDao {

	@Override
	public DetachedCriteria CreateCriteria(SearchCriteria searchCriteria) {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(ProductInfo.class);

		if (null != searchCriteria) {
			ProductSearchCriteria sc = (ProductSearchCriteria) searchCriteria;
			if (sc.getId() != null) {
				criteria.add(Restrictions.eq("id", sc.getId()));
			}
		}
		return criteria;
	}

	@Override
	public List<ProductInfo> queryBySql() {
		String sql = "SELECT * FROM product";
		SQLQuery query = this.getSessionFactory().getCurrentSession()
				.createSQLQuery(sql);
		query.addEntity(ProductInfo.class);
		@SuppressWarnings("unchecked")
		List<ProductInfo> list = query.list();
		return list;
	}

}
