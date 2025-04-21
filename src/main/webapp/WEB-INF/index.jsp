<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
	<title>后台管理</title>
	<meta charset="utf-8" />
	<link rel="stylesheet" href="/css/admin.css" />
</head>
<body>
<div class="container">
	<div id="header">
		<jsp:include page="header.jsp"></jsp:include>
	</div>
	<div id="admin_left">
		<ul class="submenu">
			<jsp:include page="left.jsp" />
		</ul>
		<div id="copyright"></div>
	</div>

	<div id="admin_right">
		<p>欢迎使用蜗牛嗨购商城后台管理平台</p>
	</div>
	<div id="separator"></div>
</div>
</body>
</html>
