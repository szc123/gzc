package com.gzc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gzc.bean.NewsType;
import com.gzc.dao.NewsTypeDao;
import com.gzc.db.ConnDB;

public class NewsTypeDaoImpl implements NewsTypeDao {

	
	public void add(NewsType bean) {
		try {
			Connection conn = ConnDB.getConn();
			String sql = "insert into newsType values(newsType_seq.nextval ,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, bean.getTname());
			ps.setString(2, bean.getFlag());
			ps.execute();
			ConnDB.closeConn(null, ps, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	
	public void update(NewsType bean) {
		try {
			Connection conn = ConnDB.getConn();
			String sql = "update newsType set tname='" + bean.getTname()+ "', flag='"+bean.getFlag()+"'   where tid="+bean.getTid();
			Statement stmt = conn.createStatement();
			stmt.execute(sql);
			ConnDB.closeConn(null, stmt, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	public void delete(int tid) {
	
		try {
			Connection conn = ConnDB.getConn();
			String sql = "delete from newsType where tid=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, tid);
			ps.execute();
			ConnDB.closeConn(null, ps, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	
	public List<NewsType> findAll() {
		List <NewsType>list=null;
		try {
			Connection conn = ConnDB.getConn();
			String sql = "select * from newsType";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			if(rs!=null){
				list=new ArrayList<NewsType>();
				while(rs.next()){
					NewsType bean=new NewsType();
					bean.setTid(rs.getInt(1));
					bean.setTname(rs.getString("tname"));
					bean.setFlag(rs.getString("flag"));
					list.add(bean);	
				}
			}
			ConnDB.closeConn(rs, ps, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	
	public NewsType findById(int tid) {
		NewsType bean=null;
		try {
			Connection conn = ConnDB.getConn();
			String sql = "select * from newsType where tid=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, tid);
			ResultSet rs=ps.executeQuery();
				if(rs.next()){
					bean=new NewsType();
					bean.setTid(rs.getInt(1));
					bean.setTname(rs.getString(2));
					bean.setFlag(rs.getString(3));
			}
			ConnDB.closeConn(rs, ps, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bean;
	}

	

}
