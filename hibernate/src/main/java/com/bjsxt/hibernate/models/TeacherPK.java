package com.bjsxt.hibernate.models;

//@Embeddable
public class TeacherPK implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2946684161551601618L;
	private int id;
	private String name;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof TeacherPK) {
			TeacherPK pk = (TeacherPK) obj;
			if (this.id == pk.getId() && this.name.equals(pk.getName()))
				return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return this.name.hashCode();
	}

}
