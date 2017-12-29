package com.book.dto;

import java.util.List;

public class Page {
	private List records;
	private int pagenum;
	private int pagesize=3;
	private int totalrecords;
	private int totalpage;
	private int startindex;
	
	private String url;
	
	public Page(int pagenum,int totalrecords , int pagesize){
		this.pagesize = pagesize;
		this.pagenum = pagenum;
		this.totalrecords = totalrecords;

		totalpage = totalrecords%pagesize==0?totalrecords/pagesize:(totalrecords/pagesize+1);

		startindex = (pagenum-1)*pagesize;
	}
	public List getRecords() {
		return records;
	}
	public Page setRecords(List records) {
		this.records = records;
		return this;
	}
	public int getPagenum() {
		return pagenum;
	}
	public void setPagenum(int pagenum) {
		this.pagenum = pagenum;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public int getTotalrecords() {
		return totalrecords;
	}
	public void setTotalrecords(int totalrecords) {
		this.totalrecords = totalrecords;
	}
	public int getTotalpage() {
		return totalpage;
	}
	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}
	public int getStartindex() {
		return startindex;
	}
	public void setStartindex(int startindex) {
		this.startindex = startindex;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
