package com.chinasoft.entity;

/**
 * MV类
 * 
 * @author Administrarors
 *
 */
public class MV {
	/**
	 * MV 编号
	 */
	private int mvId;
	/**
	 * MV对应歌曲的编号
	 */
	private int musicId;
	/**
	 * MV存放的地址
	 */
	private String address;

	public MV() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MV(int musicId, String address) {
		super();
		this.musicId = musicId;
		this.address = address;
	}

	public int getMusicId() {
		return musicId;
	}

	public void setMusicId(int musicId) {
		this.musicId = musicId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getMvId() {
		return mvId;
	}

	@Override
	public String toString() {
		return "MV [mvId=" + mvId + ", musicId=" + musicId + ", address=" + address + "]";
	}

}
