package com.chinasoft.service;

import com.chinasoft.dao.daoImpl.MusicDao;
import com.chinasoft.entity.Music;

/**
 * 歌曲服务类
 * 
 * @author Administrarors
 *
 */
public class MusicService {
	/**
	 * 添加歌曲
	 * 
	 * @param music
	 * @return
	 */
	public int addMusic(Music music) {
		MusicDao musicDao = new MusicDao();
		//判断歌曲是否存在（同一歌手不存在相同名字的歌）
		
		
		musicDao.insertMusic(music);
		return (Integer) null;
	}
}
