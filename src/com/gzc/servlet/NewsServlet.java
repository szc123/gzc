package com.gzc.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gzc.bean.News;
import com.gzc.dao.NewsDao;
import com.gzc.dao.impl.NewsDaoImpl;
import com.gzc.util.PageModel;

public class NewsServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public NewsServlet() {
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
		NewsDao dao = new NewsDaoImpl();
		// 删除 和查询
		String nid = request.getParameter("nid");
		if (nid != null) {
			// 删除
			dao.delete( Integer.parseInt(nid) );
		}

		// 存数据
		
		
		
		
		String nowpage=	request.getParameter("nowpage")==null?"1":request.getParameter("nowpage");
		String tid=request.getParameter("tid");

		PageModel pageModel = dao.findByPage(Integer.parseInt(nowpage),Integer.parseInt(tid));

		request.setAttribute("pageModel", pageModel);
        request.setAttribute("tid", tid);
		// 返回到列表页面 查询
		request.getRequestDispatcher("newsList.jsp").forward(request, response);

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
		
		News news = new News();
		news.setTitle(request.getParameter("title"));
		news.setPic(request.getParameter("pic"));
		news.setContent(request.getParameter("content"));
		news.setIstop(Integer.parseInt(request.getParameter("istop")));
		news.setSort(Integer.parseInt(request.getParameter("sort")));
		news.setAuthor(request.getParameter("author"));
		news.setPubdate(request.getParameter("pubdate"));
		news.setDonum(Integer.parseInt(request.getParameter("donum")==null?"0":request.getParameter("donum")));
		news.setTid(Integer.parseInt(request.getParameter("tid")));
		
		NewsDao dao=new NewsDaoImpl();

		// 增加 和 修改
		String nid = request.getParameter("nid");
		if (nid == null) {
            dao.add(news);
		} else {
              news.setNid(Integer.parseInt(nid));
		     dao.update(news);
		}
		
		String nowpage=	request.getParameter("nowpage")==null?"1":request.getParameter("nowpage");
		
		PageModel pageModel = dao.findByPage(Integer.parseInt(nowpage),news.getTid());
		request.setAttribute("pageModel", pageModel);
		// 返回到列表页面 查询
		request.setAttribute("tid", news.getTid());
		request.getRequestDispatcher("newsList.jsp").forward(request, response);

	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
	
		
		
		
		
	}

}
