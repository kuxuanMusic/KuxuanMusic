package com.chinasoft.entity;

import java.util.Date;

/**
 * 歌曲类
 * 
 * @author Administrarors
 *
 */
public class Music {
	/**
	 * 歌曲ID
	 */
	private int musicId;
	/**
	 * 歌曲名
	 */
	private String musicName;
	/**
	 * 歌手ID
	 */
	private int singerId;
	/**
	 * 专辑ID
	 */
	private int albumId;
	private Date releaseTime;
	private int languageId;
	private int typeId;
	private String address;

	public Music() {
		super();
	}

	public Music(String musicName, int singerId, int albumId, Date releaseTime, int languageId, int typeId,
			String address) {
		super();
		this.musicName = musicName;
		this.singerId = singerId;
		this.albumId = albumId;
		this.releaseTime = releaseTime;
		this.languageId = languageId;
		this.typeId = typeId;
		this.address = address;
	}

	public String getMusicName() {
		return musicName;
	}

	public void setMusicName(String musicName) {
		this.musicName = musicName;
	}

	public int getSingerId() {
		return singerId;
	}

	public void setSingerId(int singerId) {
		this.singerId = singerId;
	}

	public int getAlbumId() {
		return albumId;
	}

	public void setAlbumId(int albumId) {
		this.albumId = albumId;
	}

	public Date getReleaseTime() {
		return releaseTime;
	}

	public void setReleaseTime(Date releaseTime) {
		this.releaseTime = releaseTime;
	}

	public int getLanguageId() {
		return languageId;
	}

	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getMusicId() {
		return musicId;
	}

	@Override
	public String toString() {
		return "Music [musicId=" + musicId + ", musicName=" + musicName + ", singerId=" + singerId + ", albumId="
				+ albumId + ", releaseTime=" + releaseTime + ", languageId=" + languageId + ", typeId=" + typeId
				+ ", address=" + address + "]";
	}
}
