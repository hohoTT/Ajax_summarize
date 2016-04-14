<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>BootstrapCheckUserNameDemo Index Page</title>

<!-- 
	Bootstrap 样式的表单
 -->
 
<link rel="stylesheet" href="${ pageContext.request.contextPath }/static/css/bootstrap.min.css">

 <!-- 使用绝对路径导入 jQuery 资源文件 -->
<script type="text/javascript" src="${ pageContext.request.contextPath }/static/js/jquery-1.12.3.min.js"></script>

<script type="text/javascript" src="${ pageContext.request.contextPath }/static/js/bootstrap.min.js"></script>

<script type="text/javascript">

</script>

</head>
<body>

	<h1>BootstrapCheckUserNameDemo Index Page</h1><hr/>
	<div class="container main">
        <div class="col-md-6 col-md-offset-3">
			<form id="register-form" action="" method="post">
			
				<div class="form-group">
		           <label for="username">用户名</label>
		           <input type="text" class="form-control input-lg" id="username" name="username" placeholder="用户名" data-remote="/api/username_check/" data-remote-error="该用户名已被注册！" data-error="请填写用户名" required autofocus>
		           <div class="help-block with-errors"></div>
		       </div>
				
				<div class="form-group">
                    <button type="submit" class="btn btn-primary">提交</button>
                </div>
			</form>
		</div>
	</div>

</body>
</html>