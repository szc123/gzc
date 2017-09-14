package com.gzc.util;

import java.util.List;

public class PageModel { //工具类
	private long totalsize;//总条数
	private long totalpage;//总页数
	private List list; //查询结果集
	private long  nowpage ;//当前页
	private String pageinfo=""; //分页信息
	
	
	
	public  static int  pagesize=12 ;//每页条数
	private String preinfo="";
	public String getPreinfo() {  //前台分页信息
		StringBuffer  sb=new StringBuffer();
		   for (int i = 1; i <=totalpage; i++) {
			   sb.append("<li "+(i==nowpage?"class=now":"")+"   ><a href=listTeam.jsp?nowpage="+i+"        >  "+i+"   </a></li>");
			}
		return sb.toString();
	}

	public void setPreinfo(String preinfo) {
		this.preinfo = preinfo;
	}

	
	
	
	
	
	
	public String getPageinfo() { //后台分页信息
		
		
			return  pageinfo;
			
			
	}

	public void setPageinfo(String pageinfo) {
		this.pageinfo = pageinfo;
	}

	public static long getPagesize() {
		return pagesize;
	}

	public static void setPagesize(int pagesize) {
		PageModel.pagesize = pagesize;
	}

	public long getNowpage() {
		return nowpage;
	}

	public void setNowpage(long nowpage) {
		this.nowpage = nowpage;
	}

	public PageModel() {
	
	}
	
	public PageModel(long totalsize, long totalpage, List list) {
		super();
		this.totalsize = totalsize;
		this.totalpage = totalpage;
		this.list = list;
	}

	public long getTotalsize() {
		return totalsize;
	}

	public void setTotalsize(long totalsize) {
		this.totalsize = totalsize;
	}

	public long getTotalpage() {
		return totalpage;
	}

	public void setTotalpage(long totalpage) {
		this.totalpage = totalpage;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

}
