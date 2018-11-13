<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" import="java.io.*" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">	
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.min.css" type="text/css" /><!-- 引入Bootstrap核心样式文件 -->	
	<script src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js" type="text/javascript"></script><!-- 引入jQuery核心js文件 -->
	<script src="${pageContext.request.contextPath }/js/bootstrap.min.js" type="text/javascript"></script><!-- 引入BootStrap核心js文件 -->
	<script src="${pageContext.request.contextPath }/js/login/login_CustomCheck.js" type="text/javascript"></script><!-- 自定义的验证（validate） -->
	<script src="${pageContext.request.contextPath }/js/login/jquery.validate.min.js" type="text/javascript" ></script><!--引入validate插件js文件-->
	<script src="${pageContext.request.contextPath }/js/login/messages_zh.js" type="text/javascript"></script><!--引入国际化js文件-->

	<link rel="icon" href="/img/index.ico" type="image/x-icon"/	>  <!-- 网站小图标 -->

	<title>壁纸分享-登录账号</title>
</head>

<script type="text/javascript">


	/*
	自定义校验规则，用于判断用户名是否存在(放到外联文件中没作用，原因不明？)
	*/
	$.validator.addMethod(
		//规则的名称
		"check_login_userName",
		//校验的函数
		function(value,element,params){
			return true;//直接返回true，这里我们不验证用户名是否存在，但是不写这个提示没作用（愿意不明？）
		}
	);

	/*
		自定义校验规则，用于判断验证码是否正确
	*/
/* 	$.validator.addMethod(
		//规则的名称
		"check_checkCode",
		//校验的函数
		function(value,element,params){
			var flag = false;
			$.ajax({
				"async":false,//是否异步（false为不异步）（如果异步的话，这里运行不到就会有返回值出去）
				"url":"${pageContext.request.contextPath}/checkCheckCode",//需要访问的地址
				"data":{"checkCode":value},//发送的数据（发送给服务器）（这个值是我们所写的用户名）
				"type":"POST",//提交方式
				"dataType":"json",//指定返回的数据类型
				"success":function(data){//成功会运行这个函数（回调函数）
					flag = data.isEqual;
				}
			});
			//返回false代表该校验器不通过
			return flag;
		}
		
	); */
	
</script>
<style>
label.error{
	background:url(/wallpaperShare/img/login/error.gif) no-repeat 10px 3px;
	padding-left: 30px;
	font-family:georgia;
	font-size: 15px;
	font-style: normal;
	color: red;
}
</style>
<body>
<!-- 导航条（置顶） -->
<%@ include file="../navigationBar.jsp" %>
<div class="container-fluid">
	<div class="row">
		<!-- 左边 -->
  		<div class="col-xs-4 col-md-4" style="background-image:url(${pageContext.request.contextPath }/img/login/img-0<%=((int)(Math.random()*8)+1) %>.jpg); background-size:100%; height:100%;">
	          	<img style="width:30px; height:30px; margin:80px;" src="https://unsplash.com/assets/core/logo-white-d6de700c647597b70cb24484a22ea0e43a4a28c563144e4a49c38f291fc2eb61.svg" alt="Logo white" />
				<div style="margin-top: 20%;margin-left: 20%;color:white;">
					<h1 class="">加入我们&nbsp;&nbsp;&nbsp;&nbsp;:)</h1>	
					<h3 class="">&nbsp;&nbsp;&nbsp;&nbsp;我们这里有别的地方都没有的美丽照片 </h3>
				</div>
				<div style="margin-top:60%; margin-left:10%; color:white;">
				</div>
	     </div>	
		<!-- 右边 -->
  		<div class="col-xs-8 col-md-8"  style="margin-top:180px; " >	
  			<!-- 前端应该判断是否为空，否则阻止提交表单 -->			
			<form class="form-horizontal" id="CheckForm" method="post" action="${pageContext.request.contextPath }/userAction_login">
			<!-- 0.标题 -->
			<div class="form-group">
				<h3 class="col-sm-5 control-label">登录账号 </h3>
			</div>
			<!-- 1.账号 -->
			<div class="form-group">
			  <label for="inputUsername1" class="col-sm-2 control-label">用户名</label>
			  <div class="col-xs-4">
			    <input type="text" class="form-control" id="inputUsername1" maxlength="12" placeholder="请输入您的用户名" name="user_userName" onkeyup="this.value=this.value.replace(/\s+/g,'')" value="<%=request.getAttribute("login_userName")==null?"":request.getAttribute("login_userName") %>">
			  </div>
			</div>
			<!-- 2.密码 -->
			<div class="form-group">
			  <label for="inputPassword1" class="col-sm-2 control-label">密码</label>
			  <div class="col-xs-4">
			    <input type="password" class="form-control" id="inputPassword1" maxlength="15" placeholder="请输入密码" name="user_password" onkeyup="this.value=this.value.replace(/\s+/g,'')">
			  </div>
			</div>
			<!-- 3.验证码 -->
			<div class="form-group">
				<label for="inputPassword3" class="col-sm-2 control-label">验证码</label>
				<div class="col-sm-2">
					<input type="text" class="form-control" id="inputCode1" maxlength="4" placeholder="请输入验证码" name="checkcode" onkeyup="this.value=this.value.replace(/\s+/g,'')">
				</div>
				<div class="col-sm-3">
					<img src="${pageContext.request.contextPath }/checkImg" alt="点击刷新"  onclick="this.src='${pageContext.request.contextPath }/checkImg?s='+new Date().getTime()" /><!-- ${pageContext.request.contextPath } 等同于 /wallpaperShare -->
					<div style="color:red;"><s:actionerror/></div>
				</div>
			</div>
			<!-- 4.记住密码 -->
			<div class="form-group">
			  <div class="col-sm-offset-2 col-sm-10">
			    <div class="checkbox">
			      <label>
			        <input type="checkbox" name="autoLogin">记住密码
			      </label>
				  <span style="color:red;font-size:15px;margin-left:80px;">
				      <!-- 错误提示 -->
					  <s:property value="exception.message" />
					  <%-- <s:debug></s:debug> --%>
			      </span>
				  
			    </div>
			  </div>
			</div>
			  
			
			<!-- 5.提交 -->
			<div class="form-group">
			  <div class="col-sm-offset-2 col-sm-10">
			    <input type="submit" class="btn btn-default" value="登录" />
			    <button type="reset" class="btn btn-default" >清空</button>
			  </div>
			</div>
			</form>
			
		</div>
	</div>
	
</div>
</body>
</html>