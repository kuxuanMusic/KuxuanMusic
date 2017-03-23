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
import com.chinasoft.util.PageModel;
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
		request.setCharacterEncoding("utf-8");
		String op = request.getParameter("op");						
		if ("addAlbum".equals(op)) {
			addAlbum(request, response);
		} else if ("addAlbumType".equals(op)) {
			addAlbumType(request, response);
		}		
		else if ("changeAlbum".equals(op)){
			changeAlbum(request, response);
		}
		else if ("updateAlbum".equals(op)){
			updateAlbum(request, response);
		}else if("albuminfoFenye".equals(op)){
			albuminfoFenye(request, response);
		}
		else if("albumTypeinfoFenye".equals(op)){
			albumTypeinfoFenye(request, response);
		}		
	}
			
	/**
	 * @return 1：新增成功  2：类型存在  0：新增失败
	 * decription :新增专辑类型
	 * 
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
					request.setAttribute("msg", "新增成功");
					
						try {
							try {
								request.getRequestDispatcher("/admin/addAlbumType.jsp").forward(request, response);
							} catch (IOException e) {
								
								e.printStackTrace();
							}
						} catch (ServletException e) {
							
							e.printStackTrace();
						}
					
				} else if (res == 2) {
					request.setAttribute("msg", "类型已存在");
					try {
						request.getRequestDispatcher("/admin/addAlbumType.jsp").forward(request, response);
					} catch (ServletException e) {
						
						e.printStackTrace();
					} catch (IOException e) {
						
						e.printStackTrace();
					}
				} else {
					request.setAttribute("msg", "新增失败");
					try {
						request.getRequestDispatcher("/admin/addAlbumType.jsp").forward(request, response);
					} catch (ServletException e) {
						
						e.printStackTrace();
					} catch (IOException e) {
						
						e.printStackTrace();
					}
				}		
	}
	
	/**
	 * 
	 *  
	 * @return 1：新增成功  0：新增失败
	 * decription :新增专辑
	 * 
	 */

	protected void addAlbum(HttpServletRequest request, HttpServletResponse response) {
		// 获取页面参数
		
		String name = request.getParameter("name");				
		String date = request.getParameter("date");				
		String company = request.getParameter("company");				
		int type = Integer.valueOf(request.getParameter("type"));				
		int language = Integer.valueOf(request.getParameter("language"));		
		// 调用service处理新增业务
		AlbumService service = new AlbumService();
		int res = 3;				
		res = service.addAlbum(name,language,date,company, type);		
		if (res == 1) {					
			//新增成功
			request.setAttribute("msg", "新增成功");
			try {
				request.getRequestDispatcher("/admin/addAlbum.jsp").forward(request, response);
			} catch (ServletException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		
		} else {
			request.setAttribute("msg", "新增失败");
			try {
				request.getRequestDispatcher("/admin/addAlbum.jsp").forward(request, response);
			} catch (ServletException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		
	}
	
	/**
	 * 
	 *  
	 * @return 1：修改成功  0：修改失败
	 * decription :修改专辑
	 * 
	 */
	protected void updateAlbum(HttpServletRequest request, HttpServletResponse response) {
		// 获取页面参数
		int id=Integer.valueOf(request.getParameter("id"));
		String name = request.getParameter("name");				
		String date = request.getParameter("date");				
		String company = request.getParameter("company");				
		int type = Integer.valueOf(request.getParameter("type"));				
		int language = Integer.valueOf(request.getParameter("language"));				
		AlbumService service = new AlbumService();
		int res = 3;				
		res = service.uppdateAlbum(id,name,language,date,company, type);		
		if (res == 1) {								
			request.setAttribute("msg", "修改成功");
			try {
				request.getRequestDispatcher("/admin/updateAlbum.jsp").forward(request, response);
			} catch (ServletException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		
		} else {
			request.setAttribute("msg", "修改失败");
			try {
				request.getRequestDispatcher("/admin/updateAlbum.jsp").forward(request, response);
			} catch (ServletException e) {				
				e.printStackTrace();
			} catch (IOException e) {				
				e.printStackTrace();
			}
		}		
	}
	/**
	 * 	 
	 * decription :分页查询所有的专辑
	 * 
	 */
	protected void albuminfoFenye(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		// 每页多少条数据
		int pageSize = 0;		
		// 当前是第几页
		int pageNo = 0;	
			
		// 当前页
		pageNo = Integer.valueOf(request.getParameter("pageNo"));
		pageSize = Integer.valueOf(request.getParameter("pageSize"));		
		AlbumService cs = new AlbumService();
		PageModel pm = cs.getAlbumInfoFenye(pageNo, pageSize);
		
		request.setAttribute("pm", pm);
		request.getRequestDispatcher("/admin/album.jsp").forward(request, response);
	}
	/**
	 * 
	 * decription :分页查询所有的专辑类型 
	 */
	protected void albumTypeinfoFenye(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		// 每页多少条数据
		int pageSize = 0;		
		// 当前是第几页
		int pageNo = 0;				
		// 当前页
		pageNo = Integer.valueOf(request.getParameter("pageNo"));
		pageSize = Integer.valueOf(request.getParameter("pageSize"));		
		AlbumService cs = new AlbumService();
		PageModel pm = cs.getAlbumTypeInfoFenye(pageNo, pageSize);		
		request.setAttribute("pm", pm);
		request.getRequestDispatcher("/admin/albumType.jsp").forward(request, response);
	}
	
	/**
	 *  
	 * @return 专辑对象
	 * decription :根据id查询专辑
	 * 
	 */
	protected void changeAlbum(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		String albumId = request.getParameter("albumId");		
		AlbumService as = new AlbumService();
		Album al = as.changeAlbum(albumId);				
		request.setAttribute("al", al);
		request.getRequestDispatcher("/admin/updateAlbum.jsp").forward(request, response);
	}
}
