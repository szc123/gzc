package com.gzc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gzc.bean.Users;
import com.gzc.dao.UsersDao;
import com.gzc.db.ConnDB;

public class UsersDaoImpl implements UsersDao {

	public void add(Users bean) {
		try {
			Connection conn = ConnDB.getConn();
			String sql = "insert into users values(users_seq.nextval ,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, bean.getUname());
			ps.setString(2, bean.getUpwd());
			ps.execute();
			ConnDB.closeConn(null, ps, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void update(Users bean) {
		try {
			Connection conn = ConnDB.getConn();
			String sql = "update users set uname='" + bean.getUname()+ "' ,upwd='" + bean.getUpwd() + "' where id="+bean.getId();
			Statement stmt = conn.createStatement();
			stmt.execute(sql);
			ConnDB.closeConn(null, stmt, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void delete(int id) {
	
		try {
			Connection conn = ConnDB.getConn();
			String sql = "delete from users where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.execute();
			ConnDB.closeConn(null, ps, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public List<Users> findAll() {
		List <Users>list=null;
		try {
			Connection conn = ConnDB.getConn();
			String sql = "select * from users";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			if(rs!=null){
				list=new ArrayList<Users>();
				while(rs.next()){
					Users bean=new Users();
					bean.setId(rs.getInt(1));
					bean.setUname(rs.getString("uname"));
					bean.setUpwd(rs.getString(3));
					list.add(bean);	
				}
			}
			ConnDB.closeConn(rs, ps, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public Users findById(int id) {
		Users bean=null;
		try {
			Connection conn = ConnDB.getConn();
			String sql = "select * from users where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
				if(rs.next()){
					bean=new Users();
					bean.setId(rs.getInt(1));
					bean.setUname(rs.getString(2));
					bean.setUpwd(rs.getString(3));
			}
			ConnDB.closeConn(rs, ps, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bean;
	}

	public Users findByUnameAndUpwd(String uname, String upwd) {
		Users bean=null;
		try {
			Connection conn = ConnDB.getConn();
			String sql = "select * from users where   uname=?  and  upwd=?  ";
			PreparedStatement ps = conn.prepareStatement(sql);
		    ps.setString(1, uname);
		    ps.setString(2, upwd);
			
			ResultSet rs=ps.executeQuery();
				if(rs.next()){
					bean=new Users();
					bean.setId(rs.getInt(1));
					bean.setUname(rs.getString(2));
					bean.setUpwd(rs.getString(3));
			}
			ConnDB.closeConn(rs, ps, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bean;
		
		
	}

}
