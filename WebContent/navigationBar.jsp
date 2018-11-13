<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!-- 头部：导航条(置顶) -->
<div>
	<nav class="navbar navbar-default navbar-fixed-top" Style="height:70px; padding-top:10px;  background-color:rgba(255,255,255);"><!-- 使页面一直固定在顶部 -->
	  	<div class="container-fluid">
	   	 	<!-- 品牌图标 -->
	    	<div class="navbar-header">
		      <a class="navbar-brand" href="#" style="padding-top: 10px;">
		        <img alt="Brand" src="${pageContext.request.contextPath }/img/index.ico" style="height:38px;">
		      </a>
	    	</div>
	    	<!-- 主页 、所有图片、搜索 -->
		    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		      <ul class="nav navbar-nav">
		      <!-- 这里的判断主要是针对，如果现在是当前页面，就会有一个css样式显示-->
		      	<%
				if(request.getRequestURI().equals(request.getContextPath()+"/index.jsp")){
					%><li class="active"><a href="${pageContext.request.contextPath }/imageAction_list2?pageSize=3">主页</a></li><%
				}
				%>
		      	<%
				if(!request.getRequestURI().equals(request.getContextPath()+"/index.jsp")){
					%><li><a href="${pageContext.request.contextPath }/imageAction_list2?pageSize=3">主页</a></li><%
				}
				%>
				
		      	<%
				if(request.getRequestURI().equals(request.getContextPath()+"/AllImg.jsp")){
					%><li class="active"><a href="${pageContext.request.contextPath }/imageAction_list?pageSize=12">所有图片</a></li><%
				}
				%>
		      	<%
				if(!request.getRequestURI().equals(request.getContextPath()+"/AllImg.jsp")){
					%><li><a href="${pageContext.request.contextPath }/imageAction_list?pageSize=12">所有图片</a></li><%
				}
				%>
		      </ul>
		      <!-- 搜索 -->
		      

	<!-- 完成异步搜索//不能同时运行两个不同的ajax，问题暂未解决 -->
<!-- 	<script type="text/javascript">
	
		function overFn(obj){//鼠标在上面
			$(obj).css("background","#F0F8FF");
		}
		function outFn(obj){//鼠标离开
			$(obj).css("background","white");
		}
		function clickFn(obj){//鼠标点击
			$("#search").val($(obj).html());
			$("#showDiv").css("display","none");
		}
		
		function searchWord(obj){
			//1、获得输入框的输入的内容
			var word = $(obj).val();
			//2、根据输入框的内容去数据库中模糊查询---List<Product>
			var content = "";
			$.post(
				"${pageContext.request.contextPath}/searchWord",
				{"word":word},
				function(data){
					//3、将返回的商品的名称 现在showDiv中
					if(data.length>0){
						for(var i=0;i<data.length;i++){
							content+="<div style='padding:5px;cursor:pointer' onclick='clickFn(this)' onmouseover='overFn(this)' onmouseout='outFn(this)'>"+data[i]+"</div>";
						}
						$("#showDiv").html(content);
						$("#showDiv").css("display","block");
					}
					if(obj.value.length==0){//判断输入框是否为空，如果为空则隐藏提示区域
						$("#showDiv").css("display","none");
					}
				},
				"json"
			);
			
		}
	</script> -->
	
		    <form class="input-group input-group-lg  header_1" style="display:none;width:60%;position:relative;">
			      <input type="text" class="form-control"  placeholder="请输入图片类型" style="font-size: 16px;margin-left: 6%;"  autocomplete="off" onkeyup="searchWord(this)" id="search">
			      <span class="input-group-btn" >
			        <button class="btn btn-default" type="button" style="font-size: 16px;">搜索</button>
			      </span>
		    </form>
			<div id="showDiv" style="display:none; position:absolute;z-index:1000;top:146px;background:white; width:188px;font-size: 16px;color:black;border:1px solid #ccc;">
				<%//这里用于显示动态提示的数据 %>
			</div>
		    </div>
		    <!-- 导航栏：右边 -->
		    <div style="margin-top: -50px;">
		      <ul class="nav navbar-nav navbar-right" >
		      
      			<c:if test="${empty sys_User }"><!-- 相当于  if(user != null ){ -->
			      	<%
					if(request.getRequestURI().equals(request.getContextPath()+"/Login/login.jsp")){
						%><li class="active"><a href="${pageContext.request.contextPath }/Login/login.jsp">登录</a></li><%
					}
					%>
			      	<%
					if(!request.getRequestURI().equals(request.getContextPath()+"/Login/login.jsp")){
						%><li><a href="${pageContext.request.contextPath }/Login/login.jsp">登录</a></li><%
					}
					%>
					
			      	<%
					if(request.getRequestURI().equals(request.getContextPath()+"/Login/register.jsp")){	
						%><li class="active"><a href="${pageContext.request.contextPath }/Login/register.jsp">注册</a></li><%
					}
					%>
			      	<%
					if(!request.getRequestURI().equals(request.getContextPath()+"/Login/register.jsp")){
						%><li><a href="${pageContext.request.contextPath }/Login/register.jsp">注册</a></li><%
					}
					%>
					
				</c:if>
				<c:if test="${!empty sys_User }">
					<li><a>欢迎您 - ${sys_User.user_userName }</a></li>	
					
			      	<%
					if(request.getRequestURI().equals(request.getContextPath()+"/personalSpace.jsp")){
						%><li class="active"><a href="${pageContext.request.contextPath }/personalSpace.jsp">个人中心</a></li><%
					}
					%>
					
			      	<%
					if(!request.getRequestURI().equals(request.getContextPath()+"/personalSpace.jsp")){
						%><li><a href="${pageContext.request.contextPath }/personalSpace.jsp">个人中心</a></li><%
					}
					%>
					<li><a href="${pageContext.request.contextPath }/userAction_userExit">退出</a></li>
				</c:if>
		        <!-- 二维码 -->
		        <li class="dropdown" style="margin-top: 6px;margin-right: 20px;">
				  		<button  data-toggle="dropdown"  class="btn btn-default"  style="border: 0px solid transparent;font-size: 20px;">
						  <span class="glyphicon glyphicon-qrcode" aria-hidden="true"></span>
						</button>
		          <ul class="dropdown-menu" >
		            <li><a href="#"><img src="${pageContext.request.contextPath }/img/QR_Code.jpg" style="width:200px;"></a></li>
		            <li role="separator" class="divider"></li>
		            <li style="text-align:center;">扫描二维码，添加微信！</li>
		          </ul>
		        </li>
		      </ul>
		    </div>
	 	</div><!-- /.container-fluid -->
	</nav>
</div>