package com.huihuan.gmp.entity;

/**
 * InterfaceModules entity. @author MyEclipse Persistence Tools
 */

public class InterfaceModules implements java.io.Serializable {

	// Fields

	private Long id;
	private Interfaces interfaces;
	private Module module;

	// Constructors

	/** default constructor */
	public InterfaceModules() {
	}

	/** full constructor */
	public InterfaceModules(Interfaces interfaces, Module module) {
		this.interfaces = interfaces;
		this.module = module;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Interfaces getInterfaces() {
		return this.interfaces;
	}

	public void setInterfaces(Interfaces interfaces) {
		this.interfaces = interfaces;
	}

	public Module getModule() {
		return this.module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

}