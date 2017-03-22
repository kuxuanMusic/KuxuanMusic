package com.chinasoft.entity;

public class MVMusicAndSinger {
	/**
	 * MV 编号
	 */
	private int mvId;
	/**
	 * 歌曲名
	 */
	private String musicName;
	/**
	 * 歌手名
	 */
	private String singerName;
	/**
	 * MV存放的地址
	 */
	private String address;

	public MVMusicAndSinger() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MVMusicAndSinger(int mvId, String musicName, String singerName, String address) {
		super();
		this.mvId = mvId;
		this.musicName = musicName;
		this.singerName = singerName;
		this.address = address;
	}

	public int getMvId() {
		return mvId;
	}

	public void setMvId(int mvId) {
		this.mvId = mvId;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "MVMusicAndSinger [mvId=" + mvId + ", musicName=" + musicName + ", singerName=" + singerName
				+ ", address=" + address + "]";
	}
}
