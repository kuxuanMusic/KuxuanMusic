package com.chinasoft.dao.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.chinasoft.dao.Dao;
import com.chinasoft.entity.Album;
import com.chinasoft.entity.Music;
import com.chinasoft.entity.MusicSingerAndAlbum;
import com.chinasoft.entity.Singer;
import com.chinasoft.util.DateUtil;
import com.chinasoft.util.PageModel;

public class MusicDao {
	/**
	 * 添加音乐
	 * 
	 * @param music
	 * @return (1、添加成功；0、添加失败)
	 */
	public int insertMusic(Music music) {
		// System.out.println("进入插入数据界面");
		String sql = "insert into music values(null, ?, ?, ?, ?, ?, ?, ?)";
		Connection conn = Dao.Connection();
		PreparedStatement ps = null;

		int count = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, music.getMusicName());
			ps.setInt(2, music.getSingerId());
			ps.setInt(3, music.getAlbumId());
			// System.out.println("日期格式转换:" +
			// DateUtil.dateToString(music.getReleaseTime()));
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
	 * @return -1：未查询到歌手信息；1~正无穷：查询到歌手信息
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
			while (rs.next()) {
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
	 * 根据专辑名查询专辑ID
	 * 
	 * @param singerName
	 * @return -1：未查询到专辑信息；1~正无穷：查询到专辑信息
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
			while (rs.next()) {
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
	 * 查询所有歌曲信息（用于后台歌曲信息展示）
	 * 
	 * @return
	 */
	public ArrayList<MusicSingerAndAlbum> selectAllMusic() {
		String sql = "select m.musicid, m.musicname, s.singername, a.albumname, m.releasetime, name, mt.typename, m.adderss from music m, singer s, `language` l, musictype mt, album a where m.singerid = s.singerid and m.albumid = a.albumid and m.languageid = l.id and m.typeid = mt.typeid";
		Connection conn = Dao.Connection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<MusicSingerAndAlbum> list = new ArrayList<>();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				MusicSingerAndAlbum msa = new MusicSingerAndAlbum();
				msa.setMusicId(rs.getInt("m.musicid"));
				msa.setMusicName(rs.getString("m.musicname"));
				msa.setSingerName(rs.getString("s.singername"));
				msa.setAlbumName(rs.getString("a.albumname"));
				msa.setReleaseTime(rs.getString("m.releasetime"));
				msa.setLanguageName(rs.getString("name"));
				msa.setTypeName(rs.getString("mt.typename"));
				msa.setAddress(rs.getString("m.adderss"));
				list.add(msa);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	/**
	 * 修改歌曲（歌手、专辑、发行时间、语种、歌曲存放地址） 
	 * 注：因涉及到MV的相关操作，不能修改歌曲名，要修改歌曲名只能新增歌曲
	 * 
	 * @param music
	 * @return 1：更新成功；0：更新失败；
	 */
	public int updateMusic(Music music) {
		String sql = "UPDATE music m SET m.singerid = ?, m.albumid = ?, m.releasetime = ?, m.languageid = ?, m.typeid m.adderss = ? WHERE musicid = ?";
		Connection conn = Dao.Connection();
		PreparedStatement ps = null;
		int count = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, music.getSingerId());
			ps.setInt(2, music.getAlbumId());
			ps.setString(3, DateUtil.dateToString(music.getReleaseTime()));
			ps.setInt(4, music.getLanguageId());
			ps.setInt(5, music.getTypeId());
			ps.setInt(6, music.getMusicId());
			count = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dao.closeConn(null, null, ps, conn);
		}
		return count;
	}

	/**
	 * 根据页码和条数查询数据
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public ArrayList<MusicSingerAndAlbum> selectAllMusic(int pageNo, int pageSize) {
		String sql = "select m.musicid, m.musicname, s.singername, a.albumname, m.releasetime, name, mt.typename, m.adderss from music m, singer s, `language` l, musictype mt, album a where m.singerid = s.singerid and m.albumid = a.albumid and m.languageid = l.id and m.typeid = mt.typeid limit ?, ?";
		Connection conn = Dao.Connection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<MusicSingerAndAlbum> list = new ArrayList<>();
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, (pageNo - 1)*pageSize );
			ps.setInt(2, pageSize);
			rs = ps.executeQuery();
			while (rs.next()) {
				MusicSingerAndAlbum msa = new MusicSingerAndAlbum();
				msa.setMusicId(rs.getInt("m.musicid"));
				msa.setMusicName(rs.getString("m.musicname"));
				msa.setSingerName(rs.getString("s.singername"));
				msa.setAlbumName(rs.getString("a.albumname"));
				msa.setReleaseTime(rs.getString("m.releasetime"));
				msa.setLanguageName(rs.getString("name"));
				msa.setTypeName(rs.getString("mt.typename"));
				msa.setAddress(rs.getString("m.adderss"));
				list.add(msa);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 查询歌曲条数
	 * @return
	 */
	public int selectMusicCount() {
		String sql = "select count(*) from music";
		Connection conn = Dao.Connection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	
}
