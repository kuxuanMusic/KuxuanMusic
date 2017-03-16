package com.chinasoft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MVDao {
	/**
	 * 
	 * @param musicId 歌曲id
	 * @param mvAddress mv存放地址
	 * @Return:  1 插入mv成功 0 失败
	 * @Description: 插入mv
	 * author:
	 */
	public int insertMV(int musicId, String mvAddress){
		Connection conn = Dao.Connection();
		String sql = "insert into mv values(null,?,?)";
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, musicId);
			ps.setString(2, mvAddress);
			rs = ps.executeQuery();
			while(rs.next()){
				return 1;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			Dao.closeConn(rs, null, ps, conn);
		}
		return 0;
	}
	
	/**
	 * 
	 * @param musicName 歌曲名字
	 * @Return:  歌曲id
	 * @Description: 通过歌曲的名字获得歌曲的id
	 * author:
	 */
	public int selectMusicId(String musicName){
		Connection conn = Dao.Connection();
		String sql = "select musicid from music m where m.musicname=?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		int musicId=0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, musicName);
			rs = ps.executeQuery();
			while(rs.next()){
				musicId=rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			Dao.closeConn(rs, null, ps, conn);
		}
		return musicId;
	}

}
