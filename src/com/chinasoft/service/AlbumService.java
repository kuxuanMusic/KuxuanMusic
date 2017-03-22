package com.chinasoft.service;
import java.util.ArrayList;
import com.chinasoft.dao.daoImpl.AlbumDao;
import com.chinasoft.entity.Album;
import com.chinasoft.util.PageModel;


public class AlbumService {
	
	public ArrayList<Album> getAlbuminfo(){
		AlbumDao dao = new AlbumDao();
		ArrayList<Album> list = dao.selectAlbumAll();	
		return list;
	}
	
	/**
	 * 
	 * @param 
	 * @return 专辑类型集合
	 * decription :查询所有的专辑类型
	 * 
	 */
	public ArrayList<String> getAlbumTypeinfo(){
		AlbumDao dao = new AlbumDao();
		ArrayList<String> list = dao.selectAlbumType();
		
		return list;
	}
	/**
	 * 
	 * @param 
	 * @return 专辑类型集合
	 * decription :增加专辑类型
	 * 
	 */
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
	public int addAlbum(String name ,int language,String date,String company,int type) {
		// 先查询是否重名
		AlbumDao dao = new AlbumDao();												
		int res2 = dao.insertAlbum( name,language,date,company,type);
		return res2;					
	}
	public int removeAlbum(String albumId){
		AlbumDao dao = new AlbumDao();
		return dao.deleteAlbum(albumId);
	}
	
	public Album changeAlbum(String albumId){
		
		AlbumDao dao = new AlbumDao();
		return dao.selectAlbumById(albumId);
	}
	
	public int getCount(){
		AlbumDao dao = new AlbumDao();
		return dao.selectAlbumCount();
	}
	
	public PageModel getAlbumInfoFenye(int pageNo, int pageSize){
		AlbumDao dao = new AlbumDao();
		PageModel pm = dao.selectAlbumFenyeNew(pageNo, pageSize);		
		return pm;
	}

	public int uppdateAlbum(int id, String name, int language, String date, String company, int type) {		
		AlbumDao dao = new AlbumDao();												
		int res2 = dao.updateAlbum(id, name,language,date,company,type);
		return res2;
	}

	public PageModel getAlbumTypeInfoFenye(int pageNo, int pageSize) {
		
		AlbumDao dao = new AlbumDao();
		PageModel pm = dao.selectAlbumTypeFenyeNew(pageNo, pageSize);		
		return pm;
	}
	
	
	}
	

