<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>testLoad Page</title>

<script type="text/javascript" src="scripts/jquery-1.8.3.js"></script>

<script type="text/javascript">

	$(function(){

		$("a").click(function(){

			// 使用 Load 方法处理 Ajax
			var url = this.href;
			var args = {"time" : new Date()};
			
			$("#content").load(url, args);
			
			// 取消默认的方法
			return false;
		});
		
	});

</script>

</head>
<body>

	<h1>The testLoad Page</h1><hr/>
	
	<a href="helloAjax.txt">HelloAjax</a><br/>
	
	<div id="content">
		
	</div>

</body>
</html>