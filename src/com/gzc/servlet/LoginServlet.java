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

public class LoginServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public LoginServlet() {
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

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out
				.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
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

		String uname = request.getParameter("uname");
		String upwd = request.getParameter("upwd");
		//获取表单中  控件中的验证码
		String  verifycode=request.getParameter("verifycode");
		//获取session中生成的验证码
		String  rand=(String)request.getSession().getAttribute("rand");
		if(!verifycode.equals(rand)){
			//没有找到 重新登录
			request.setAttribute("message", "验证码错误!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else{
		UsersDao dao = new UsersDaoImpl();
		Users bean = dao.findByUnameAndUpwd(uname, upwd);
		if(bean==null){
			//没有找到 重新登录
			request.setAttribute("message", "用户名或者密码错误!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else{
			//找到了跳转 主页
			 request.getSession().setAttribute("username", bean.getUname()); 
			request.getRequestDispatcher("index.jsp").forward(request, response);
			
		}
		
		}
		
		
		

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
