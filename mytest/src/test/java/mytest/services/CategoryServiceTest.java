package mytest.services;

import java.util.List;

import javax.annotation.Resource;

import mytest.SpringTest;

import org.junit.Test;

import com.alibaba.fastjson.JSONObject;
import com.fqq.common.service.ServiceException;
import com.hao.test.models.CategoryInfo;
import com.hao.test.models.CategorySearchCriteria;
import com.hao.test.models.ProductInfo;
import com.hao.test.services.CategoryService;
import com.hao.test.services.ProductService;

public class CategoryServiceTest extends SpringTest {

	@Resource
	private CategoryService categoryService;
	@Resource
	private ProductService productService;

	@Test
	public void save() throws ServiceException {
		// fail("Not yet implemented");

		CategoryInfo category = new CategoryInfo();
		category.setDescription("dddddddddd");
		category.setName("ddd");

		categoryService.save(category);
	}

	@Test
	public void addProduct() throws ServiceException {
//		CategoryInfo category = categoryService.getById(2L);
		// CategoryInfo category = new CategoryInfo();
		// category.setDescription("qqqqqqqq");
		// category.setName("qqqqqq");

		ProductInfo product = new ProductInfo();
//		product.setCategoryId(category.getId());
		product.setName("one-many8");
		product.setDescription("热门");
		// product.setCategory(category);
		// ProductInfo product2 = new ProductInfo();
		// product2.setCategoryId(1L);
		// product2.setCategory(category);
		// product2.setName("one-many4");
		// product2.setDescription("热门");
		// category.getProducts().add(product);
		// category.getProducts().add(product2);
//		productService.save(product);
//		 category.getProducts().add(product);
		 categoryService.addProductById(2L, product);
	}

	@Test
	public void search() {
		CategorySearchCriteria sc = new CategorySearchCriteria();
		List<CategoryInfo> list = categoryService.search(sc);
		for (CategoryInfo categoryInfo : list) {
			System.out.println(categoryInfo.getDescription()
					+ categoryInfo.getName() + categoryInfo.getId());
			System.out.println(JSONObject.toJSONString(categoryInfo
					.getProducts().size()));
		}

	}


	public CategoryService getCategoryService() {
		return categoryService;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

}
