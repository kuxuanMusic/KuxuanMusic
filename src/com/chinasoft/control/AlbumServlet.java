package com.chinasoft.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasoft.entity.Album;
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
		System.out.println("1");
		String op = request.getParameter("op");
		if ("addAlbum".equals(op)) {
			addAlbum(request, response);
		} else if ("addAlbumType".equals(op)) {
			addAlbumType(request, response);
		}else if ("albuminfo".equals(op)) {
			albuminfo(request, response);
		}else if ("albumTypeinfo".equals(op)) {
			albumTypeinfo(request, response);
		}
		else if ("deleteAlbum".equals(op)){
			deleteAlbum(request, response);
		}
		else if ("changeAlbum".equals(op)){
			changeAlbum(request, response);
		}
//		albumTypeinfo(request, response);
		
	}
	/**	 
	 * decription :查询所有的专辑	 
	 */
	protected void albuminfo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 查询所有专辑信息
		AlbumService as = new AlbumService();
		ArrayList<Album> list = as.getAlbuminfo();

		request.setAttribute("album", list);
		request.getRequestDispatcher("/admin/album.jsp").forward(request, response);
	}
	
	/**	 
	 * decription :查询所有的专辑类型	 
	 */
	protected void albumTypeinfo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		// 查询所有专辑类型
		AlbumService as = new AlbumService();
		ArrayList<String> list = as.getAlbumTypeinfo();		
		request.setAttribute("albumtype", list);
		request.getRequestDispatcher("/admin/albumType.jsp").forward(request, response);
	}
	
	/**	 
	 * decription :增加专辑类型	 
	 */

	protected void addAlbumType(HttpServletRequest request, HttpServletResponse response) {
		// 获取页面参数
		
				String type = request.getParameter("type");				
				// 调用service处理新增业务
				AlbumService service = new AlbumService();
				int res = 3;				
				res = service.addAlbumType(type);				
				if (res == 1) {					
					//新增成功
					try {
						response.sendRedirect("/albumType.jsp");
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
	public  int toInt(String str ){
		Integer integer = new Integer(str);
		  return integer.parseInt(str);
		 }
	
	/**	 
	 * decription :增加专辑	 
	 */

	protected void addAlbum(HttpServletRequest request, HttpServletResponse response) {
		// 获取页面参数
		System.out.println("2");
		String name = request.getParameter("name");				
		String date = request.getParameter("date");				
		String company = request.getParameter("company");				
		int type = toInt(request.getParameter("type"));				
		int language = toInt(request.getParameter("language"));
		System.out.println(name);
		// 调用service处理新增业务
		AlbumService service = new AlbumService();
		int res = 3;				
		res = service.addAlbum(name,language,date,company, type);				
		if (res == 1) {					
			//新增成功
			try {
				response.sendRedirect("/addAlbum.jsp");
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		
		} else {
			request.setAttribute("msg", "新增失败");
			try {
				request.getRequestDispatcher("/addAlbum.jsp").forward(request, response);
			} catch (ServletException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		
	}
	
	/**	 
	 * decription :删除专辑	 
	 */
	protected void deleteAlbum(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 删除专辑
		String albumId = request.getParameter("albumId");
		AlbumService as = new AlbumService();
		int reuslt = as.removeAlbum(albumId);		
		String pageNo = request.getParameter("pageNo");
		String pageSize = request.getParameter("pageSize");		
		request.getRequestDispatcher("/admin/album?op=albuminfoFenye&pageNo=" + pageNo + "&pageSize" + pageSize).forward(request, response);

	}
	
	/**	 
	 * decription :更改专辑	 
	 */

	protected void changeAlbum(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String albumId = request.getParameter("albumId");
		AlbumService as = new AlbumService();
		Album al = as.changeAlbum(albumId);
		request.setAttribute("al", al);

		request.getRequestDispatcher("").forward(request, response);
	}

}
