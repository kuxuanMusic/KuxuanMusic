package com.chinasoft.dao.daoImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.chinasoft.dao.Dao;
import com.chinasoft.entity.Album;



public class AlbumDao {
	/**
	 * 
	 * @param 
	 * @return 专辑对象集合
	 * decription :查询所有的专辑信息
	 * 
	 */
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
				al.setAlbumId(res.getInt("albumid"));
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

	/**
	 * 
	 * @param 
	 * @return 专辑类型集合
	 * decription :查询所有的专辑类型
	 * 
	 */
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

	/**
	 * 
	 * @param 专辑的属性
	 * @return 插入结果：1为成功，0为失败
	 * decription :插入专辑
	 * 
	 */
	public int insertAlbum(String name, int language, String date, String company, int type) {
		Connection conn = Dao.Connection();
		String sql = "insert into  values (null,?,?,?,?,?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setInt(2, language);
			pstmt.setDate(3, Date.valueOf(date));
			pstmt.setString(4, company);
			pstmt.setInt(5, type);
			int result = pstmt.executeUpdate();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	/**
	 * 
	 * @param 专辑的名字
	 * @return 查询结果：1为存在，0为不存在
	 * decription :查询专辑是否存在
	 * 
	 */

	public int selectAlbumByName(String name) {
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
	 * @param 专辑的id
	 * @return 查询结果：专辑对象
	 * decription :根据专辑id查询专辑信息
	 * 
	 */
	public Album selectAlbumById(String albumid){
		Connection conn = Dao.Connection();
		String sql = "select * from album where albumid = ?";
		PreparedStatement pstmt = null;
		ResultSet res = null;
		Album al = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, albumid);
			res = pstmt.executeQuery();
			while (res.next()) {
				al.setAlbumId(res.getInt("albumid"));
				al.setLanguageId(res.getInt("languageId"));
				al.setTypeid(res.getInt("typeid"));
				al.setAlbumName(res.getString("albumname"));
				al.setReleaseTime(res.getDate("releasetime"));
				al.setReleaseCompany(res.getString("releasecompany"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dao.closeConn(res, null, pstmt, conn);
		}
		return al;
	}

	/**
	 * 
	 * @param 类型名称
	 * @return 插入结果：1为成功，0为失败
	 * decription :插入专辑类型
	 * 
	 */
	public int insertAlbumType(String type) {
		Connection conn = Dao.Connection();
		String sql = "insert into  values (null,?)";
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, type);
			int result = pstmt.executeUpdate();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * 
	 * @param 类型名称
	 * @return 插入结果：1为存在，0为不存在
	 * decription :根据类型名称查询类型是否存在
	 * 
	 */
	public int selectAlbumTypeByType(String type) {
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

	/**
	 * 
	 * @param 专辑id
	 * @return 删除结果：1为成功，0为失败
	 * decription :根据专辑id删除专辑
	 * 
	 */
	public int deleteAlbum(String albumId) {
		Connection conn = Dao.Connection();
		String sql = "delete from album where albumid = ?";
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, albumId);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Dao.closeConn(null, null, pstmt, conn);
		}
		return result;
	}
	
	/**
	 * 
	 * @param 
	 * @return 专辑数量
	 * decription :查询专辑的数量
	 * 
	 */

	public int selectAlbumCount() {
		Connection conn = Dao.Connection();
		Statement stmt = null;
		ResultSet rs = null;
		int count = 0;
		String sql = "select count(*) from album";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Dao.closeConn(rs, stmt, null, conn);
		}

		return count;
	}
	
	/**
	 * 
	 * @param 
	 * @return 
	 * decription :分页查询专辑
	 * 
	 */

	public ArrayList<Album> selectAlbumFenye(int pageNO, int pageSize){
		Connection conn = Dao.Connection();
		String sql = "select * from album limit ?, ?";
		PreparedStatement pstmt = null;
		ResultSet res = null;
		ArrayList<Album> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, (pageNO - 1)*pageSize );
			pstmt.setInt(2, pageSize);			
			res = pstmt.executeQuery();
			while (res.next()) {				
				Album al = new Album();
				al.setAlbumId(res.getInt("albumid"));
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
	

	

}
