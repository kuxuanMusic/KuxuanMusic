package com.chinasoft.dao.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.chinasoft.dao.Dao;
import com.chinasoft.entity.Singer;

public class SingerDao {
	/**
	 * 查询所用的歌手
	 * 
	 * @return list
	 */
	public ArrayList<Singer> SelectAllSinger() {
		PreparedStatement statement = null;
		ResultSet res = null;
		Connection con = Dao.Connection();
		String sql = "SELECT * FROM singer";
		ArrayList<Singer> list = new ArrayList<Singer>();
		try {
			statement = con.prepareStatement(sql);
			res = statement.executeQuery();
			while (res.next()) {
				Singer singer = new Singer();
				singer.setSingerId(res.getInt("singerid"));
				singer.setSingerName(res.getString("singername"));
				singer.setProfile(res.getString("profile"));
				list.add(singer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dao.closeConn(res, null, statement, con);
		}
		return list;
	}

	/**
	 * 根据歌手id删除歌手
	 * 
	 * @param SingerId
	 * @return count
	 */
	public int deleteSinger(String SingerId) {
		Connection con = Dao.Connection();
		String sql = "DELETE FROM singer WHERE singerid = ?";
		PreparedStatement statement = null;
		int count = 0;
		try {
			statement = con.prepareStatement(sql);
			statement.setString(1, SingerId);
			count = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dao.closeConn(null, null, statement, con);
		}
		return count;
	}

	/**
	 * 向数据库插入歌手
	 * 
	 * @param singer
	 * @return count
	 */
	public int addSinger(Singer singer) {
		Connection con = Dao.Connection();
		String sql = "INSERT INTO singer VALUES(null,?,?)";
		PreparedStatement statement = null;
		int count = 0;
		try {
			statement = con.prepareStatement(sql);
			statement.setString(1, singer.getSingerName());
			statement.setString(2, singer.getProfile());
			count = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dao.closeConn(null, null, statement, con);
		}
		return count;
	}
	
	/**
	 * 查询歌手是否存在/可用于按名字查询歌手
	 * @param name
	 * @return boolean
	 */
	public boolean selectSingerByName(String name) {
		Connection con = Dao.Connection();
		String sql = "SELECT * FROM singer s WHERE s.singername = ?";
		PreparedStatement prs = null;
		ResultSet rs = null;
		try {
			prs = con.prepareStatement(sql);
			prs.setString(1, name);
			rs = prs.executeQuery();
			while (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dao.closeConn(rs, null, prs, con);
		}
		return false;
	}
}
