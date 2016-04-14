<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>addItemsDemo Index Page</title>

<!-- 

	实现添加商品，展现 Ajax 效果的基本步骤如下:
	   1. 获取当前页面的所有 a 节点，并为每一个 a 节点都添加 onclick 响应函数，同时取消其默认行为
	   2. 准备发送 Ajax 请求: url(a 节点的 href 属性值); args(时间戳)
	   3. 响应为一个 json 对象，包括 : bookName、totalBookNumber、totalMoney
	   4. 把对应的属性添加到对应的位置
	   
	        特别要注意的一点是：从服务器端返回的 json 对象需要使用 "", 使用 '' 就不可以
 -->
 
 <!-- 使用绝对路径导入 jQuery 资源文件 -->
<script type="text/javascript" src="${ pageContext.request.contextPath }/scripts/jquery-1.8.3.js"></script>

<script type="text/javascript">

	$(function(){

		// 判断是否存在购物车
		var isHasCar = "${seesionScope.shoppingCart == null}";

		if(isHasCar == "true"){
			$("#cartstatus").hide();
		}
		else{
			$("#cartstatus").show();
			
			$("#bookName").text("${seesionScope.shoppingCart.bookName}");
			$("#totalBookNumber").text("${seesionScope.shoppingCart.totalBookNumber}");
			$("#totalMoney").text("${seesionScope.shoppingCart.totalMoney}");
		}

		$("a").click(function(){
			$("#cartstatus").show();

			var url = this.href;
			var agrs = {"time" : new Date()};

			// 特别要注意的一点是：从服务器端返回的 json 对象需要使用 "", 使用 '' 就不可以
			$.getJSON(url, agrs, function(data){

				$("#bookName").text(data.bookName);
				$("#totalBookNumber").text(data.totalBookNumber);
				$("#totalMoney").text(data.totalMoney);
				
			});
			
			// 取消默认 a 标签的默认行为
			return false;
		})
		
	})

</script>

</head>
<body>

	<h1>addItemsDemo Index Page</h1><hr/>
	
	<div id="cartstatus">
		您已经将  &nbsp; <span id="bookName"></span> &nbsp; 加入到购物车中，
		购物车中的书有  &nbsp; <span id="totalBookNumber"></span> &nbsp; 本，
		总价格为  &nbsp; <span id="totalMoney"></span> &nbsp; 元钱。
	</div>
	<br/><br/>

	Java &nbsp;&nbsp; <a href="${ pageContext.request.contextPath }/addToCart?id=Java&price=100">加入购物车</a>
	<br/><br/>
	
	Oracle &nbsp;&nbsp; <a href="${ pageContext.request.contextPath }/addToCart?id=Oracle&price=200">加入购物车</a>
	<br/><br/>
	
	Struts2 &nbsp;&nbsp; <a href="${ pageContext.request.contextPath }/addToCart?id=Struts2&price=300">加入购物车</a>
	<br/><br/>

</body>
</html>