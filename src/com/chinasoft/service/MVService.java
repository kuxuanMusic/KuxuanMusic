package com.chinasoft.service;

import com.chinasoft.dao.daoImpl.MVDao;

public class MVService {
	
	/**
	 * 
	 * @param musicName 歌曲名
	 * @param mvAddress  mv存放地址
	 * @Return:  1插入mv成功 0失败
	 * @Description: 查看mv是否插入成功
	 * author:
	 */
	public int addMV(String musicName, String mvAddress){
		MVDao md = new MVDao();
		int musicId = md.selectMusicId(musicName);
		return md.insertMV(musicId, mvAddress);
	}
}
