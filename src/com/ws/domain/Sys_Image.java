package com.ws.domain;

import java.util.Date;
/**
 * ϵͳͼƬ��
 * 

CREATE TABLE `sys_image` (
  `img_id` int(255) NOT NULL AUTO_INCREMENT,
  `img_src` varchar(255) DEFAULT NULL COMMENT 'ͼƬ�Ĵ����ַ',
  `img_date` date DEFAULT NULL COMMENT 'ͼƬ���ϴ�����',
  `img_name` varchar(255) DEFAULT NULL COMMENT 'ͼƬ���ļ���',
  `img_resolution` varchar(255) DEFAULT NULL COMMENT 'ͼƬ�ķֱ���',
  `img_size` varchar(255) DEFAULT NULL COMMENT 'ͼƬ���ļ���С',
  `login_userName` varchar(255) DEFAULT NULL COMMENT '�ϴ��ߣ��û�����',
  `img_sort` varchar(255) DEFAULT NULL COMMENT 'ͼƬ�ķ���',
  PRIMARY KEY (`img_id`)
) 
 *
 */
public class Sys_Image {
	private Integer img_id;//����
	private String img_Src;//ͼƬ�Ĵ����ַ
	private Date img_Date;//ͼƬ���ϴ�����
	private String img_name;//ͼƬ���ļ���
	private String img_Resolution;//ͼƬ�ķֱ���
	private String img_Size;//ͼƬ���ļ���С
	private String img_sort;//ͼƬ�ķ���
	
	private Sys_User img_user_userName;//�ϴ���(��һ�������)
	
	public Integer getImg_id() {
		return img_id;
	}
	public void setImg_id(Integer img_id) {
		this.img_id = img_id;
	}
	public String getImg_Src() {
		return img_Src;
	}
	public void setImg_Src(String img_Src) {
		this.img_Src = img_Src;
	}
	public Date getImg_Date() {
		return img_Date;
	}
	public void setImg_Date(Date img_Date) {
		this.img_Date = img_Date;
	}
	public String getImg_name() {
		return img_name;
	}
	public void setImg_name(String img_name) {
		this.img_name = img_name;
	}
	public String getImg_Resolution() {
		return img_Resolution;
	}
	public void setImg_Resolution(String img_Resolution) {
		this.img_Resolution = img_Resolution;
	}
	public String getImg_Size() {
		return img_Size;
	}
	public void setImg_Size(String img_Size) {
		this.img_Size = img_Size;
	}
	public String getImg_sort() {
		return img_sort;
	}
	public void setImg_sort(String img_sort) {
		this.img_sort = img_sort;
	}
	public Sys_User getImg_user_userName() {
		return img_user_userName;
	}
	public void setImg_user_userName(Sys_User img_user_userName) {
		this.img_user_userName = img_user_userName;
	}
	
	
	
}
