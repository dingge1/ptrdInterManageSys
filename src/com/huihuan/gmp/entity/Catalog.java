package com.huihuan.gmp.entity;

/**
 * Catalog entity. @author MyEclipse Persistence Tools
 */

public class Catalog implements java.io.Serializable {

	// Fields

	private Integer catId;
	private String catName;
	private Integer itemId;
	private Integer SNumber;
	private Integer addtime;
	private Integer parentCatId;
	private Integer level;

	// Constructors

	/** default constructor */
	public Catalog() {
	}

	/** full constructor */
	public Catalog(String catName, Integer itemId, Integer SNumber,
			Integer addtime, Integer parentCatId, Integer level) {
		this.catName = catName;
		this.itemId = itemId;
		this.SNumber = SNumber;
		this.addtime = addtime;
		this.parentCatId = parentCatId;
		this.level = level;
	}

	// Property accessors

	public Integer getCatId() {
		return this.catId;
	}

	public void setCatId(Integer catId) {
		this.catId = catId;
	}

	public String getCatName() {
		return this.catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	public Integer getItemId() {
		return this.itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public Integer getSNumber() {
		return this.SNumber;
	}

	public void setSNumber(Integer SNumber) {
		this.SNumber = SNumber;
	}

	public Integer getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Integer addtime) {
		this.addtime = addtime;
	}

	public Integer getParentCatId() {
		return this.parentCatId;
	}

	public void setParentCatId(Integer parentCatId) {
		this.parentCatId = parentCatId;
	}

	public Integer getLevel() {
		return this.level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

}