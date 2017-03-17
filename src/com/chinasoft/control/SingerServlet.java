package com.chinasoft.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasoft.entity.Singer;
import com.chinasoft.service.SingerService;

@WebServlet("/admin/SingerServlet")
public class SingerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		if ("Allsinger".equals(op)) {
			Allsinger(request, response);
		} else if ("deleteSinger".equals(op)) {
			deleteSinger(request, response);
		}

	}
	/**
	 * 查询所有歌手
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void Allsinger(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		SingerService service = new SingerService();
		ArrayList<Singer> list = service.selectAllSinger();
		request.setAttribute("singer", list);
		request.getRequestDispatcher("/admin/singer.jsp").forward(request,
				response);
	}
	/**
	 * 根据歌手id删除歌手
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void deleteSinger(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String singerid = request.getParameter("singerId");
		SingerService service = new SingerService();
		int count = service.deleteSingerById(singerid);
		if (count > 0) {
			System.out.println("删除了：" + singerid);
		}
		// 删除之后查询所有歌手信息
		Allsinger(request, response);
	}
	protected void insertSinger(){
		
	}
}
