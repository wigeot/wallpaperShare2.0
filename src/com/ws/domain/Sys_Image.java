package com.ws.domain;

import java.util.Date;
/**
 * 系统图片表
 * 

CREATE TABLE `sys_image` (
  `img_id` int(255) NOT NULL AUTO_INCREMENT,
  `img_src` varchar(255) DEFAULT NULL COMMENT '图片的储存地址',
  `img_date` date DEFAULT NULL COMMENT '图片的上传日期',
  `img_name` varchar(255) DEFAULT NULL COMMENT '图片的文件名',
  `img_resolution` varchar(255) DEFAULT NULL COMMENT '图片的分辨率',
  `img_size` varchar(255) DEFAULT NULL COMMENT '图片的文件大小',
  `login_userName` varchar(255) DEFAULT NULL COMMENT '上传者（用户名）',
  `img_sort` varchar(255) DEFAULT NULL COMMENT '图片的分类',
  PRIMARY KEY (`img_id`)
) 
 *
 */
public class Sys_Image {
	private Integer img_id;//主键
	private String img_Src;//图片的储存地址
	private Date img_Date;//图片的上传日期
	private String img_name;//图片的文件名
	private String img_Resolution;//图片的分辨率
	private String img_Size;//图片的文件大小
	private String img_sort;//图片的分类
	
	private Sys_User img_user_userName;//上传者(另一个表的列)
	
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
