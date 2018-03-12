package com.huyaoban.mybatis3.paging;

import java.util.List;

public class Page {
	/**
	 * 当前页
	 */
	private int pageNum;

	/**
	 * 每页数量
	 */
	private int pageSize;

	/**
	 * 总记录数
	 */
	private long resultCount;

	/**
	 * 总页数
	 */
	private int pageCount;

	private List data;

	public Page(int pageNum, int pageSize) {
		this.pageNum = pageNum;
		this.pageSize = pageSize;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public long getResultCount() {
		return resultCount;
	}

	public void setResultCount(long resultCount) {
		this.resultCount = resultCount;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public List getData() {
		return data;
	}

	public void setData(List data) {
		this.data = data;
	}

}
