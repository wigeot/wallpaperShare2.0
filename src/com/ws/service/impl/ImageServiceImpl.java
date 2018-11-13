package com.ws.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.ws.dao.ImageDao;
import com.ws.domain.Sys_Image;
import com.ws.service.ImageService;
import com.ws.utils.PageBean;

public class ImageServiceImpl implements ImageService{
	
	private ImageDao imageDao;
	
	//分页方法
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		//1 调用Dao查询总记录数
		Integer totalCount = imageDao.getTotalCount(dc);
		//2 创建PageBean对象		   （总记录数，起始索引，每页显示条数）
		PageBean pb = new PageBean(currentPage, totalCount, pageSize);//注：这个每页显示所有(这个12的意思是，每页显示12张图片)
		//3 调用Dao查询分页列表数据					     （查询条件（可空），起始索引，每页显示条数）
		List<Sys_Image> list = imageDao.getPageList(dc,pb.getStart(),pb.getPageSize());
		//4 列表数据放入pageBean中.并返回
		pb.setList(list);
		return pb;
	}

	
	public void setImageDao(ImageDao imageDao) {
		this.imageDao = imageDao;
	}

	
}
