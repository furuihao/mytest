package com.hao.test.dao.impl;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;

import com.fqq.common.dao.AbstractDataAccessObject;
import com.fqq.common.dto.DataTransferObject;

public abstract class AbstractTesttDao<T extends DataTransferObject> extends
		AbstractDataAccessObject<T> {
	@Resource(name = "testSessionFactory")
	public void setSuperSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
}
