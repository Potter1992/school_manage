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
<jsp:include page="css_js.jsp"></jsp:include>
<script src="js/auto_hidden.js"></script>
</head>

<body>
<input type="text" id="r_level" value="${r_level}" hidden="hidden" >
	<div class="lefter">
		<div class="logo">学生异动管理</div>
		<div></div>
	</div>
	<div class="righter nav-navicon" id="admin-nav">
		<div class="mainer">
			<div class="admin-navbar" style="margin-top: 13px">
				<span class="float-right"> <a
					class="button button-little bg-yellow" href="unLogin">注销登录</a>
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
				<strong>${r_level }</strong>
				<ul class="tab-nav">
					<li class="active">
					<a href="#tab-apply-detail" id="apply">申请详情</a></li>
					<li><a href="#tab-process-detail" id="process">进度详情</a></li>
					<li><a href="#tab-student-detail" id="student">学生申请</a></li>
					<li><a href="#tab-manage-detail" id="manage">系统管理</a></li>
				</ul>
			</div>


			<div class="tab-body">
				<div class="tab-panel active" id="tab-apply-detail">申请详情</div>
				<div class="tab-panel " id="tab-process-detail">进度详情</div>
				<div class="tab-panel  " id="tab-student-detail">学生申请</div>
				<div class="tab-panel " id="tab-manage-detail">系统管理</div>
			</div>
		</div>
		<p class="text-right text-gray">${msg}</p>
	</div>

</body>
</html>