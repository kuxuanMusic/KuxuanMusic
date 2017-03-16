package com.chinasoft.entity;

/**
 * 歌手类
 * 
 * @author Administrarors
 *
 */
public class Singer {
	/**
	 * 歌手ID
	 */
	private int singerId;
	/**
	 * 歌手名
	 */
	private String singerName;
	/**
	 * 歌手简介
	 */
	private String profile;

	public Singer() {
		super();
	}

	public Singer(String singerName, String profile) {
		super();
		this.singerName = singerName;
		this.profile = profile;
	}

	public String getSingerName() {
		return singerName;
	}

	public void setSingerName(String singerName) {
		this.singerName = singerName;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public int getSingerId() {
		return singerId;
	}

	@Override
	public String toString() {
		return "Singer [singerId=" + singerId + ", singerName=" + singerName + ", profile=" + profile + "]";
	}
}
