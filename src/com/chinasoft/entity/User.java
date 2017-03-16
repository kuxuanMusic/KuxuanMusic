package com.chinasoft.entity;

/**
 * 用户类
 * 
 * @author Administrarors
 *
 */
public class User {
	/**
	 * 用户ID
	 */
	private int userId;
	/**
	 * 用户名
	 */
	private String username;
	/**
	 * 登录密码
	 */
	private String password;
	/**
	 * 用户类型：1、普通用户；2、管理员
	 * 
	 */
	private int userType;

	public User() {
		super();
	}

	public User(String username, String password, int userType) {
		this.username = username;
		this.password = password;
		this.userType = userType;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public String toString() {
		return "user [userId=" + userId + ", username=" + username + ", password=" + password + ", userType=" + userType
				+ "]";
	}
}
