package com.huihuan.gmp.entity;

/**
 * Page entity. @author MyEclipse Persistence Tools
 */

public class Page implements java.io.Serializable {

	// Fields

	private Integer pageId;
	private Integer authorUid;
	private String authorUsername;
	private Integer itemId;
	private Integer catId;
	private String pageTitle;
	private String pageContent;
	private Integer SNumber;
	private Integer addtime;

	// Constructors

	/** default constructor */
	public Page() {
	}

	/** full constructor */
	public Page(Integer authorUid, String authorUsername, Integer itemId,
			Integer catId, String pageTitle, String pageContent,
			Integer SNumber, Integer addtime) {
		this.authorUid = authorUid;
		this.authorUsername = authorUsername;
		this.itemId = itemId;
		this.catId = catId;
		this.pageTitle = pageTitle;
		this.pageContent = pageContent;
		this.SNumber = SNumber;
		this.addtime = addtime;
	}

	// Property accessors

	public Integer getPageId() {
		return this.pageId;
	}

	public void setPageId(Integer pageId) {
		this.pageId = pageId;
	}

	public Integer getAuthorUid() {
		return this.authorUid;
	}

	public void setAuthorUid(Integer authorUid) {
		this.authorUid = authorUid;
	}

	public String getAuthorUsername() {
		return this.authorUsername;
	}

	public void setAuthorUsername(String authorUsername) {
		this.authorUsername = authorUsername;
	}

	public Integer getItemId() {
		return this.itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public Integer getCatId() {
		return this.catId;
	}

	public void setCatId(Integer catId) {
		this.catId = catId;
	}

	public String getPageTitle() {
		return this.pageTitle;
	}

	public void setPageTitle(String pageTitle) {
		this.pageTitle = pageTitle;
	}

	public String getPageContent() {
		return this.pageContent;
	}

	public void setPageContent(String pageContent) {
		this.pageContent = pageContent;
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

}