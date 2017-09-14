package com.gzc.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gzc.bean.News;
import com.gzc.dao.NewsDao;
import com.gzc.db.ConnDB;
import com.gzc.util.PageModel;

public class NewsDaoImpl implements NewsDao {

	public void add(News bean) {
		try {
			Connection conn = ConnDB.getConn();
			String sql = "insert into news values(news_seq.nextval,?,?,?,to_date(?,'yyyy-MM-dd'),?,?,?,?,?)";
			PreparedStatement ps = conn.prepareCall(sql);
			ps.setString(1, bean.getTitle());
			ps.setString(2, bean.getPic());
			ps.setString(3, bean.getContent());
			ps.setString(4, bean.getPubdate());
			ps.setString(5, bean.getAuthor());
			ps.setInt(6, 0);
			ps.setInt(7, bean.getIstop());
			ps.setInt(8, bean.getTid());
			ps.setInt(9, bean.getSort());
			ps.execute();
			ConnDB.closeConn(null, ps, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void delete(int nid) {

		try {
			Connection conn = ConnDB.getConn();
			String sql = "delete from news where nid=?";
			PreparedStatement ps = conn.prepareCall(sql);
			ps.setInt(1, nid);
			ps.execute();
			ConnDB.closeConn(null, ps, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public News findById(int nid) {
		News news = null;
		try {
			Connection conn = ConnDB.getConn();
			String sql = " select  * from news where  nid=?";
			PreparedStatement ps = conn.prepareCall(sql);
			ps.setInt(1, nid);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				news = new News();
				news.setNid(rs.getInt(1));
				news.setTitle(rs.getString(2));
				news.setPic(rs.getString(3));
				news.setContent(rs.getString(4));
				news.setPubdate(rs.getString(5));
				news.setAuthor(rs.getString(6));
				news.setDonum(rs.getInt(7));
				news.setIstop(rs.getInt(8));
				news.setTid(rs.getInt(9));
				news.setSort(rs.getInt(10));
			}
			ConnDB.closeConn(rs, ps, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return news;
	}

	public List<News> findPicNews() {// flag=gzfc
		List<News> list = null;
		try {
			Connection conn = ConnDB.getConn();
			String sql = "select  * from (select  n.*,t.flag from news n ,newstype t  where n.tid=t.tid  and   t.flag='gzfc'  and  istop=1  and pic is not null     order by sort asc) t  where  rownum  between 1 and 10";
			PreparedStatement ps = conn.prepareCall(sql);

			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				list = new ArrayList<News>();
				while (rs.next()) {
					News news = new News();
					news.setNid(rs.getInt(1));
					String title = rs.getString(2);
					news.setContent(title); // 预先将标题 放入 content中
					if (title != null && title.length() > 14)
						title = title.substring(0, 12) + "..";
					news.setTitle(title);
					news.setPic(rs.getString(3));
					// news.setContent(rs.getString(4));
					news.setPubdate(rs.getString(5).substring(0, 10));
					news.setAuthor(rs.getString(6));
					news.setDonum(rs.getInt(7));
					news.setIstop(rs.getInt(8));
					news.setTid(rs.getInt(9));
					news.setSort(rs.getInt(10));
					list.add(news);
				}
			}
			ConnDB.closeConn(rs, ps, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
System.out.println( list.size());
		return list;
	}

	public List<News> findNews(String flag, int num) {// flag=cnxw
		// ,gzdt,gzfc....
		List<News> list = null;
		try {
			Connection conn = ConnDB.getConn();
			String sql = "select  * from (select  n.*,t.flag from news n ,newstype t  where n.tid=t.tid  and  t.flag=?  and  istop=1    order by sort asc) tnews where  rownum  between 1 and  ? ";
			PreparedStatement ps = conn.prepareCall(sql);
			ps.setString(1, flag);
			ps.setInt(2, num);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				list = new ArrayList<News>();
				while (rs.next()) {
					News news = new News();
					news.setNid(rs.getInt(1));
					String title = rs.getString(2);
					news.setContent(title); // 预先将标题 放入 content中
					if (title != null && title.length() > 22)
						title = title.substring(0, 20) + "..";
					news.setTitle(title);
					news.setPic(rs.getString(3));
					// news.setContent(rs.getString(4));
					news.setPubdate(rs.getString(5).substring(0, 10));
					news.setAuthor(rs.getString(6));
					news.setDonum(rs.getInt(7));
					news.setIstop(rs.getInt(8));
					news.setTid(rs.getInt(9));
					news.setSort(rs.getInt(10));
					list.add(news);
				}
			}
			ConnDB.closeConn(rs, ps, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	public PageModel findByPage(int nowpage, int tid) {
		PageModel pageModel = new PageModel();
		List<News> list = null;
		try {
			Connection conn = ConnDB.getConn();
			CallableStatement cs = conn
					.prepareCall("{ call  pagesplit(?,?,?,?,?,?,?,?)  }");
			cs.setString(1, "viewnews"); // 表名
			cs.setInt(2, nowpage);// 当前页
			cs.setInt(3, PageModel.pagesize);// 每页条数
			cs.setString(4, "  tid=" + tid + " ");// where 条件
			cs.setString(5, " sort asc, nid  desc  "); // order by 顺序
			cs.registerOutParameter(6, oracle.jdbc.OracleTypes.CURSOR);// 结果集合
			cs.registerOutParameter(7, oracle.jdbc.OracleTypes.NUMBER);// 总条数
			cs.registerOutParameter(8, oracle.jdbc.OracleTypes.NUMBER);// 总页数
			cs.execute();
			ResultSet rs = (ResultSet) cs.getObject(6);
			if (rs != null) {
				list = new ArrayList<News>();
				while (rs.next()) {
					News news = new News();
					news.setNid(rs.getInt(1));
					news.setTitle(rs.getString(2));
					news.setPic(rs.getString(3));
					news.setContent(rs.getString(4));
					// 将时间截取，取前10个字符
					news.setPubdate(rs.getString(5).substring(0, 10));
					news.setAuthor(rs.getString(6));
					news.setDonum(rs.getInt(7));
					news.setIstop(rs.getInt(8));
					news.setTid(rs.getInt(9));
					news.setSort(rs.getInt(10));
					// 将视图中的 分类名存入 news对象
					news.setTname(rs.getString(11));
					list.add(news);
				}
			}

			pageModel.setTotalsize(cs.getLong(7));
			pageModel.setTotalpage(cs.getLong(8));
			pageModel.setList(list);
			pageModel.setNowpage(nowpage);

			ConnDB.closeConn(rs, cs, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String pageinfo = getPageinfo(pageModel, tid);
		pageModel.setPageinfo(pageinfo);
		return pageModel;
	}

	public String getPageinfo(PageModel pageModel, int tid) { // 后台分页信息
		StringBuffer sb = new StringBuffer();
		sb.append("<form  name=formgo   method=get  action=NewsServlet  >");
		sb.append("  <a href=NewsServlet?nowpage=1&tid=" + tid
				+ ">首页</a>&nbsp;&nbsp;");
		if (pageModel.getNowpage() == 1)
			sb.append("上一页");
		else
			sb.append("<a href=NewsServlet?nowpage="
					+ (pageModel.getNowpage() - 1) + "&tid=" + tid
					+ " >上一页</a>&nbsp;&nbsp;");
		if (pageModel.getNowpage() == pageModel.getTotalpage())
			sb.append("下一页");
		else
			sb.append("  <a href=NewsServlet?nowpage="
					+ (pageModel.getNowpage() + 1) + "&tid=" + tid
					+ " >下一页</a>&nbsp;&nbsp;");
		sb.append("  <a href=NewsServlet?nowpage=" + pageModel.getTotalpage()
				+ "&tid=" + tid + " >尾页</a>&nbsp;&nbsp;");
		sb.append("总共" + pageModel.getTotalsize() + "条&nbsp;&nbsp;");
		sb.append("总共" + pageModel.getTotalpage() + "页&nbsp;&nbsp;");
		sb.append("<input type=hidden name=tid   value=" + tid + "   /> ");
		sb.append("跳<input type=text name=nowpage   size=1 value="
				+ pageModel.getNowpage() + "   />   页");
		sb.append("<input type=image  src=images/go.bmp  />");
		sb.append("</form>	");
		return sb.toString();
	}

	public void update(News bean) {
		try {
			Connection conn = ConnDB.getConn();
			String sql = "update   news  set     title=?  ,pic=?,content=?,pubdate=to_date(?,'yyyy-MM-dd'),author=?,donum=?,istop=?,tid=?,sort=? where nid=?";
			PreparedStatement ps = conn.prepareCall(sql);
			ps.setString(1, bean.getTitle());
			ps.setString(2, bean.getPic());
			ps.setString(3, bean.getContent());
			ps.setString(4, bean.getPubdate());
			ps.setString(5, bean.getAuthor());
			ps.setInt(6, bean.getDonum());
			ps.setInt(7, bean.getIstop());
			ps.setInt(8, bean.getTid());
			ps.setInt(9, bean.getSort());
			ps.setInt(10, bean.getNid());
			ps.execute();
			ConnDB.closeConn(null, ps, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
