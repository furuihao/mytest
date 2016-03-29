package com.hao.test.dao;

import java.util.List;

import com.fqq.common.dao.BaseDataAccessObject;
import com.hao.test.models.ProductInfo;

public interface ProductDao extends BaseDataAccessObject<ProductInfo> {

	List<ProductInfo> queryBySql();

}
