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
import com.chinasoft.util.PageModel;

@WebServlet("/admin/SingerServlet")
public class SingerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String op = request.getParameter("op");
		if ("Allsinger".equals(op)) {
			Allsinger(request, response);
		} else if ("deleteSinger".equals(op)) {
			deleteSinger(request, response);
		} else if ("insertSinger".equals(op)) {
			insertSinger(request, response);
		} else if ("SingerPage".equals(op)) {
			SingerPage(request, response);
		} else if ("showSinger".equals(op)) {
			showSinger(request, response);
		} else if ("updateSinger".equals(op)) {
			updateSinger(request, response);
		}
	}

	/**
	 * 查询所有歌手，带换页
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void SingerPage(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 每页多少条数据
		int pageSize = 0;
		// 当前是第几页
		int pageNo = 0;
		// 当前页
		pageNo = Integer.valueOf(request.getParameter("pageNo"));
		pageSize = Integer.valueOf(request.getParameter("pageSize"));

		SingerService service = new SingerService();
		PageModel pm = service.getSingerPage(pageNo, pageSize);

		request.setAttribute("pm", pm);
		request.getRequestDispatcher("/admin/singer.jsp").forward(request,
				response);
	}

	/**
	 * 查询所有歌手
	 * 
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
	 * 
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

		String pageNo = request.getParameter("pageNo");
		String pageSize = request.getParameter("pageSize");
		request.getRequestDispatcher(
				"SingerServlet?op=SingerPage&pageNo=" + pageNo + "&pageSize"
						+ pageSize).forward(request, response);
	}

	/**
	 * 新增歌手，先会判断歌手是否已经存在
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void insertSinger(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String singerName = request.getParameter("singerName");
		String singerProfile = request.getParameter("singerProfile");
		Singer singer = new Singer();
		singer.setSingerName(singerName);
		singer.setProfile(singerProfile);
		SingerService service = new SingerService();
		boolean b = service.selectSingerByName(singerName);
		if (!b) {
			int count = service.insertSinger(singer);
			request.setAttribute("msg", "歌手添加成功");
			request.getRequestDispatcher("addSinger.jsp").forward(request,
					response);
		} else {
			request.setAttribute("msg", "歌手已经存在了");
			request.getRequestDispatcher("addSinger.jsp").forward(request,
					response);
		}
	}

	/**
	 * 修改歌手资料之前查询并显示歌手资料
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void showSinger(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String singerId = request.getParameter("singerId");
		SingerService service = new SingerService();
		ArrayList<Singer> list = service.selectSingerById(singerId);
		request.setAttribute("list", list);
		request.getRequestDispatcher("updateSinger.jsp").forward(request,
				response);
	}

	/**
	 * 修改歌手资料
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void updateSinger(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("singerName");
		String profile = request.getParameter("singerProfile");

		Singer singer = new Singer();
		singer.setSingerId(Integer.valueOf(id));
		singer.setSingerName(name);
		singer.setProfile(profile);
		SingerService service = new SingerService();
		service.updateSinger(singer);
		request.getRequestDispatcher(
				"SingerServlet?op=SingerPage&pageNo=1&pageSize=5").forward(
				request, response);
	}
}
