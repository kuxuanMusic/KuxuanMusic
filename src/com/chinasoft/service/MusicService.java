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
	 * @return 0、添加失败；1、添加成功；2、歌曲已存在
	 */
	public int addMusic(Music music, String singerName) {
		MusicDao musicDao = new MusicDao();
		// 判断歌曲是否存在（同一歌手不存在相同名字的歌）
		int result = musicDao.selectMusicByMusicNameAndSingerName(music.getMusicName(), singerName);
		System.out.println(result);
		if (result == 0) {
			if (musicDao.insertMusic(music) == 1) {
				return 1;
			} else {
				return 0;
			}
		} else {
			return 2;
		}
	}

	/**
	 * 根据歌手名查询歌手
	 * 
	 * @param singerName
	 * @return
	 */
	public int selectSingerBySingerName(String singerName) {
		MusicDao musicDao = new MusicDao();
		return musicDao.selectSingerBySingerName(singerName);
	}

	/**
	 * 根据专辑名查询专辑ID
	 * 
	 * @param albumName
	 * @return
	 */
	public int selectAlbumIdByAlbumName(String albumName) {
		MusicDao musicDao = new MusicDao();
		return musicDao.selectAlbumByAlbumName(albumName);
	}
}
