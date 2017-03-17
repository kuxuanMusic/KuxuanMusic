package com.chinasoft.service;

import java.util.ArrayList;

import com.chinasoft.dao.daoImpl.SingerDao;
import com.chinasoft.entity.Singer;

public class SingerService {
	/**
	 * 查询所有歌手
	 * 
	 * @return list
	 */
	public ArrayList<Singer> selectAllSinger() {
		SingerDao dao = new SingerDao();
		ArrayList<Singer> list = dao.SelectAllSinger();
		return list;
	}

	/**
	 * 根据id删除用户 count为大于1表示删除成功，等于0表示删除失败
	 * 
	 * @param singerId
	 * @return count
	 */
	public int deleteSingerById(String singerId) {
		SingerDao dao = new SingerDao();
		int count = dao.deleteSinger(singerId);
		return count;
	}

	/**
	 * 插入歌手
	 * @param singer
	 */
	public void insertSinger(Singer singer) {
		SingerDao dao = new SingerDao();
		dao.addSinger(singer);
	}
}
