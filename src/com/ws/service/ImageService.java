package com.ws.service;

import org.hibernate.criterion.DetachedCriteria;

import com.ws.utils.PageBean;

public interface ImageService {
	//��ҳ����
	PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);

}
