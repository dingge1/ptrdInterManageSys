package com.huihuan.gmp.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Interfaces entity. @author MyEclipse Persistence Tools
 */

public class Interfaces implements java.io.Serializable {

	// Fields

	private Long id;
	private Versions versions;
	private Users users;
	private String name;
	private String params;
	private String result;
	private String url;
	private String rmk;
	private Integer status;
	private String rps;
	private String molurl;
	private Set interfaceModuleses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Interfaces() {
	}

	/** full constructor */
	public Interfaces(Versions versions, Users users, String name,
			String params, String result, String url, String rmk,
			Integer status, String rps, String molurl, Set interfaceModuleses) {
		this.versions = versions;
		this.users = users;
		this.name = name;
		this.params = params;
		this.result = result;
		this.url = url;
		this.rmk = rmk;
		this.status = status;
		this.rps = rps;
		this.molurl = molurl;
		this.interfaceModuleses = interfaceModuleses;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Versions getVersions() {
		return this.versions;
	}

	public void setVersions(Versions versions) {
		this.versions = versions;
	}

	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParams() {
		return this.params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	public String getResult() {
		return this.result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getRmk() {
		return this.rmk;
	}

	public void setRmk(String rmk) {
		this.rmk = rmk;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getRps() {
		return this.rps;
	}

	public void setRps(String rps) {
		this.rps = rps;
	}

	public String getMolurl() {
		return this.molurl;
	}

	public void setMolurl(String molurl) {
		this.molurl = molurl;
	}

	public Set getInterfaceModuleses() {
		return this.interfaceModuleses;
	}

	public void setInterfaceModuleses(Set interfaceModuleses) {
		this.interfaceModuleses = interfaceModuleses;
	}

}