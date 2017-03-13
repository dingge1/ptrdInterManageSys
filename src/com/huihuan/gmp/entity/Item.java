package com.huihuan.gmp.entity;

/**
 * Item entity. @author MyEclipse Persistence Tools
 */

public class Item implements java.io.Serializable {

	// Fields

	private Integer itemId;
	private String itemName;
	private String itemDescription;
	private Integer uid;
	private String username;
	private String password;
	private String itemDomain;
	private Integer addtime;
	private Integer lastUpdateTime;

	// Constructors

	/** default constructor */
	public Item() {
	}

	/** full constructor */
	public Item(String itemName, String itemDescription, Integer uid,
			String username, String password, String itemDomain,
			Integer addtime, Integer lastUpdateTime) {
		this.itemName = itemName;
		this.itemDescription = itemDescription;
		this.uid = uid;
		this.username = username;
		this.password = password;
		this.itemDomain = itemDomain;
		this.addtime = addtime;
		this.lastUpdateTime = lastUpdateTime;
	}

	// Property accessors

	public Integer getItemId() {
		return this.itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return this.itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemDescription() {
		return this.itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
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

	public String getItemDomain() {
		return this.itemDomain;
	}

	public void setItemDomain(String itemDomain) {
		this.itemDomain = itemDomain;
	}

	public Integer getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Integer addtime) {
		this.addtime = addtime;
	}

	public Integer getLastUpdateTime() {
		return this.lastUpdateTime;
	}

	public void setLastUpdateTime(Integer lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

}