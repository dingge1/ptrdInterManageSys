package com.huihuan.gmp.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Users entity. @author MyEclipse Persistence Tools
 */

public class Users implements java.io.Serializable {

	// Fields

	private Long id;
	private Role role;
	private String username;
	private String password;
	private String name;
	private Set interfaceses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Users() {
	}

	/** full constructor */
	public Users(Role role, String username, String password, String name,
			Set interfaceses) {
		this.role = role;
		this.username = username;
		this.password = password;
		this.name = name;
		this.interfaceses = interfaceses;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set getInterfaceses() {
		return this.interfaceses;
	}

	public void setInterfaceses(Set interfaceses) {
		this.interfaceses = interfaceses;
	}

}