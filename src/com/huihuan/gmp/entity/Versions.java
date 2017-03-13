package com.huihuan.gmp.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Versions entity. @author MyEclipse Persistence Tools
 */

public class Versions implements java.io.Serializable {

	// Fields

	private Long id;
	private Project project;
	private String name;
	private String code;
	private Integer status;
	private Set interfaceses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Versions() {
	}

	/** full constructor */
	public Versions(Project project, String name, String code, Integer status,
			Set interfaceses) {
		this.project = project;
		this.name = name;
		this.code = code;
		this.status = status;
		this.interfaceses = interfaceses;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Set getInterfaceses() {
		return this.interfaceses;
	}

	public void setInterfaceses(Set interfaceses) {
		this.interfaceses = interfaceses;
	}

}