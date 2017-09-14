package com.gzc.dao;

import com.gzc.bean.Team;
import com.gzc.util.PageModel;

public interface TeamDao {
	public void add(Team bean);

	public void delete(int id);

	public void update(Team bean);

	public Team findById(int id);

	public PageModel findByPage(int nowPage);
	
	
	

}
