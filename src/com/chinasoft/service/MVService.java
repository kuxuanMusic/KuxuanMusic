package com.chinasoft.service;

import java.util.ArrayList;
import java.util.Map;

import com.chinasoft.dao.daoImpl.MVDao;
import com.chinasoft.entity.MV;

public class MVService {

	/**
	 * 
	 * @param musicName,歌曲名
	 * @param mvAddress,mv存放地址
	 * @Return: 1插入mv成功 0失败
	 * @Description: 查看mv是否插入成功 author:
	 */
	public int addMV(int musicId, String mvAddress) {
		MVDao md = new MVDao();
		return md.insertMV(musicId, mvAddress);
	}

	/**
	 * 
	 * @param singername,歌手名
	 * @Return 歌手id  
	 * @Description: 根据歌手名得歌手id 0:歌手不存在,1-正无穷歌手id
	 * author:
	 */
	public int selectSingerIdBySingerName(String singername) {
		MVDao md = new MVDao();
		return md.selectSingerIdBySingerName(singername);
	}

	/**
	 * 
	 * @param singerId,歌手id
	 * @param musicName,歌曲名
	 * @Return:  歌曲id
	 * @Description: 根据歌手id个和歌曲名得到歌曲id 0歌曲不存在,1-正无穷歌曲id
	 * author:
	 */
	public int selectMusicIdByMusicNameAndSingerId(int singerId, String musicName) {
		MVDao md = new MVDao();
		return md.selectMusicIdByMusicNameAndSingerId(singerId, musicName);
	}
	
	public ArrayList<MV> selectAllMV(){
		MVDao md = new MVDao();
		return md.selectAllMV();
	}
	
	public Map getMVBySingerId(int singerId) {
		MVDao md = new MVDao();
		return md.getMVBySingerId(singerId);
		 
	}
}
