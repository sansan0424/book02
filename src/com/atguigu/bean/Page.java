package com.atguigu.bean;

import java.util.List;

/**
 * 分页
 */
public class Page<T> {

	/**
	 * 当前页数 
	 * 前端传入
	 */
	private int pageNo = 1;
	
	/**
	 * 总页码 
	 * 根据totalCount，pageSize计算
	 */
	private int totalPage;
	
	/**
	 * 总记录数
	 * 查询得到
	 */
	private int totalCount;
	
	/**
	 * 每页条数
	 * 前端传入
	 */
	private int pageSize = 4;
	
	/**
	 * 查询开始索引
	 * 根据pageNo，pageSize计算
	 */
	private int index;
	
	/**
	 * 是否有下一页
	 */
	private boolean hasNext;
	
	/**
	 * 是否有上一页
	 */
	private boolean hasPrev;

	/**
	 * 分页实际查询出来的数据
	 */
	private List<T> pageData;
	
	/**
	 * 请求的url
	 */
	private String url;

	public Page() {
		super();
	}

	public Page(int pageNo, int pageSize) {
		super();
		// 设置默认值
		this.pageNo = pageNo<=0? 1: pageNo;
		this.pageSize = pageSize==0? 4 : pageSize;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo<=0? 1: pageNo;
	}

	public int getTotalPage() {
		// 根据pageSize，totalCount计算
		// 看总条数能不能被页码整除
		if ((totalCount % pageSize) == 0) {
			totalPage = totalCount/pageSize;
		}else {
			totalPage = totalCount/pageSize + 1;
		}
		return totalPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getIndex() {
		// 根据pageNo，pageSize计算
		// 检查传入的页数pageNo是否超过总页数
		if (pageNo > getTotalPage()) {
			pageNo = getTotalPage();
		}
		index = (pageNo-1)*pageSize;
		return index;
	}

	public boolean isHasNext() {
		// 根据pageNo，totalPage计算
		hasNext = pageNo < totalPage;
		return hasNext;
	}

	public boolean isHasPrev() {
		// 根据pageNo计算
		hasPrev = pageNo > 1;
		return hasPrev;
	}

	public List<T> getPageData() {
		return pageData;
	}

	public void setPageData(List<T> pageData) {
		this.pageData = pageData;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}
