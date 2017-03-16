package com.chinasoft.dao.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.chinasoft.dao.Dao;
import com.chinasoft.entity.Album;


public class AlbumDao {
	public ArrayList<Album> selectAlbumAll() {
		Connection conn = Dao.Connection();
		String sql = "select * FROM album ";
				
				
		PreparedStatement pstmt = null;
		ResultSet res = null;
		ArrayList<Album> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql);
			res = pstmt.executeQuery();
			while (res.next()) {
				Album al = new Album();
				al.setLanguageId(res.getInt("languageId"));
				al.setTypeid(res.getInt("typeid"));
				al.setAlbumName(res.getString("albumname"));		
				al.setReleaseTime(res.getDate("releasetime"));		
				al.setReleaseCompany(res.getString("releasecompany"));		
				
				list.add(al);				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dao.closeConn(res, null, pstmt, conn);
		}
		return list;
	}

	
	public ArrayList<String> selectAlbumType() {
		Connection conn = Dao.Connection();
		String sql = "select typename FROM albumtype ";								
		PreparedStatement pstmt = null;
		ResultSet res = null;
		ArrayList<String> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql);
			res = pstmt.executeQuery();
			while (res.next()) {				
				list.add(res.getString("typename"));				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dao.closeConn(res, null, pstmt, conn);
		}
		return list;
					
	}
	public int insertAlbum(String name ){
		Connection conn = Dao.Connection();
		String sql = "insert into  values (null,?,?,?,?,?)";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,name);												
			pstmt.setString(2,language);												
			pstmt.setString(3,date);												
			pstmt.setString(4,compapny);												
			pstmt.setString(5,type);												
			int result = pstmt.executeUpdate();				
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	public int selectAlbumByName(String name){
		Connection conn = Dao.Connection();
		String sql = "select * FROM album WHERE albumname = ?";
		PreparedStatement pstmt = null;
		ResultSet res = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			res = pstmt.executeQuery();
			while (res.next()) {
				return 1;
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dao.closeConn(res, null, pstmt, conn);
		}
		return 0;
	}

	/**
	 * 
	 * @param cusId
	 * @return
	 * decription :
	 * author : zhangsan
	 */
	public int insertAlbumType(String type){
		Connection conn = Dao.Connection();
		String sql = "insert into  values (null,?)";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,type);												
			int result = pstmt.executeUpdate();				
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int selectAlbumTypeByType(String type){
		Connection conn = Dao.Connection();
		String sql = "select * FROM albumtype WHERE typename = ?";
		PreparedStatement pstmt = null;
		ResultSet res = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, type);
			res = pstmt.executeQuery();
			while (res.next()) {
				return 1;
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dao.closeConn(res, null, pstmt, conn);
		}
		return 0;
	}


}
