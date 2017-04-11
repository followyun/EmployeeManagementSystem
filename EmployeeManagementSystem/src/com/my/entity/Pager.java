package com.my.entity;

import java.util.List;

/**
 * ������ʾһҳ��Ϣ��ʵ��
 * @author yun
 *
 */
public class Pager<T> {
	private Integer totalPage;
	private Integer currentPage;
	private Integer pageSize;
	private Integer totalCount;
	private List<T> list;
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}	
	
	
}
