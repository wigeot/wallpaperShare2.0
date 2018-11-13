<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">	
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.min.css" type="text/css" /><!-- 引入Bootstrap核心样式文件 -->	
	<script src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js" type="text/javascript"></script><!-- 引入jQuery核心js文件 -->
	<script src="${pageContext.request.contextPath }/js/bootstrap.min.js" type="text/javascript"></script><!-- 引入BootStrap核心js文件 -->
	<script src="${pageContext.request.contextPath }/js/index/jquery-ui.min.js" type="text/javascript" ></script><!--引入jQuery-UI脚本-->
<title>Insert title here</title>
	<!--这个插件是瀑布流主插件函数必须-->
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/index/jquery.masonry.min.js"></script>
	<!--这个插件只是为了扩展jquery的animate函数动态效果可有可无-->
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/index/jQeasing.js"></script>
	<!-- 瀑布流的主要设置 -->
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/index/waterfallFlow.js"></script>
	<!-- 瀑布流图片的css -->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/index/base.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/index/index.css">
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/personalSpace.js"></script>
</head>
<body style="padding-top: 170px;background-color:white;">
<!-- 导航条（置顶） -->
<%@ include file="navigationBar.jsp" %>
	
<!-- 个人信息 -->
<div class="container" style="width:50%;">
	<div class="row">
		<div class="col-md-4">
			<img src="${pageContext.request.contextPath }/img/index/01.jpg" alt="头像" class="img-circle" style="width:200px;height:200px;">
		</div>
		<div class="col-md-8">
			<div>
				<h2>${user.login_userName }</h2>
				<p style="line-height: 2.429">个人介绍：这个人很懒什么都得没留下</p>
				<p>性别：${user.login_sex }</p>
				<div>
					标签：<button type="button" class="btn btn-info">风景</button>
					<button type="button" class="btn btn-info">星空</button>
					<button type="button" class="btn btn-info">群山</button>
				</div>
			</div>
		</div>
	</div>
</div>


<!-- 上传图片 -->
<div class="container" style="margin-top:5%;width:70%;">
<form action="${pageContext.request.contextPath }/uploadImg" method="post" enctype="multipart/form-data">
	 <!-- 选择图片按钮-->	
	 <div class="row">
	  <div class="col-md-2">
			<div class="form-group" id="caseIma">
			<label class="btn btn-primary">选择图片
				<input type="file" style="display: none" class="form-control" id="Image" name="Image" onchange="viewImage(this)"/>
			</label>
			</div>
	  </div>
	  <div class="col-md-2">
	  		<button type="submit" class="btn btn-primary">上传</button>
	  </div>
	 </div>
	 <!-- 图片显示区域 -->
	<div style="width:280px;height:280px;margin:10px;border:solid 1px;">
		<img id="preview" width=-1 height=-1 style="diplay:none;width:250px;height:250px;margin:8px;" />
	</div>
</form>
</div>



<!-- 辅助行 -->
<div class="container" style="margin-top:5%;width:70%;">
 <!-- 左边：热门、最新 -->	
 <div class="row">
  <div class="col-md-2">
  		<h4 style="float:left;padding-right: 15px;">上传的</h4>
  		<h4 style="float:left;"><a href="#">我的收藏</a></h4>
  </div>
  <!-- 右边：两个图标 -->
  <div class="col-md-2 col-md-offset-8" style="padding-left: 8%;position:relative;left:2%;">
  		<button type="button" class="btn btn-default" aria-label="Left Align" style="border: 0px solid transparent;font-size: 20px;">
		  <span class="glyphicon glyphicon-th-large" aria-hidden="true"></span>
		</button>
		<button type="button" class="btn btn-default" aria-label="Left Align"  style="border: 0px solid transparent;font-size: 20px;">
		  <span class="glyphicon glyphicon-menu-hamburger" aria-hidden="true"></span>
		</button>
  </div>
 </div>
</div>


<!-- 主要内容 -->
<div class="container" style="width:72%;">
	<!-- 瀑布流样式开始 -->
	<div class="waterfull clearfloat" id="waterfull">
		<ul> 
			
		</ul>
	</div>
</div>

<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<!-- 底部 -->
<div style="width:100%;height:100px;background:black;text-align:center;color:white;padding-top:25px;">
	<h3>谢谢访问！</h3>
</div>


</body>
</html>