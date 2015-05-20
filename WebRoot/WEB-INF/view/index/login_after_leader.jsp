<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title>学生异动管理</title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>
<script src="js/respond.js"></script>
<script src="js/admin.js"></script>
</head>

<body>
	<div class="lefter">
		<div class="logo">学生异动管理</div>
	</div>
	<div class="righter nav-navicon" id="admin-nav">
		<div class="mainer">
			<div class="admin-navbar">
				<span class="float-right"> <a
					class="button button-little bg-yellow" href="login.html">注销登录</a>
				</span>
				<ul class="nav nav-inline admin-nav">
					<li class="active"><a href="#" class="icon-cog"> 详情</a></li>
				</ul>
			</div>

		</div>
	</div>

	<div class="admin">

		<div class="tab">
			<div class="tab-head">
				<strong></strong>
				<ul class="tab-nav">
					<li class="active"><a href="#tab-apply-detail">申请详情</a></li>
					<li><a href="#tab-process-detail">进度详情</a></li>
				</ul>
			</div>
			<div class="tab-body">
				<div class="tab-panel active" id="tab-apply-detail">申请详情</div>
				<div class="tab-panel active" id="tab-process-detail" style="">进度详情<
				</div>
			</div>
		</div>
		<p class="text-right text-gray">
			基于<a class="text-gray" target="_blank" href="http://www.pintuer.com">拼图前端框架</a>构建
		</p>
	</div>

	<div class="hidden">
		<script src="http://s4.cnzz.com/stat.php?id=5952475&web_id=5952475"
			language="JavaScript"></script>
	</div>
</body>
</html>