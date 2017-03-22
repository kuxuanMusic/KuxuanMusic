package com.chinasoft.dao.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.chinasoft.dao.Dao;
import com.chinasoft.entity.MV;
import com.chinasoft.entity.Music;
import com.chinasoft.entity.MV;

public class MVDao {
	/**
	 * 插入MV信息
	 * @param musicId
	 * @param mvAddress
	 * @Return: 1 插入mv成功 0 失败
	 * @Description: 插入mv author:
	 */
	public int insertMV(int musicId, String mvAddress) {
		Connection conn = Dao.Connection();
		String sql = "insert into mv values(null,?,?)";
		PreparedStatement ps = null;
		int result = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, musicId);
			ps.setString(2, mvAddress);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dao.closeConn(null, null, ps, conn);
		}
		return result;
	}

	/**
	 * 
	 * @param musicName
	 *            歌曲名字 * @param singerId 歌手id
	 * @Return: 0:未找到 1~正无穷：歌曲ID
	 * @Description: 通过歌曲的名字和歌手id获得歌曲的id
	 */
	public int selectMusicIdByMusicNameAndSingerId(int singerId, String musicName) {
		Connection conn = Dao.Connection();
		String sql = "select musicid from music where musicname = ? and singerid = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		int musicId = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, musicName);
			ps.setInt(2, singerId);
			rs = ps.executeQuery();
			while (rs.next()) {
				musicId = rs.getInt("musicid");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dao.closeConn(rs, null, ps, conn);
		}
		return musicId;
	}

	/**
	 * 
	 * @param musicId
	 *            歌曲id
	 * @Return: 歌曲名
	 * @Description: 通过歌曲id获得歌曲名字
	 */
	public String selectMusicName(int musicId) {
		Connection conn = Dao.Connection();
		String sql = "select musicname from music where musicid=?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		String musicName = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, musicId);
			rs = ps.executeQuery();
			while (rs.next()) {
				musicName = rs.getString("musicname");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dao.closeConn(rs, null, ps, conn);
		}
		return musicName;

	}

	/**
	 * 
	 * @return mv对象的集合 
	 * @Description: 从数据库中获取mv
	 * author:
	 */
	public ArrayList<MV> selectAllMV() {
		Connection conn = Dao.Connection();
		String sql = "select musicid, address from mv ";
		PreparedStatement ps = null;
		ResultSet rs = null;

		ArrayList<MV> list = new ArrayList<>();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				MV mv = new MV();
				mv.setMusicId(rs.getInt("musicid"));
				mv.setAddress(rs.getString("address"));
				list.add(mv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dao.closeConn(rs, null, ps, conn);
		}
		return list;
	}

	/**
	 * 根据歌手名查询歌手ID
	 * 
	 * @param singername
	 * @return 0：未查询到；1~正无穷：歌手ID
	 */
	public int selectSingerIdBySingerName(String singername) {
		Connection conn = Dao.Connection();
		String sql = "select singerid address from singer where singername = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, singername);
			rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt("singerid");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dao.closeConn(rs, null, ps, conn);
		}
		return 0;
	}
	
	public Map getMVBySingerId(int singerId) {
		Connection conn = Dao.Connection();
		String sql = "select a.musicname,b.address from music a ,mv b where a.musicid = b.musicid and singerid=?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		Map<Music, MV> map = new HashMap<>();

		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, singerId);
			rs = ps.executeQuery();
			while (rs.next()) {
				Music ms = new Music();
				MV mv = new MV();
				
				ms.setMusicName(rs.getString("a.musicname"));
				mv.setAddress(rs.getString("b.address"));
				map.put(ms, mv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dao.closeConn(rs, null, ps, conn);
		}
		return map;
	}
}