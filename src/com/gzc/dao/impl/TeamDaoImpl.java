package com.gzc.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gzc.bean.Team;
import com.gzc.dao.TeamDao;
import com.gzc.db.ConnDB;
import com.gzc.util.PageModel;

public class TeamDaoImpl implements TeamDao {

	public void add(Team bean) {
		try {
			Connection conn = ConnDB.getConn();
			String sql = "insert into team values(team_seq.nextval,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareCall(sql);
			ps.setString(1, bean.getTname());
			ps.setString(2, bean.getPosition());
			ps.setString(3, bean.getWorkinfo());
			ps.setString(4, bean.getInfomation());
			ps.setString(5, bean.getPic());
			ps.setInt(6, bean.getSort());
			ps.setInt(7, bean.getSex());
			ps.execute();
			ConnDB.closeConn(null, ps, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void delete(int id) {

		try {
			Connection conn = ConnDB.getConn();
			String sql = "delete from team where tid=?";
			PreparedStatement ps = conn.prepareCall(sql);
			ps.setInt(1, id);
			ps.execute();
			ConnDB.closeConn(null, ps, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Team findById(int id) {
		Team team = null;
		try {
			Connection conn = ConnDB.getConn();
			String sql = " select  * from team where  tid=?";
			PreparedStatement ps = conn.prepareCall(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				team = new Team();
				team.setTid(rs.getInt(1));
				team.setTname(rs.getString(2));
				team.setPosition(rs.getString(3));
				team.setWorkinfo(rs.getString(4));
				team.setInfomation(rs.getString(5));
				team.setPic(rs.getString(6));
				team.setSort(rs.getInt(7));
				team.setSex(rs.getInt(8));
			}
			ConnDB.closeConn(rs, ps, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return team;
	}

	public List<Team> findTeam() {
		List<Team> list = null;
		try {
			Connection conn = ConnDB.getConn();
			String sql = " select  temp.*  from (select  team.*  from team  order by sort) temp  where rownum between 1 and 5 ";
			PreparedStatement ps = conn.prepareCall(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				list = new ArrayList<Team>();
				while (rs.next()) {
					Team team = new Team();
					team.setTid(rs.getInt(1));
					team.setTname(rs.getString(2));
					team.setPosition(rs.getString(3));
					team.setWorkinfo(rs.getString(4));
					team.setInfomation(rs.getString(5));
					team.setPic(rs.getString(6));
					team.setSort(rs.getInt(7));
					team.setSex(rs.getInt(8));
					list.add(team);
				}
			}
			ConnDB.closeConn(rs, ps, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	public PageModel findByPage(int nowpage) {
		PageModel pageModel = new PageModel();
		List<Team> list = null;
		try {
			Connection conn = ConnDB.getConn();
			CallableStatement cs = conn
					.prepareCall("{ call  pagesplit(?,?,?,?,?,?,?,?)  }");
			cs.setString(1, "team"); // 表名
			cs.setInt(2, nowpage);// 当前页
			cs.setInt(3, PageModel.pagesize);// 每页条数
			cs.setString(4, "");// where 条件
			cs.setString(5, " sort asc "); // order by 顺序
			cs.registerOutParameter(6, oracle.jdbc.OracleTypes.CURSOR);// 结果集合
			cs.registerOutParameter(7, oracle.jdbc.OracleTypes.NUMBER);// 总条数
			cs.registerOutParameter(8, oracle.jdbc.OracleTypes.NUMBER);// 总页数
			cs.execute();
			ResultSet rs = (ResultSet) cs.getObject(6);
			if (rs != null) {
				list = new ArrayList<Team>();
				while (rs.next()) {
					Team team = new Team();
					team.setTid(rs.getInt(1));
					team.setTname(rs.getString(2));
					team.setPosition(rs.getString(3));
					team.setWorkinfo(rs.getString(4));
					team.setInfomation(rs.getString(5));
					team.setPic(rs.getString(6));
					team.setSort(rs.getInt(7));
					team.setSex(rs.getInt(8));
					list.add(team);
				}
			}
			pageModel.setTotalsize(cs.getLong(7));
			pageModel.setTotalpage(cs.getLong(8));
			pageModel.setList(list);
			pageModel.setNowpage(nowpage);
            pageModel.setPageinfo(getPageinfo(pageModel));
			ConnDB.closeConn(rs, cs, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return pageModel;

	}

	public void update(Team bean) {
		try {
			Connection conn = ConnDB.getConn();
			String sql = "update   team  set     tname=?  ,position=?,workinfo=?,infomation=?,pic=?,sort=?,sex=? where tid=?";
			PreparedStatement ps = conn.prepareCall(sql);
			ps.setString(1, bean.getTname());
			ps.setString(2, bean.getPosition());
			ps.setString(3, bean.getWorkinfo());
			ps.setString(4, bean.getInfomation());
			ps.setString(5, bean.getPic());
			ps.setInt(6, bean.getSort());
			ps.setInt(7, bean.getSex());
			ps.setInt(8, bean.getTid());
			ps.execute();
			ConnDB.closeConn(null, ps, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	
	
	public String getPageinfo(PageModel  pageModel) { //后台分页信息
		StringBuffer  sb=new StringBuffer();
		sb.append("<form  name=formgo   method=get  action=TeamServlet  >");
		sb.append("  <a href=TeamServlet?nowpage=1>首页</a>&nbsp;&nbsp;");
		if(pageModel.getNowpage()==1)
		sb.append("上一页");
		else	
		sb.append("<a href=TeamServlet?nowpage="+(pageModel.getNowpage()-1)+">上一页</a>&nbsp;&nbsp;");
		if(pageModel.getNowpage()==pageModel.getTotalpage())
			sb.append("下一页");
		else
		sb.append("  <a href=TeamServlet?nowpage="+(pageModel.getNowpage()+1)+">下一页</a>&nbsp;&nbsp;");
		sb.append("  <a href=TeamServlet?nowpage="+pageModel.getTotalpage()+">尾页</a>&nbsp;&nbsp;");
		sb.append("总共"+pageModel.getTotalsize()+"条&nbsp;&nbsp;");
		sb.append("总共"+pageModel.getTotalpage()+"页&nbsp;&nbsp;");
		sb.append("跳<input type=text name=nowpage   size=1 value="+pageModel.getNowpage()+"   />   页");
		sb.append("<input type=image  src=images/go.bmp  />");
		sb.append("</form>	");
		return sb.toString();
	}

}
