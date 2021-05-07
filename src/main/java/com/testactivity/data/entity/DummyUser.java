package com.testactivity.data.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class DummyUser {

	@Id
	@GeneratedValue
	private int uId;
	private String name;
	private String role;

	public DummyUser() {
	}

	public DummyUser(int uId, String name, String email) {
		this.uId = uId;
		this.name = name;
		this.role = email;
	}

	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "DummyUser [uId=" + uId + ", name=" + name + ", role=" + role + "]";
	}

}
