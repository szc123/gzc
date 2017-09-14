package com.gzc.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gzc.bean.Users;
import com.gzc.dao.UsersDao;
import com.gzc.dao.impl.UsersDaoImpl;

public class UsersServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UsersServlet() {
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
        //获取需要删除的id
		String id=request.getParameter("id");
		UsersDao usersdao = new UsersDaoImpl();
		if(id!=null){//如果主键id存在就删除  
			usersdao.delete(Integer.parseInt(id));
		}
		// 保存出口数据
		request.setAttribute("userslist", usersdao.findAll());
		// 跳转到出口
		request.getRequestDispatcher("usersList.jsp").forward(request, response);
		
		
		
		
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
		//1定义一个用户对象  然后将用户名和密码填入该用户中
		Users bean = new Users();
		bean.setUname(request.getParameter("uname")); 
		bean.setUpwd(request.getParameter("upwd"));
		//2 实例化数据操作 层  来增加或者修改用户
		UsersDao usersdao = new UsersDaoImpl();
		//3获取主键id
		String id = request.getParameter("id");
		if (id == null) {//如果没有主键说明是增加数据
			usersdao.add(bean);
		} else {//否则有主键是修改数据 ,在修改之前将id存入对象中
			bean.setId(Integer.parseInt(id));
			usersdao.update(bean);
		}
		//4 保存出口数据
		request.setAttribute("userslist", usersdao.findAll());
		//5 跳转到出口
		request.getRequestDispatcher("usersList.jsp").forward(request, response);
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
