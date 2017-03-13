package com.huihuan.gmp.entity;

/**
 * ItemMember entity. @author MyEclipse Persistence Tools
 */

public class ItemMember implements java.io.Serializable {

	// Fields

	private Integer itemMemberId;
	private Integer itemId;
	private Integer uid;
	private String username;
	private Integer addtime;

	// Constructors

	/** default constructor */
	public ItemMember() {
	}

	/** full constructor */
	public ItemMember(Integer itemId, Integer uid, String username,
			Integer addtime) {
		this.itemId = itemId;
		this.uid = uid;
		this.username = username;
		this.addtime = addtime;
	}

	// Property accessors

	public Integer getItemMemberId() {
		return this.itemMemberId;
	}

	public void setItemMemberId(Integer itemMemberId) {
		this.itemMemberId = itemMemberId;
	}

	public Integer getItemId() {
		return this.itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
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

	public Integer getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Integer addtime) {
		this.addtime = addtime;
	}

}