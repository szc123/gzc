package com.gzc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gzc.bean.NewsType;
import com.gzc.dao.NewsTypeDao;
import com.gzc.dao.impl.NewsTypeDaoImpl;

public class NewsTypeServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public NewsTypeServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
        //获取需要删除的id
		String tid=request.getParameter("tid");
		NewsTypeDao newsTypedao = new NewsTypeDaoImpl();
		if(tid!=null){//如果主键id存在就删除  
			newsTypedao.delete(Integer.parseInt(tid));
		}
		// 保存出口数据
		request.setAttribute("newsTypelist", newsTypedao.findAll());
		// 跳转到出口
		request.getRequestDispatcher("newsTypeList.jsp").forward(request, response);
		
		
		
		
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//1定义一个用户对象  然后将用户名和密码填入该用户中
		NewsType bean = new NewsType();
		bean.setTname(request.getParameter("tname")); 
		bean.setFlag(request.getParameter("flag"));
		//2 实例化数据操作 层  来增加或者修改用户
		NewsTypeDao newsTypedao = new NewsTypeDaoImpl();
		//3获取主键id
		String tid = request.getParameter("tid");
		if (tid == null) {//如果没有主键说明是增加数据
			newsTypedao.add(bean);
		} else {//否则有主键是修改数据 ,在修改之前将id存入对象中
			bean.setTid(Integer.parseInt(tid));
			newsTypedao.update(bean);
		}
		//4 保存出口数据
		request.setAttribute("newsTypelist", newsTypedao.findAll());
		//5 跳转到出口
		request.getRequestDispatcher("newsTypeList.jsp").forward(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}
}
