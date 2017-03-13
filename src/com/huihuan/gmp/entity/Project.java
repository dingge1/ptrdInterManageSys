package com.huihuan.gmp.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Project entity. @author MyEclipse Persistence Tools
 */

public class Project implements java.io.Serializable {

	// Fields

	private Long id;
	private String name;
	private String url;
	private Integer status;
	private Timestamp startTime;
	private Set modules = new HashSet(0);
	private Set versionses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Project() {
	}

	/** minimal constructor */
	public Project(Timestamp startTime) {
		this.startTime = startTime;
	}

	/** full constructor */
	public Project(String name, String url, Integer status,
			Timestamp startTime, Set modules, Set versionses) {
		this.name = name;
		this.url = url;
		this.status = status;
		this.startTime = startTime;
		this.modules = modules;
		this.versionses = versionses;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Timestamp getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Set getModules() {
		return this.modules;
	}

	public void setModules(Set modules) {
		this.modules = modules;
	}

	public Set getVersionses() {
		return this.versionses;
	}

	public void setVersionses(Set versionses) {
		this.versionses = versionses;
	}

}