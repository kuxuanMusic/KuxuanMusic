package com.chinasoft.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasoft.entity.Music;
import com.chinasoft.service.MusicService;
import com.chinasoft.util.DateUtil;

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
		
		MusicService service = new MusicService();
		if("addMusic".equals(op)){
			Music music = new Music();
			music.setMusicName(request.getParameter("musicName"));
			String singerName = request.getParameter("singername");
			//判断歌手是否存在
			int singerId = service.selectSingerBySingerName(singerName);
			if(singerId != -1){
				music.setSingerId(singerId);
			}else{
				//返回添加歌曲页面，并提示：歌手不存在
				request.setAttribute("msg", "该歌手不存在");
				request.getRequestDispatcher("addMusic.jsp").forward(request, response);
			}
			String albumName = request.getParameter("albumname");
			//判断专辑是否存在
			int albumId = service.selectAlbumIdByAlbumName(albumName);
			if(albumId != -1){
				music.setAlbumId(albumId);
			}else{
				//返回添加歌曲页面，并提示：专辑不存在
				request.setAttribute("msg", "该专辑不存在");
				request.getRequestDispatcher("addMusic.jsp").forward(request, response);
			}
			music.setReleaseTime(DateUtil.stringToDate(request.getParameter("releasetime")));
			music.setTypeId(Integer.valueOf(request.getParameter("musictype")));
			music.setLanguageId(Integer.valueOf(request.getParameter("language")));
			music.setAddress(request.getParameter("address"));
			//添加歌曲
			int result = service.addMusic(music, singerName);
			if(result == 0){
				request.setAttribute("msg", "数据库异常，请联系数据库管理员");
				request.getRequestDispatcher("addMusic.jsp").forward(request, response);
			}else if(result == 1){
				request.setAttribute("msg", "歌曲添加成功");
				request.getRequestDispatcher("addMusic.jsp").forward(request, response);
			}else if(result == 2){
				request.setAttribute("msg", "歌曲已存在");
				request.getRequestDispatcher("addMusic.jsp").forward(request, response);
			}
		}
	}
}
