package com.gzc.dao;

import java.util.List;

import com.gzc.bean.NewsType;

public interface NewsTypeDao {

	void add(NewsType bean);

	void update(NewsType bean);

	void delete(int tid);

	List<NewsType> findAll();

	NewsType findById(int tid);

}