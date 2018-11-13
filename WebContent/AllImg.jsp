<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
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
</head>
<body style="padding-top: 70px;background-color: black;">
<!-- 导航条（置顶） -->
<%@ include file="navigationBar.jsp" %>

<!-- 搜索框 --> 

	<!-- 完成异步搜索//不能同时运行两个不同的ajax，问题暂未解决 -->
	<script type="text/javascript">
	
		function overFn(obj){//鼠标在上面
			$(obj).css("background","#F0F8FF");
		}
		function outFn(obj){//鼠标离开
			$(obj).css("background","white");
		}
		function clickFn(obj){//鼠标点击
			$("#search1").val($(obj).html());
			$("#showDiv1").css("display","none");
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
						$("#showDiv1").html(content);
						$("#showDiv1").css("display","block");
					}
					if(obj.value.length==0){//判断输入框是否为空，如果为空则隐藏提示区域
						$("#showDiv1").css("display","none");
					}
				},
				"json"
			);
			
		}
	</script>
<div class="container-fluid" style="color:white;padding-top:100px;margin-bottom:5%;">
	<div class="row" >
		<div class="col-lg-offset-3 col-lg-6">
			<h1>壁纸分享</h1>
			<p style="">美丽的,免费的照片。世界上最慷慨的摄影师群体。🎁</p>
			<form class="input-group input-group-lg" style="margin-top:10px;position:relative;">
			      <input type="text" class="form-control"  placeholder="请输入图片类型" style="font-size: 16px;" onkeyup="searchWord(this)" id="search1" autocomplete="off">
			      <span class="input-group-btn">
			        <button class="btn btn-default" type="button" style="font-size: 16px;">搜索</button>
			      </span>
		    </form>
			<div id="showDiv1" style="display:none; position:absolute;z-index:1000;top:146px;background:white; width:188px;font-size: 16px;color:black;border:1px solid #ccc;">
				<%//这里用于显示动态提示的数据 %>
			</div>
			<p style="margin: 6px 0px 10px;"><font style="color:#b3b3b3;">热门搜索：</font><a href="#">星空</a> , <a href="#">山丘</a> , <a href="#">花</a></p>
		</div>
	</div>
</div>
<!-- 主要内容 -->
<div class="container" style="width:72%;">
	<div class="waterfull clearfloat" id="waterfull">
		<ul id="PrepareData"> 
		
		<s:iterator value="#pageBean.list" var="image"  status="L">
		
			<!-- 1.一个完整的图片 -->
			<li class="item">
				<a href="" class="a-img" data-toggle="modal" data-target="#myModal<s:property value="#L.index+1"/>">
					<img src="<s:property value="#image.img_Src" />" alt="" style="">
				</a>
				<!-- 模态框 -->
				<div class="modal fade" id="myModal<s:property value="#L.index+1"/>" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				  <div class="modal-dialog" style="width: 90%;">
				   <div class="modal-content">
				     <!-- 最顶层：关闭按钮（x）、标题 -->
				     <div class="modal-header" style="padding: 18px;border-bottom: 0px;">
				      <a  href="${pageContext.request.contextPath }/imgDownload?fileName=<s:property value="#image.img_name" />" class="btn btn-default btn-lg" style="float: right;border:0px;padding: 5px 10px;">
						  <span class="glyphicon glyphicon-save" aria-hidden="true"></span>下载
					  </a>
				      <div class="modal-title" id="myModalLabel">
				      	上传者:<s:property value="#image.img_user_userName.user_userName" />
				      </div><!-- 标题 -->
				     </div>
				     <!-- 中间：主要内容 -->
				     <div class="modal-body" style="padding: 0px;text-align: center;">
				     	<button class="img-Size" style="border:0px;background-color:white;width:80%;" onclick='imgSize(this)'>
				       	<img src="<s:property value="#image.img_Src" />" alt="" style="width:100%;">
					</button>
				     </div>
				     <!-- 最底层：两个按钮 -->
				     <div class="modal-footer" style="border-top: 0px;">
				       <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				       <!-- <button type="button" class="btn btn-primary">Save changes</button> -->
					      </div>
					    </div>
					  </div>
					</div>
				</li>
				
			</s:iterator>
				
				
			</ul>
	</div>
	
	
	

	
	
	<span style="color:red;">共[<B><s:property value="#pageBean.totalCount" /> </B>]条记录,[<B><s:property value="#pageBean.totalPage" /></B>]页</span>
		<!--分页 -->
	<div style="width: 760px; margin: 0 auto; margin-top: 50px;" align="center">
		<ul class="pagination" style="text-align: center; margin-top: 10px;">
		
			<!-- 上一页 -->
			<!-- 判断当前页是否是第一页 -->
			<c:if test="${pageBean.currentPage==1 }">
				<li class="disabled">
					<a href="javascript:void(0);" aria-label="Previous">
						<span aria-hidden="true">&laquo;</span>
					</a>
				</li>
			</c:if>
			<c:if test="${pageBean.currentPage!=1 }">
				<li>
					<a href="${pageContext.request.contextPath }/imageAction_list?pageSize=12&currentPage=${pageBean.currentPage-1}" aria-label="Previous">
						<span aria-hidden="true">&laquo;</span>
					</a>
				</li>
			</c:if>	
			
			
			
		
			<c:forEach begin="1" end="${pageBean.totalPage }" var="page">
				<!-- 判断当前页 -->
				<c:if test="${pageBean.currentPage == page }">
					<li class="active"><a href="javascript:void(0);">${page}</a></li>
				</c:if>
				<!-- 如果不是当前页就能点击-->
				<c:if test="${pageBean.currentPage != page }">
					<li><a href="${pageContext.request.contextPath }/imageAction_list?pageSize=12&currentPage=${page}">${page}</a></li>
				</c:if>
			
			</c:forEach>
			
			<!-- 判断当前页是否是最后一页 -->
			<c:if test="${pageBean.currentPage==pageBean.totalPage }">
				<li class="disabled">
					<a href="javascript:void(0);" aria-label="Next"> 
						<span aria-hidden="true">&raquo;</span>
					</a>
				</li>
			</c:if>
			<c:if test="${pageBean.currentPage!=pageBean.totalPage }">
				<li>
					<a href="${pageContext.request.contextPath }/imageAction_list?pageSize=12&currentPage=${pageBean.currentPage+1}" aria-label="Next"> 
						<span aria-hidden="true">&raquo;</span>
					</a>
				</li>
			</c:if>
		
		</ul>
	</div>
	<!-- 分页结束 -->
	
	
	
	
	
	
	
	
</div>











<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<!-- 底部 -->
<div style="width:100%;height:100px;background:black;text-align:center;color:white;padding-top:25px;">
	<h3>谢谢访问！</h3>
</div>
</body>
</html>