package com.hao.test.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import com.fqq.common.dto.DataTransferObject;

@Entity
@Table(name = "category", catalog = "test")
@DynamicUpdate(value=false)
public class CategoryInfo implements DataTransferObject {

	private static final long serialVersionUID = 3240281547213597385L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	@OneToMany(mappedBy="category",cascade=CascadeType.ALL)
//	@JoinColumn(name = "category_id")
	private List<ProductInfo> products ;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<ProductInfo> getProducts() {
		return products;
	}

	public void setProducts(List<ProductInfo> products) {
		this.products = products;
	}


}
