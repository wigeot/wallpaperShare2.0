			$(function(){
				//2.创建二维数组用于存储省份和城市
				var cities = new Array(3);
				cities[0] = new Array("南昌市","景德镇市","景德镇市","九江市","新余市","鹰潭市","鹰潭市","宜春市","上饶市","吉安市","抚州市");
				cities[1] = new Array("长沙市","株洲市","株洲市","衡阳市","邵阳市","岳阳市","岳阳市","张家界市","益阳市","郴州市","永州市","永州市","娄底地区","湘西土家族苗族自治州");
				cities[2] = new Array("广州市","韶关市","深圳市","珠海市","汕头市","佛山市","江门市","湛江市","茂名市","肇庆市","惠州市","汕尾市","河源市","阳江市","清远市","潮州市","揭阳市	","云浮市","潮州市","东莞市","中山市");
				cities[3] = new Array("郑州市","洛阳市","平顶山市","安阳市","鹤壁市","新乡市","焦作市","濮阳市","许昌市","漯河市","三门峡市","南阳市","商丘市","周口市","驻马店地区");
				
				$("#province").change(function(){//获取第一个下拉列表框
					//10.清除第二个下拉列表的内容
					$("#city").empty();
					
					//1.获取用户选择的省份
					var val = this.value;
					var val1 = 0;
					if(val=="江西省"){
						val1 = 0;
					}
					if(val=="湖南省"){
						val1 = 1;
					}
					if(val=="广东省"){
						val1 = 2;
					}
					if(val=="河南省"){
						val1 = 3;
					}
					//alert(val);
					//3.遍历二维数组中的省份
					/*
					 * $.each(cities,function(i,n)  -  通用例遍方法，可用于例遍对象和数组。
					 * cities需要例遍的对象或数组。
					 * unction(i,n)(可选)元素执行的回调函数。
					 */
					$.each(cities,function(i,n){//i为元素下标，n为所有市名
						//alert(i+":"+n);
						//4.判断用户选择的省份和遍历的省份
						if(val1==i){
							//5.遍历该省份下的所有城市
							$.each(cities[i], function(j,m) {//j为元素下标，m为市名
								//alert(j+":"+m);
								//6.创建城市文本节点
								var textNode = document.createTextNode(m);
								//7.创建option元素节点
								var opEle = document.createElement("option");
								//8.将城市文本节点添加到option元素节点中去
								$(opEle).append(textNode);
								//9.将option元素节点追加到第二个下拉列表中去
								$(opEle).appendTo($("#city"));
								$(opEle).attr("value", cities[i][j]);//添加value="城市"
							});
						}
					});
					
				});
			});