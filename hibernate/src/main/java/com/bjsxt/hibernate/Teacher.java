package com.bjsxt.hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(TeacherPK.class)
public class Teacher {
	private int id;
	private String name;
	// private TeacherPK pk;
	private String title;

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Id
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	// @EmbeddedId
	// public TeacherPK getPk() {
	// return pk;
	// }
	//
	// public void setPk(TeacherPK pk) {
	// this.pk = pk;
	// }
}