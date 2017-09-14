package com.gzc.dao;

import com.gzc.bean.News;
import com.gzc.util.PageModel;

public interface NewsDao {
	public void add(News bean);

	public void delete(int nid);

	public void update(News bean);

	public News findById(int nid);

	public PageModel findByPage(int nowPage,int tid);
	
	
	

}
