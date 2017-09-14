package com.gzc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gzc.bean.Team;
import com.gzc.dao.TeamDao;
import com.gzc.dao.impl.TeamDaoImpl;
import com.gzc.util.PageModel;

public class TeamServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public TeamServlet() {
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
		TeamDao dao = new TeamDaoImpl();
		// 删除 和查询
		String tid = request.getParameter("tid");
		if (tid != null) {
			// 删除
			dao.delete( Integer.parseInt(tid) );
		}

		// 存数据
		
		
		
		
		String nowpage=	request.getParameter("nowpage")==null?"1":request.getParameter("nowpage");
		

		PageModel pageModel = dao.findByPage(Integer.parseInt(nowpage));

		request.setAttribute("pageModel", pageModel);

		// 返回到列表页面 查询
		request.getRequestDispatcher("teamList.jsp").forward(request, response);

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
		
		request.setCharacterEncoding("UTF-8");//将请求中的文字转换为UTF-8格式
		
		Team team = new Team();
		team.setInfomation(request.getParameter("infomation"));
		team.setPic(request.getParameter("pic"));
		team.setPosition(request.getParameter("position"));
		team.setSex(Integer.parseInt(request.getParameter("sex")));
		team.setSort(Integer.parseInt(request.getParameter("sort")));
		team.setTname(request.getParameter("tname"));
		team.setWorkinfo(request.getParameter("workinfo"));
		
		TeamDao dao=new TeamDaoImpl();

		// 增加 和 修改
		String tid = request.getParameter("tid");
		if (tid == null) {
            dao.add(team);
		} else {
              team.setTid(Integer.parseInt(tid));
		     dao.update(team);
		}
		
		
		String nowpage=	request.getParameter("nowpage")==null?"1":request.getParameter("nowpage");
		
		
		PageModel pageModel = dao.findByPage(Integer.parseInt(nowpage));
		request.setAttribute("pageModel", pageModel);
		// 返回到列表页面 查询
		request.getRequestDispatcher("teamList.jsp").forward(request, response);

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
