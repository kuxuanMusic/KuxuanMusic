package com.chinasoft.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasoft.service.MVService;


@WebServlet("/MVServlet")
public class MVServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String musicName = request.getParameter("musicName");
		String mvAddress=request.getParameter("mvAddress");
		
		MVService ms = new MVService();
		int result = ms.addMV(musicName, mvAddress);
		if(result==1){
			System.out.println("查询成功");
		}else{
			request.setAttribute("msg", "mv上传失败");
			request.getRequestDispatcher("/admin/addMV.jsp").forward(request, response);
		}
		
		
	}
}
