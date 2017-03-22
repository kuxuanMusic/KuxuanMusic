package com.chinasoft.dao.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.chinasoft.dao.Dao;
import com.chinasoft.entity.Singer;
import com.chinasoft.util.PageModel;

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
	 * 
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

	/**
	 * 查询歌手的数量
	 * 
	 * @return count
	 */
	public int getSingerCount() {
		Connection con = Dao.Connection();
		String sql = "SELECT COUNT(*) FROM singer";
		PreparedStatement prs = null;
		ResultSet res = null;
		int count = 0;
		try {
			prs = con.prepareStatement(sql);
			res = prs.executeQuery();

			while (res.next()) {
				count = res.getInt("COUNT(*)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			Dao.closeConn(res, null, prs, con);
		}
		return count;
	}

	/**
	 * 从指定位置查询指定条数数据，用于分页查询。
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @return PagModel
	 */
	public PageModel selectSingerPage(int pageNo, int pageSize) {
		Connection conn = Dao.Connection();
		String sql = "SELECT * FROM singer LIMIT ?,?";
		PreparedStatement pstmt = null;
		ResultSet res = null;
		ArrayList<Singer> list = new ArrayList<Singer>();
		PageModel pm = new PageModel();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, (pageNo - 1) * pageSize);
			pstmt.setInt(2, pageSize);
			res = pstmt.executeQuery();
			while (res.next()) {
				Singer singer = new Singer();
				singer.setSingerId(res.getInt(1));
				singer.setSingerName(res.getString(2));
				singer.setProfile(res.getString(3));
				list.add(singer);
			}

			pm.setList(list);
			pm.setCount(getSingerCount());
			pm.setPageNo(pageNo);
			pm.setPageSize(pageSize);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dao.closeConn(res, null, pstmt, conn);
		}
		return pm;
	}

	/**
	 * 根据id查询歌手数据
	 * 
	 * @param singerId
	 * @return list
	 */
	public ArrayList<Singer> selectSingerById(String singerId) {
		Connection con = Dao.Connection();
		String sql = "SELECT * FROM singer WHERE singerid = ?";
		PreparedStatement pre = null;
		ResultSet res = null;
		ArrayList<Singer> list = new ArrayList<Singer>();
		try {
			pre = con.prepareStatement(sql);
			pre.setString(1, singerId);
			res = pre.executeQuery();
			while (res.next()) {
				Singer singer = new Singer();
				singer.setSingerId(res.getInt(1));
				singer.setSingerName(res.getString(2));
				singer.setProfile(res.getString(3));
				list.add(singer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dao.closeConn(res, null, pre, con);
		}
		return list;
	}

	/**
	 * 根据用户id修改用户资料
	 * 
	 * @param singer
	 * @return count
	 */
	public int updateSinger(Singer singer) {
		Connection con = Dao.Connection();
		String sql = "UPDATE singer SET profile = ? WHERE singerid = ?";
		PreparedStatement pre = null;
		int count = 0;
		try {
			pre = con.prepareStatement(sql);
			pre.setString(1, singer.getProfile());
			pre.setInt(2, singer.getSingerId());
			count = pre.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dao.closeConn(null, null, pre, con);
		}
		return count;
	}
}