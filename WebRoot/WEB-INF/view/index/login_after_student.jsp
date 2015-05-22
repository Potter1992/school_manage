<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
			<jsp:include page="tab-head.jsp" ></jsp:include>
			<div class="tab-body">
				<div class="tab-panel active" id="tab-apply-detail">
					<ul class="list-group list-striped">
						<c:forEach items="${stu_list}" var="stu">
							<font size="1dp"><li>学号:</li>
							<li>${stu.s_no}</li>
								<li>性别:</li>
							<li>${stu.s_sex}</li>
								<li>签字图片:</li>
							<li><img alt="签字图片" src="/image/${stu.s_img}" style="width: 300px;height: 60px"> </li>
								<li>异动类型ID:</li>
							<li>${stu.c_id}</li>
								<li>异动前学院:</li>
							<li>${stu.s_before_academy}</li>
								<li>异动后学院:</li>
							<li>${stu.s_after_academy}</li>
								<li>异动前专业:</li>
							<li>${stu.s_before_subject}</li>
								<li>异动后专业:</li>
							<li>${stu.s_after_subject}</li>
								<li>异动前班级:</li>
							<li>${stu.s_before_class}</li>
								<li>异动后班级:</li>
							<li>${stu.s_after_class}</li>
								<li>学制</li>
							<li>${stu.s_year}</li>
								<li>异动前专业代码:</li>
							<li>${stu.s_before_subject_no}</li>
								<li>异动后专业代码:</li>
							<li>${stu.s_after_subject_no}</li>
								<li>异动前学籍状态:</li>
							<li>${stu.s_before_status}</li>
								<li>异动后学籍状态:</li>
							<li>${stu.s_after_status}</li>
								<li>异动前学历:</li>
							<li>${stu.s_before_education}</li>
								<li>异动后学历:</li>
							<li>${stu.s_after_education}</li>
								<li>异动前是否注册:</li>
							<li>${stu.s_before_regist}</li>
								<li>异动后是否注册:</li>
							<li>${stu.s_after_regist}</li>
								<li>异动前是否在校:</li>
							<li>${stu.s_before_school}</li>
								<li>异动后是否在校:</li>
							<li>${stu.s_after_school}</li>
								<li>异动时间:</li>
							<li>${stu.s_changetime}</li></font>
						</c:forEach>
						<!-- id: 学号:s_no 姓名:s_name 密码:s_password 性别:s_sex 签字图片s_img 异动类型:c_id
						异动前学院:s_before_academy 异动后学院s_after_academy 异动前专业:s_before_subject
						异动后专业s_after_subject 异动前班级s_before_class 异动后班级s_after_class
						异动前年级:s_before_grade 异动后年级s_after_grade 学制:s_year
						专业代码(前后,根据学生所选专业定) s_before_subject_no s_after_subject_no
						异动前是否有学籍s_before_status 异动后是否有学籍s_after_status
						学历(前后)s_before_education s_after_education 是否注册(前后)
						s_before_regist s_after_regist 是否在校(前后) s_before_school
						s_after_school 异动时间s_changetime -->
					</ul>

				</div>
				<jsp:include page="tab-process-detail.jsp"></jsp:include>
				
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