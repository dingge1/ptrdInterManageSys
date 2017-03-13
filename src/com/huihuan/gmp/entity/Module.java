package com.huihuan.gmp.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Module entity. @author MyEclipse Persistence Tools
 */

public class Module implements java.io.Serializable {

	// Fields

	private Long id;
	private Project project;
	private Module module;
	private String name;
	private Set interfaceModuleses = new HashSet(0);
	private Set modules = new HashSet(0);

	// Constructors

	/** default constructor */
	public Module() {
	}

	/** full constructor */
	public Module(Project project, Module module, String name,
			Set interfaceModuleses, Set modules) {
		this.project = project;
		this.module = module;
		this.name = name;
		this.interfaceModuleses = interfaceModuleses;
		this.modules = modules;
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

	public Module getModule() {
		return this.module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set getInterfaceModuleses() {
		return this.interfaceModuleses;
	}

	public void setInterfaceModuleses(Set interfaceModuleses) {
		this.interfaceModuleses = interfaceModuleses;
	}

	public Set getModules() {
		return this.modules;
	}

	public void setModules(Set modules) {
		this.modules = modules;
	}

}