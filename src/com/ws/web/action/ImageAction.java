package com.ws.web.action;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.ws.domain.Sys_Image;
import com.ws.service.ImageService;
import com.ws.utils.PageBean;	

public class ImageAction extends ActionSupport implements ModelDriven<Sys_Image> {
	private Sys_Image sys_Image = new Sys_Image();
	
	private ImageService imageService;
	
	//当前页数(1)默认传个1
	private Integer currentPage;
	//每页显示条数(4)默认传个4 
	private Integer pageSize;
	
	
	
	//显示所有图片
	public String list() throws Exception {
		//封装离线查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(Sys_Image.class);
		/*//判断（是否不为空）并封装参数
		if(StringUtils.isNotBlank(sys_Image.getImg_id())){
			dc.add(Restrictions.like("img_sort", "%"+sys_Image.getImg_sort()+"%"));//查询输入的分类（Img_sort）
		}*/
		
		//1 调用Service查询分页数据(PageBean)
		PageBean pb = imageService.getPageBean(dc,currentPage,pageSize);
		
		//2 将PageBean放入request域,转发到列表页面显示
		ActionContext.getContext().put("pageBean", pb);
		
		//3、转发到首页
		return "list";
	}
	
	//显示所有图片2（暂时两个都是一样的）
	public String list2() throws Exception {
		//封装离线查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(Sys_Image.class);
		/*//判断（是否不为空）并封装参数
		if(StringUtils.isNotBlank(sys_Image.getImg_id())){
			dc.add(Restrictions.like("img_sort", "%"+sys_Image.getImg_sort()+"%"));//查询输入的分类（Img_sort）
		}*/
		
		//1 调用Service查询分页数据(PageBean)
		PageBean pb = imageService.getPageBean(dc,currentPage,pageSize);
		
		//2 将PageBean放入request域,转发到列表页面显示
		ActionContext.getContext().put("pageBean", pb);
		
		
		//3、转发到首页
		return "list2";
	}
	
	
	



	public ImageService getImageService() {
		return imageService;
	}


	public void setImageService(ImageService imageService) {
		this.imageService = imageService;
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

	public Sys_Image getModel() {
		return sys_Image;
	}

	
}
