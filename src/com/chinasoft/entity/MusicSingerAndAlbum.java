package com.chinasoft.entity;

import java.util.Date;

public class MusicSingerAndAlbum {
	/**
	 * 歌曲ID
	 */
	private int musicId;
	/**
	 * 歌曲名
	 */
	private String musicName;
	/**
	 * 歌手名
	 */
	private String singerName;
	/**
	 * 专辑名
	 */
	private String albumName;
	/**
	 * 歌曲发布时间
	 */
	private Date releaseTime;
	/**
	 * 语种
	 */
	private String languageName;
	/**
	 * 类型
	 */
	private String typeName;
	/**
	 * 歌曲存放地址
	 */
	private String address;

	public MusicSingerAndAlbum() {
		super();
	}

	public MusicSingerAndAlbum(int musicId, String musicName, String singerName, String albumName, Date releaseTime,
			String languageName, String typeName, String address) {
		super();
		this.musicId = musicId;
		this.musicName = musicName;
		this.singerName = singerName;
		this.albumName = albumName;
		this.releaseTime = releaseTime;
		this.languageName = languageName;
		this.typeName = typeName;
		this.address = address;
	}

	public int getMusicId() {
		return musicId;
	}

	public void setMusicId(int musicId) {
		this.musicId = musicId;
	}

	public String getMusicName() {
		return musicName;
	}

	public void setMusicName(String musicName) {
		this.musicName = musicName;
	}

	public String getSingerName() {
		return singerName;
	}

	public void setSingerName(String singerName) {
		this.singerName = singerName;
	}

	public String getAlbumName() {
		return albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	public Date getReleaseTime() {
		return releaseTime;
	}

	public void setReleaseTime(Date releaseTime) {
		this.releaseTime = releaseTime;
	}

	public String getLanguageName() {
		return languageName;
	}

	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "MusicSingerAndAlbum [musicId=" + musicId + ", musicName=" + musicName + ", singerName=" + singerName
				+ ", albumName=" + albumName + ", releaseTime=" + releaseTime + ", languageName=" + languageName
				+ ", typeName=" + typeName + ", address=" + address + "]";
	}

}
