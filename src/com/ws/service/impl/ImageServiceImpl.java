package com.ws.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.ws.dao.ImageDao;
import com.ws.domain.Sys_Image;
import com.ws.service.ImageService;
import com.ws.utils.PageBean;

public class ImageServiceImpl implements ImageService{
	
	private ImageDao imageDao;
	
	//��ҳ����
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		//1 ����Dao��ѯ�ܼ�¼��
		Integer totalCount = imageDao.getTotalCount(dc);
		//2 ����PageBean����		   ���ܼ�¼������ʼ������ÿҳ��ʾ������
		PageBean pb = new PageBean(currentPage, totalCount, pageSize);//ע�����ÿҳ��ʾ����(���12����˼�ǣ�ÿҳ��ʾ12��ͼƬ)
		//3 ����Dao��ѯ��ҳ�б�����					     ����ѯ�������ɿգ�����ʼ������ÿҳ��ʾ������
		List<Sys_Image> list = imageDao.getPageList(dc,pb.getStart(),pb.getPageSize());
		//4 �б����ݷ���pageBean��.������
		pb.setList(list);
		return pb;
	}

	
	public void setImageDao(ImageDao imageDao) {
		this.imageDao = imageDao;
	}

	
}
