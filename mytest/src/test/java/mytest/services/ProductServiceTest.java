package mytest.services;

import java.util.List;

import javax.annotation.Resource;

import mytest.SpringTest;

import org.junit.Test;

import com.hao.test.models.ProductInfo;
import com.hao.test.models.ProductSearchCriteria;
import com.hao.test.services.ProductService;

public class ProductServiceTest extends SpringTest {
	@Resource
	private ProductService productService;

	// @Test
	public void save() {
		ProductInfo product = new ProductInfo();
		product.setCategoryId(1L);
		product.setName("北京-上海");
		product.setDescription("热门");
		productService.save(product);
	}

	//@Test
	public void search() {
		ProductSearchCriteria sc = new ProductSearchCriteria();
		List<ProductInfo> ps = productService.search(sc);
		System.out.println(ps.size());
	}

	@Test
	public void query() {
		List<ProductInfo> ps = productService.queryBySql();
		System.out.println(ps.size());
	}

	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
}
