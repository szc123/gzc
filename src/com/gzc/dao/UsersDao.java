package com.gzc.dao;

import java.util.List;

import com.gzc.bean.Users;

public interface UsersDao {
	public void add(Users bean);

	public void delete(int id);

	public void update(Users bean);

	public Users findById(int id);

	public List findAll();
	
	public Users findByUnameAndUpwd(String uname,String upwd);
	

}
