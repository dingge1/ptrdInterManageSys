package com.huihuan.gmp.entity;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private Integer uid;
	private String username;
	private Short groupid;
	private String name;
	private String avatar;
	private String avatarSmall;
	private String email;
	private String password;
	private String cookieToken;
	private Integer cookieTokenExpire;
	private Integer regTime;
	private Integer lastLoginTime;

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String username, Short groupid, String password,
			String cookieToken, Integer cookieTokenExpire, Integer regTime,
			Integer lastLoginTime) {
		this.username = username;
		this.groupid = groupid;
		this.password = password;
		this.cookieToken = cookieToken;
		this.cookieTokenExpire = cookieTokenExpire;
		this.regTime = regTime;
		this.lastLoginTime = lastLoginTime;
	}

	/** full constructor */
	public User(String username, Short groupid, String name, String avatar,
			String avatarSmall, String email, String password,
			String cookieToken, Integer cookieTokenExpire, Integer regTime,
			Integer lastLoginTime) {
		this.username = username;
		this.groupid = groupid;
		this.name = name;
		this.avatar = avatar;
		this.avatarSmall = avatarSmall;
		this.email = email;
		this.password = password;
		this.cookieToken = cookieToken;
		this.cookieTokenExpire = cookieTokenExpire;
		this.regTime = regTime;
		this.lastLoginTime = lastLoginTime;
	}

	// Property accessors

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

	public Short getGroupid() {
		return this.groupid;
	}

	public void setGroupid(Short groupid) {
		this.groupid = groupid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAvatar() {
		return this.avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getAvatarSmall() {
		return this.avatarSmall;
	}

	public void setAvatarSmall(String avatarSmall) {
		this.avatarSmall = avatarSmall;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCookieToken() {
		return this.cookieToken;
	}

	public void setCookieToken(String cookieToken) {
		this.cookieToken = cookieToken;
	}

	public Integer getCookieTokenExpire() {
		return this.cookieTokenExpire;
	}

	public void setCookieTokenExpire(Integer cookieTokenExpire) {
		this.cookieTokenExpire = cookieTokenExpire;
	}

	public Integer getRegTime() {
		return this.regTime;
	}

	public void setRegTime(Integer regTime) {
		this.regTime = regTime;
	}

	public Integer getLastLoginTime() {
		return this.lastLoginTime;
	}

	public void setLastLoginTime(Integer lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

}