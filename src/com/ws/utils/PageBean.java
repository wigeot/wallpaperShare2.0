package com.ws.utils;

import java.util.List;
/**
 * 
 * ��ҳ������
 *
 */
public class PageBean {
	//��ǰҳ��
	private Integer currentPage;
	//�ܼ�¼��
	private Integer totalCount;
	//ÿҳ��ʾ����
	private Integer pageSize;
	//��ҳ��
	private Integer totalPage;
	//��ҳ�б�����
	private List	list;
	
	//���췽��
	public PageBean(Integer currentPage, Integer totalCount, Integer pageSize) {
		this.totalCount = totalCount;
		
		this.pageSize =  pageSize;
		
		this.currentPage = currentPage;
		
		if(this.currentPage == null){
			//��ҳ��û��ָ����ʾ��һҳ.��ʾ��һҳ.
			this.currentPage = 1;
		}
		
		if(this.pageSize == null){
			//���ÿҳ��ʾ����û��ָ��,Ĭ��ÿҳ��ʾ3��
			this.pageSize = 3;
		}
		
		//������ҳ��
		this.totalPage = (this.totalCount+this.pageSize-1)/this.pageSize;
		
		//�жϵ�ǰҳ���Ƿ񳬳���Χ
		//����С��1
		if(this.currentPage < 1){
			this.currentPage = 1;
		}
		//���ܴ�����ҳ��
		if(this.currentPage > this.totalPage){
			this.currentPage = this.totalPage;
		}
		
	}
	//������ʼ����
	public int getStart(){
		return (this.currentPage-1)*this.pageSize;
	}
	
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	
	
	
	
}
