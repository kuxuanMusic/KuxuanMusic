package com.chinasoft.dao.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
		String sql = "insert into music values(null, ?, ?, ?, ?, ?, ?, ?)";
		Connection conn = Dao.Connection();
		PreparedStatement ps = null;

		int count = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, music.getMusicName());
			ps.setInt(2, music.getSingerId());
			ps.setInt(3, music.getAlbumId());
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
	
	//根据歌手名和歌曲名查询歌曲
	public void selectMusicByMusicNameAndSingerName(String music){
		String sql = "SELECT * FROM music m, singer s WHERE m.singerid = s.singerid AND m.musicname = ? AND s.singername = ?";
	}
}
