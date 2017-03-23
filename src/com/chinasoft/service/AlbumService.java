package com.chinasoft.service;
import java.util.ArrayList;
import com.chinasoft.dao.daoImpl.AlbumDao;
import com.chinasoft.entity.Album;
import com.chinasoft.util.PageModel;


public class AlbumService {
				
	/**
	 * @param 	类型名称
	 * @return 插入结果：1：插入成功 2:类型已存在 0：插入失败
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
	/**
	 * 
	 * @param 专辑属性
	 * @return 新增结果：1:新增成功 0：新增失败
	 * decription :新增专辑
	 * 
	 */
	public int addAlbum(String name ,int language,String date,String company,int type) {
		// 先查询是否重名
		AlbumDao dao = new AlbumDao();												
		int res2 = dao.insertAlbum( name,language,date,company,type);
		return res2;					
	}
	/**
	 * 
	 * @param 专辑id
	 * @return 查询对象
	 * decription :根据id查询专辑对象
	 * 
	 */	
	public Album changeAlbum(String albumId){
		
		AlbumDao dao = new AlbumDao();
		return dao.selectAlbumById(albumId);
	}
	
	/**
	 * 
	 * @param pageNo：当前页码 pageSize：当前显示条数
	 * @return 显示模式对象
	 * decription :分页查询所有的专辑
	 * 
	 */		
	public PageModel getAlbumInfoFenye(int pageNo, int pageSize){
		AlbumDao dao = new AlbumDao();
		PageModel pm = dao.selectAlbumFenyeNew(pageNo, pageSize);		
		return pm;
	}
	
	/**
	 * 
	 * @param 专辑属性
	 * @return 更新结果：1 成功 2失败
	 * decription :更新专辑
	 * 
	 */	
	public int uppdateAlbum(int id, String name, int language, String date, String company, int type) {		
		AlbumDao dao = new AlbumDao();												
		int res2 = dao.updateAlbum(id, name,language,date,company,type);
		return res2;
	}
	
	/**
	 * 
	 * @param pageNo：当前页码 pageSize：当前显示条数
	 * @return 显示模式对象
	 * decription :分页查询所有的专辑类型
	 * 
	 */
	public PageModel getAlbumTypeInfoFenye(int pageNo, int pageSize) {
		
		AlbumDao dao = new AlbumDao();
		PageModel pm = dao.selectAlbumTypeFenyeNew(pageNo, pageSize);		
		return pm;
	}
		
	}
	

