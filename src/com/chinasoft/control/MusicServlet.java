package com.chinasoft.control;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasoft.entity.Music;
import com.chinasoft.entity.MusicSingerAndAlbum;
import com.chinasoft.service.MusicService;
import com.chinasoft.util.DateUtil;

import net.sf.json.JSONObject;

/**
 * 与音乐相关的servlet
 * 
 * @author Administrarors
 *
 */
@WebServlet("/admin/MusicServlet")
public class MusicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String op = request.getParameter("op");

		if ("addMusic".equals(op)) {
			addMusic(request, response);
		} else if ("allMusic".equals(op)) {
			selectAllMusic(request, response);
		} else if ("updateMusic".equals(op)) {
			updateMusic(request, response);
		} else if ("musicFenye".equals(op)) {
			musicFenye(request, response);
		}
	}

	/**
	 * 查询所有歌曲
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void selectAllMusic(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MusicService service = new MusicService();
		ArrayList<MusicSingerAndAlbum> list = service.selectAllMusic();
		request.setAttribute("musicSingerAndAlbum", list);
		request.getRequestDispatcher("allMusic.jsp").forward(request, response);
	}

	/**
	 * 修改歌曲信息
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void updateMusic(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MusicService service = new MusicService();
		Music music = new Music();
		music.setMusicId(Integer.valueOf(request.getParameter("musicid")));

		String singerName = request.getParameter("singername"); // 歌手名
		// 判断歌手是否存在
		int singerId = service.selectSingerBySingerName(singerName);
		if (singerId != -1) {
			music.setSingerId(singerId); // 歌手ID
		} else {
			// 返回添加歌曲页面，并提示：歌手不存在
			request.setAttribute("msg", "该歌手不存在");
		}

		String albumName = request.getParameter("albumname"); // 专辑名
		// 判断专辑是否存在
		int albumId = service.selectAlbumIdByAlbumName(albumName);
		if (albumId != -1) {
			music.setAlbumId(albumId); // 专辑ID
		} else {
			// 返回添加歌曲页面，并提示：专辑不存在
			request.setAttribute("msg", "该专辑不存在");
		}
		music.setReleaseTime(DateUtil.stringToDate(request.getParameter("releasetime"))); // 发行时间
		music.setTypeId(Integer.valueOf(request.getParameter("musictype"))); // 歌曲类型
		music.setLanguageId(Integer.valueOf(request.getParameter("language"))); // 语种
		music.setAddress(request.getParameter("address")); // 歌曲存放地址
		int result = service.updateMusic(music);
		if (result == 1) {
			request.setAttribute("msg", "歌曲修改成功");
		} else {
			request.setAttribute("msg", "歌曲修改失败");
		}
	}

	/**
	 * 添加音乐
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void addMusic(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MusicService service = new MusicService();
		Music music = new Music();
		music.setMusicName(request.getParameter("musicname")); // 歌曲名

		String singerName = request.getParameter("singername"); // 歌手名
		// 判断歌手是否存在
		int singerId = service.selectSingerBySingerName(singerName);
		if (singerId != -1) {
			music.setSingerId(singerId); // 歌手ID
		} else {
			// 返回添加歌曲页面，并提示：歌手不存在
			request.setAttribute("msg", "该歌手不存在");
			request.getRequestDispatcher("addMusic.jsp").forward(request, response);
		}

		String albumName = request.getParameter("albumname"); // 专辑名
		// 判断专辑是否存在
		int albumId = service.selectAlbumIdByAlbumName(albumName);
		if (albumId != -1) {
			music.setAlbumId(albumId); // 专辑ID
		} else {
			// 返回添加歌曲页面，并提示：专辑不存在
			request.setAttribute("msg", "该专辑不存在");
			request.getRequestDispatcher("addMusic.jsp").forward(request, response);
		}

		music.setReleaseTime(DateUtil.stringToDate(request.getParameter("releasetime"))); // 发行时间
		music.setTypeId(Integer.valueOf(request.getParameter("musictype"))); // 歌曲类型
		music.setLanguageId(Integer.valueOf(request.getParameter("language"))); // 语种
		music.setAddress(request.getParameter("address")); // 歌曲存放地址
		// 添加歌曲
		// System.out.println(music);
		int result = service.addMusic(music);
		if (result == 0) {
			request.setAttribute("msg", "数据库异常，请联系数据库管理员");
			request.getRequestDispatcher("addMusic.jsp").forward(request, response);
		} else if (result == 1) {
			request.setAttribute("msg", "歌曲添加成功");
			request.getRequestDispatcher("addMusic.jsp").forward(request, response);
		} else if (result == 2) {
			request.setAttribute("msg", "歌曲已存在");
			request.getRequestDispatcher("addMusic.jsp").forward(request, response);
		}
	}

	/**
	 * 音乐分页查询
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void musicFenye(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 每页多少条数据
		int pageSize = 0;
		// 当前是第几页
		int pageNo = 0;
			
		// 当前页
		pageNo = Integer.valueOf(request.getParameter("page"));
		pageSize = Integer.valueOf(request.getParameter("rows"));
		
		MusicService service = new MusicService();
		ArrayList<MusicSingerAndAlbum> msa = service.selectAllMusic(pageNo, pageSize);
		//System.out.println(msa.toString());
		int total = service.selectMusicCount();
		//System.out.println(total);
		
        request.setAttribute("msa", msa);
        request.setAttribute("total", total);
        request.getRequestDispatcher("allMusic.jsp").forward(request, response);
	}
}
