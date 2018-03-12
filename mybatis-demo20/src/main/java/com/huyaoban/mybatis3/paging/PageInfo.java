package com.huyaoban.mybatis3.paging;

/**
 * 这个分页对象里面没有总页数和总记录数，且没有数据对象
 * 
 * @author Administrator
 *
 */
public class PageInfo {
	private int currentPage;
	private int pageSize;

	public PageInfo(int currentPage, int pageSize) {
		this.currentPage = currentPage;
		this.pageSize = pageSize;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}
