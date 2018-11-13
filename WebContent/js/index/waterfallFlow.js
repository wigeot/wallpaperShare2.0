	/*

		抛开瀑布流布局各种乱七八糟的算法，基于masonry的瀑布流，很是简单的，而且通过扩展animate,能实现瀑布流布局的晃动、弹球等效果。

		masonry还有很多参数我这里注解了常用的参数

	 */
		
		/*1.异步获取图片数据*/
		var sqlJson = null;//用于存储获取的json值
		var count = 0;//用于统计查询过多少次
		var a = 0;
		function searchWord(value,element,params){
			$.ajax({
				"async":true,
				"url":"/wallpaperShare/imgMessage",
				"data":{"count":count},
				"type":"POST",
				"dataType":"json",
				"success":function(data){
					//alert(data.length);//只会运行一次
					if(data.length>0){
						sqlJson = data;
					}else{
						sqlJson = null;
					}
				}
			});
			}
		
		
		/*2.点击变大变小图片 */
		var b = 0;
		function imgSize(btn){
			if(b==0){
				$(btn).animate({width:"100%"});
				b=1;
			}else if(b==1){
				$(btn).animate({width:"80%"});
				b=0;
			}
		}
		
		
		$(function(){
			
			/*1.使用searchWord（），加载数据库中的前30个数据(只运行一次)*/
			searchWord();
			
			/*2.使点击变大的图片在窗口关闭之后恢复原来的大小*/
			$('#myModal').on('hide.bs.modal', function () {
				$(".img-Size").animate({width:"80%"});}
			);
			
		
			/*3.瀑布流开始(下面全是瀑布流的函数)*/
			var container = $('.waterfull ul');

			var loading=$('#imloading');

			// 初始化loading状态

			loading.data("on",true);

			/*判断瀑布流最大布局宽度，最大为1280*/

			function tores(){

				var tmpWid=$(window).width();

				if(tmpWid>1340){

					tmpWid=1340;

				}else{

					var column=Math.floor(tmpWid/444.6);

					tmpWid=column*444.6;

				}

				$('.waterfull').width(tmpWid);

			}

			tores();

			$(window).resize(function(){

				tores();

			});
			
			container.imagesLoaded(function(){

				  container.masonry({

				  	columnWidth: 444.0,

				    itemSelector : '.item',

				    isFitWidth: true,//是否根据浏览器窗口大小自动适应默认false

				    isAnimated: true,//是否采用jquery动画进行重拍版

				    isRTL:false,//设置布局的排列方式，即：定位砖块时，是从左向右排列还是从右向左排列。默认值为false，即从左向右

				    isResizable: true,//是否自动布局默认true

				    animationOptions: {

						duration: 800,

						easing: 'easeInOutBack',//如果你引用了jQeasing这里就可以添加对应的动态动画效果，如果没引用删除这行，默认是匀速变化

						queue: false//是否队列，从一点填充瀑布流

					}

				  });

				});
			
			var index = 3;//使用这个放置动态弹窗重叠
			var j = 0;//用于辅助当只剩两个元素的时候来判断的
			$(window).scroll(function(){//只要滚动滚动条就会激活这个函数
				
				if(!loading.data("on")) return;

				// 计算所有瀑布流块中距离顶部最大，进而在滚动条滚动时，来进行ajax请求，方法很多这里只列举最简单一种，最易理解一种

				var itemNum=$('#waterfull').find('.item').length;

				var itemArr=[];

				itemArr[0]=$('#waterfull').find('.item').eq(itemNum-1).offset().top+$('#waterfull').find('.item').eq(itemNum-1)[0].offsetHeight;

				itemArr[1]=$('#waterfull').find('.item').eq(itemNum-2).offset().top+$('#waterfull').find('.item').eq(itemNum-1)[0].offsetHeight;

				itemArr[2]=$('#waterfull').find('.item').eq(itemNum-3).offset().top+$('#waterfull').find('.item').eq(itemNum-1)[0].offsetHeight;

				var maxTop=Math.max.apply(null,itemArr);

				if(maxTop<$(window).height()+$(document).scrollTop()){
					//加载更多数据
					
					loading.data("on",false).fadeIn(800);

					(function(sqlJson){

						/*这里会根据后台返回的数据来判断是否你进行分页或者数据加载完毕这里假设大于30就不在加载数据*/
						
						if(itemNum > 30 || sqlJson.length < 1){

							loading.text('就有这么多了！');

						}else{
							
							var html="";
							for(var i in sqlJson){
								index++;//初始值10
								html+="	<li class='item'>"+
									"		<a href='' class='a-img' data-toggle='modal' data-target='#myModal"+index+"'+>"+
									"			<img src='"+sqlJson[i].img_Src+"'>"+
									"		</a>"+
									"		<!-- 模态框 -->"+
									"		<div class='modal fade' id='myModal"+index+"' tabindex='-1' role='dialog' aria-labelledby='myModalLabel' aria-hidden='true'>"+
									"		  <div class='modal-dialog' style='width: 90%;'>"+
									"		    <div class='modal-content'>"+
									"		      <!-- 最顶层：关闭按钮（x）、标题 -->"+
									"		    <div class='modal-header' style='padding: 18px;border-bottom: 0px;'>"+
									"			      <a  href='imgDownload?fileName="+sqlJson[i].img_name+"' class='btn btn-default btn-lg' style='float: right;border:0px;padding: 5px 10px;'>"+
									"					  <span class='glyphicon glyphicon-save' aria-hidden='true'></span>下载"+
									"			  	  </a>"+
									"			     <div class='modal-title' id='myModalLabel'>"+
									"			     	上传者:"+sqlJson[i].login_userName+
									"			     </div><!-- 标题 -->"+
									"		      </div>"+
									"		      <!-- 中间：主要内容 -->"+
									"		      <div class='modal-body' style='padding: 0px;text-align: center;'>"+
									"		      	<button class='img-Size' style='border:0px;background-color:white;width:80%;' onclick='imgSize(this)'>"+
									"		        	<img src='"+sqlJson[i].img_Src+"' alt='' style='width:100%;'>"+
									"				</button>"+
									"		      </div>"+
									"		      <!-- 最底层：两个按钮 -->"+
									"		      <div class='modal-footer' style='border-top: 0px;'>"+
									"		        <button type='button' class='btn btn-default' data-dismiss='modal'>关闭</button>"+
									"		        <!-- <button type='button' class='btn btn-primary'>保存更改</button> -->"+
									"		      </div>"+
									"		    </div>"+
									"		  </div>"+
									"		</div>"+
									"  </li>"
									//没读三个图就停
									if((i + 1) % 3 == 0){
										sqlJson.splice(0, 2);
										sqlJson.splice(0, 1);
										sqlJson.splice(0, 0);
										//alert(sqlJson.length);
										//alert(i);
										break;
									}
									//当只剩下两个图（数据）时，进入判断
									if(sqlJson.length == 2){
										//alert("****");
										j = j+1;
										if(j == 2){
											sqlJson.splice(0, 2);
											sqlJson.splice(0, 1);
											break;
										}
									}
									//当只剩一个图的时候进入判断
									if(sqlJson.length == 1){
										//alert("=====");
										sqlJson.splice(0, 1);
										break;
									}
							}
							
							/*模拟ajax请求数据时延时800毫秒*/

							var time=setTimeout(function(){

								$(html).find('img').each(function(index){

									loadImage($(this).attr('src'));

								})

								var $newElems = $(html).css({ opacity: 0}).appendTo(container);

								$newElems.imagesLoaded(function(){

									$newElems.animate({ opacity: 1},800);

									container.masonry( 'appended', $newElems,true);

									loading.data("on",true).fadeOut();

									clearTimeout(time);

						        });

							},800)

						}

					})(sqlJson);

				}

			});

			function loadImage(url) {

			     var img = new Image(); 

			     //创建一个Image对象，实现图片的预下载

			      img.src = url;

			      if (img.complete) {

			         return img.src;

			      }

			      img.onload = function () {

			       	return img.src;

			      };

			 };

			 loadImage('/wallpaperShare/img/index.ico',test());

			/*item hover效果*/

			var rbgB=['#71D3F5','#F0C179','#F28386','#8BD38B'];

			$('#waterfull').on('mouseover','.item',function(){

				var random=Math.floor(Math.random() * 3);

				$(this).stop(true).animate({'backgroundColor':rbgB[random]},1000);

			});

			$('#waterfull').on('mouseout','.item',function(){

				$(this).stop(true).animate({'backgroundColor':'#fff'},1000);

			});
				
				
				
		})