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
	
	//��ǰҳ��(1)Ĭ�ϴ���1
	private Integer currentPage;
	//ÿҳ��ʾ����(4)Ĭ�ϴ���4 
	private Integer pageSize;
	
	
	
	//��ʾ����ͼƬ
	public String list() throws Exception {
		//��װ���߲�ѯ����
		DetachedCriteria dc = DetachedCriteria.forClass(Sys_Image.class);
		/*//�жϣ��Ƿ�Ϊ�գ�����װ����
		if(StringUtils.isNotBlank(sys_Image.getImg_id())){
			dc.add(Restrictions.like("img_sort", "%"+sys_Image.getImg_sort()+"%"));//��ѯ����ķ��ࣨImg_sort��
		}*/
		
		//1 ����Service��ѯ��ҳ����(PageBean)
		PageBean pb = imageService.getPageBean(dc,currentPage,pageSize);
		
		//2 ��PageBean����request��,ת�����б�ҳ����ʾ
		ActionContext.getContext().put("pageBean", pb);
		
		//3��ת������ҳ
		return "list";
	}
	
	//��ʾ����ͼƬ2����ʱ��������һ���ģ�
	public String list2() throws Exception {
		//��װ���߲�ѯ����
		DetachedCriteria dc = DetachedCriteria.forClass(Sys_Image.class);
		/*//�жϣ��Ƿ�Ϊ�գ�����װ����
		if(StringUtils.isNotBlank(sys_Image.getImg_id())){
			dc.add(Restrictions.like("img_sort", "%"+sys_Image.getImg_sort()+"%"));//��ѯ����ķ��ࣨImg_sort��
		}*/
		
		//1 ����Service��ѯ��ҳ����(PageBean)
		PageBean pb = imageService.getPageBean(dc,currentPage,pageSize);
		
		//2 ��PageBean����request��,ת�����б�ҳ����ʾ
		ActionContext.getContext().put("pageBean", pb);
		
		
		//3��ת������ҳ
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
