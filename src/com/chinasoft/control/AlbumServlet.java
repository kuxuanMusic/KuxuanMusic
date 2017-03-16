package com.chinasoft.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasoft.service.AlbumService;



/**
 * Servlet implementation class AlbumServlet
 */
@WebServlet("/AlbumServlet")
public class AlbumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AlbumServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		if ("addAlbum".equals(op)) {
			addAlbum(request, response);
		} else if ("addAlbumType".equals(op)) {
			addAlbumType(request, response);
		}
	}


	private void addAlbumType(HttpServletRequest request, HttpServletResponse response) {
		// 获取页面参数
				String type = request.getParameter("type");				
				// 调用service处理新增业务
				AlbumService service = new AlbumService();
				int res = 3;				
				res = service.addAlbumType(type);				
				if (res == 1) {					
					//新增成功
					try {
						response.sendRedirect(request.getContextPath() + "/albumType.jsp");
					} catch (IOException e) {
						
						e.printStackTrace();
					}
				} else if (res == 2) {
					request.setAttribute("msg", "类型已存在");
					try {
						request.getRequestDispatcher("/addAlbumType.jsp").forward(request, response);
					} catch (ServletException e) {
						
						e.printStackTrace();
					} catch (IOException e) {
						
						e.printStackTrace();
					}
				} else {
					request.setAttribute("msg", "新增失败");
					try {
						request.getRequestDispatcher("/addAlbumType.jsp").forward(request, response);
					} catch (ServletException e) {
						
						e.printStackTrace();
					} catch (IOException e) {
						
						e.printStackTrace();
					}
				}
		
	}


	private void addAlbum(HttpServletRequest request, HttpServletResponse response) {
		// 获取页面参数
		String name = request.getParameter("name");				
		String date = request.getParameter("date");				
		String comppany = request.getParameter("company");				
		String type = request.getParameter("type");				
		String language = request.getParameter("language");				
		// 调用service处理新增业务
		AlbumService service = new AlbumService();
		int res = 3;				
		res = service.addAlbumType(type);				
		if (res == 1) {					
			//新增成功
			try {
				response.sendRedirect(request.getContextPath() + "/albumType.jsp");
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		} else if (res == 2) {
			request.setAttribute("msg", "类型已存在");
			try {
				request.getRequestDispatcher("/addAlbumType.jsp").forward(request, response);
			} catch (ServletException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		} else {
			request.setAttribute("msg", "新增失败");
			try {
				request.getRequestDispatcher("/addAlbumType.jsp").forward(request, response);
			} catch (ServletException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		
	}

}
