package com.chinasoft.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasoft.entity.MV;
import com.chinasoft.entity.Music;
import com.chinasoft.service.MVService;

@WebServlet("/admin/MVServlet")
public class MVServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String op = request.getParameter("op");
		if("addMV".equals(op)){
			addMV(request, response);
		}else if("getAllMV".equals(op)){
			getAllMV(request, response);
		}
		else if("getMVBySingerName".equals(op)){
			getMVBySingerName(request, response);
		}
	}
	protected void addMV(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {	
		
		String singerName = request.getParameter("singerName");
		MVService ms = new MVService();
		int singerId = ms.selectSingerIdBySingerName(singerName);
		if (singerId > 0){
			String musicName = request.getParameter("musicName");
			int musicId = ms.selectMusicIdByMusicNameAndSingerId(singerId, musicName);
			if (musicId > 0) {
				String mvAddress = request.getParameter("mvAddress");
				int result = ms.addMV(musicId, mvAddress);
				if(result==1){
					request.setAttribute("msg", "mv上传成功");
				}else{
					request.setAttribute("msg", "mv上传失败");
				}
			}else{
				request.setAttribute("msg", "歌曲不存在");
			}
		}else{
			request.setAttribute("msg", "歌手不存在");
		}


	}
	protected void getAllMV(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	
		MVService ms = new MVService();
		ArrayList<MV> list1 =new ArrayList<>();
		list1 = ms.selectAllMV();
		for(MV temp:list1){
			int musicId = temp.getMusicId();
			//ms.selectMusicAddSinderIdNameByMusicID();
		}

	}
	
	protected void getMVBySingerName(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	
		String singerName = request.getParameter("singerName");
		MVService ms = new MVService();
		int singerId = ms.selectSingerIdBySingerName(singerName);
		if (singerId > 0) {
			Map<Music,MV> map = new HashMap<>();
			map =ms.getMVBySingerId(singerId);
			request.setAttribute("map", map);
			request.getRequestDispatcher("allMV.jsp").forward(request, response);
		}else{
			request.setAttribute("msg", "查询错误");
		}
	
		}

	}
	

