<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>checkUsernameDemo Index Page</title>

<!-- 
	实现利用 Ajax 验证用户名的具体步骤如下：
	
		1. 导入 jQuery 库
		2. 获取 name="username" 的节点 ： username
		3. 为 username 添加 change 响应函数
		   3.1  获取 username 的 value 属性值，去除前后空格且不为空。准备发送 Ajax 请求
		   3.2 发送 Ajax 请求，检验 username 是否可用
		   3.3 在服务端直接返回一个 html 片段 : <font color="red">该用户名已经被使用</font>
		   3.4 在客户端浏览器把其直接添加到 #message 的 html 中
		
 -->
 
 <!-- 使用绝对路径导入 jQuery 资源文件 -->
<script type="text/javascript" src="${ pageContext.request.contextPath }/scripts/jquery-1.8.3.js"></script>

<script type="text/javascript">

	$(function(){
		$(":input[name='username']").change(function(){
			var val = $(this).val();

			// 去除前后空格
			val = $.trim(val);

			if(val != ""){
				var url = "${ pageContext.request.contextPath }/validateUserName";
				var agrs = {"username" : val, "time" : new Date()};

				$.post(url, agrs, function(data){
					$("#message").html(data);
										
				});
			}
			
		});
		
	})

</script>

</head>
<body>

	<h1>checkUsernameDemo Index Page</h1><hr/>
	
	<form action="" method="post">
	
		UserName : <input type="text" name="username"/>
		<br><br>
		
		<div id="message"></div>
		<br><br>
		
		<input type="submit" value="Submit"/>
	
	</form>

</body>
</html>