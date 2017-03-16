package com.chinasoft.service;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import com.chinasoft.dao.daoImpl.AlbumDao;
import com.chinasoft.entity.Album;
import com.css.dao.AdminDao;
import com.css.exception.EncryptException;
import com.css.util.Encrypt;



public class AlbumService {
	public ArrayList<Album> getAlbuminfo(){
		AlbumDao dao = new AlbumDao();
		ArrayList<Album> list = dao.selectAlbumAll();	
		return list;
	}
	public ArrayList<String> getAlbumTypeinfo(){
		AlbumDao dao = new AlbumDao();
		ArrayList<String> list = dao.selectAlbumType();	
		return list;
	}
	public int addAlbumType(String type) {
		// 先查询是否重名
		AlbumDao dao = new AlbumDao();
		int res1 = dao.selectAlbumTypeByType(type);
		
		if(res1 == 1){
			// 已存在
			return 2;
		} else{
			// 未重名可插入						
			int res2 = dao.insertAlbumType(type);
			return res2;
		}	
		
	}
	public int addAlbum(String name) {
		// 先查询是否重名
		AlbumDao dao = new AlbumDao();
		int res1 = dao.selectAlbumByName(name);
		
		if(res1 == 1){
			// 已存在
			return 2;
		} else{
			// 未重名可插入						
			int res2 = dao.insertAlbum(type);
			return res2;
		}	
		
	}
	

}
