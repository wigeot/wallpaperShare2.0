$(function(){
	
	//0.1移动滚动条设置置顶层背景颜色
	$(window).scroll(function () {
		if ($(document).scrollTop() >= 150) {//如果高度大于150，则隐藏搜索框
			      $(".header_1").fadeIn();
			}
		if($(document).scrollTop() <= 150){
		  	      $(".header_1").fadeOut();
			}
	});	
	
	//1.1设置定时（5S）更换背景图片函数
	var i = 1;
	function timebackgroundimage(){
		setInterval(function (){
		$("body").css("background-image",function(){
			if(i<3){
				i++;
				return "url(/wallpaperShare/img/index/0"+i+".jpg)";
				}
			else{
				i = 1;
				return "url(/wallpaperShare/img/index/0"+i+".jpg)";
				}
			})},5000);
	}
	//1.2.2调用定时函数背景图片
	timebackgroundimage();
	
	
	
	
	
});