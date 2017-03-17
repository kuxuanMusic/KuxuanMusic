package com.chinasoft.dao.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.chinasoft.dao.Dao;
import com.chinasoft.entity.Music;
import com.chinasoft.util.DateUtil;

public class MusicDao {
	/**
	 * 添加音乐
	 * 
	 * @param music
	 * @return (1、添加成功；0、添加失败)
	 */
	public int insertMusic(Music music) {
		//System.out.println("进入插入数据界面");
		String sql = "insert into music values(null, ?, ?, ?, ?, ?, ?, ?)";
		Connection conn = Dao.Connection();
		PreparedStatement ps = null;

		int count = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, music.getMusicName());
			ps.setInt(2, music.getSingerId());
			ps.setInt(3, music.getAlbumId());
			//System.out.println("日期格式转换:" + DateUtil.dateToString(music.getReleaseTime()));
			ps.setString(4, DateUtil.dateToString(music.getReleaseTime()));
			ps.setInt(5, music.getLanguageId());
			ps.setInt(6, music.getTypeId());
			ps.setString(7, music.getAddress());

			count = ps.executeUpdate();
			return count;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dao.closeConn(null, null, ps, conn);
		}
		return count;
	}

	/**
	 * 根据歌手Id和歌曲名查询歌曲
	 * 
	 * @param musicName
	 * @param singerName
	 * @return 0、未查询到信息；1、查询到信息
	 */
	public int selectMusicByMusicNameAndSingerId(String musicName, int singerId) {
		String sql = "SELECT * FROM music m WHERE m.musicname = ? AND m.singerId = ?";
		Connection conn = Dao.Connection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, musicName);
			ps.setInt(2, singerId);
			rs = ps.executeQuery();
			while (rs.next()) {
				return 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dao.closeConn(rs, null, ps, conn);
		}
		return 0;
	}

	/**
	 * 根据歌手名查询歌手ID
	 * 
	 * @param singerName
	 * @return  -1：未查询到歌手信息；1~正无穷：查询到歌手信息
	 */
	public int selectSingerBySingerName(String singerName) {
		String sql = "select s.singerid from singer s where s.singername = ?";

		Connection conn = Dao.Connection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, singerName);
			rs = ps.executeQuery();
			while(rs.next()){
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dao.closeConn(rs, null, ps, conn);
		}
		return -1;
	}
	
	/**
	 * 根据歌手名查询歌手ID
	 * 
	 * @param singerName
	 * @return  -1：未查询到专辑信息；1~正无穷：查询到专辑信息
	 */
	public int selectAlbumByAlbumName(String albumName) {
		String sql = "select a.albumid from album a where a.albumname = ?";

		Connection conn = Dao.Connection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, albumName);
			rs = ps.executeQuery();
			while(rs.next()){
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dao.closeConn(rs, null, ps, conn);
		}
		return -1;
	}
}
