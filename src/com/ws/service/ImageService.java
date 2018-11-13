package com.ws.service;

import org.hibernate.criterion.DetachedCriteria;

import com.ws.utils.PageBean;

public interface ImageService {
	//·ÖÒ³·½·¨
	PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);

}
