package com.bjsxt.hibernate.models;

import javax.persistence.Entity;    
import javax.persistence.Id;

@Entity
public class Classes {   
	private int id;
	private String name;
	private String no;

	@Id
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

}
