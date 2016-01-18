package com.wantai.oa.biz.shared.request;

import com.wantai.oa.biz.shared.result.Status;

/**
 * 分页对象
 * @author Sharpe on 2016-01-16.
 */
public class PageRequest extends Status {

	/**
	 * 页码，从1开始
	 */
	private int pageNum = 1;
	/**
	 * 页面大小
	 */
	private int pageSize;
	/**
	 * 起始行
	 */
	private int startRow;
	/**
	 * 末行
	 */
	private int endRow;
	/**
	 * 总数
	 */
	private long total;
	/**
	 * 总页数
	 */
	private int pages;

    public PageRequest(int pageNum, int pageSize) {
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

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getEndRow() {
		return endRow;
	}

	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}
}
