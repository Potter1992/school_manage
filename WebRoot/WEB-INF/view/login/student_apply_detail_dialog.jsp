<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function getagree() {
		$.post("", {}, function() {

		});
	}
	$(document).ready(function() {
		var num = 0;
		$(".panel-head").click(function() {
			num += 1;
			if (num % 2 == 0) {
				if ($(".panel").hasClass("active")) {
					$(".panel").removeClass("active");
				}
			}
		});
	});
</script>
</head>
<body>
	<div class="collapse">
		<c:forEach items="${stulist}" var="s">
			<div class="panel">
				<div class="panel-head" style="cursor: pointer;">
					<h4>
						申请人:${s.s_name},学号:<strong>${s.s_no }</strong>申请类型:<strong>${s.c_name}</strong>
					</h4>
				</div>

				<div class="panel-body">
					<blockquote class="border-main">
						<strong style="color: red;">申请人:${s.s_name},学号:${s.s_no }:申请类型:${s.c_name}</strong>
						<!-- <p>...</p>{s_before_status:有, s_manager_name:null,
						 s_password:123456, s_before_academy:信息管理学院, 
						 s_before_class:12计科本, s_after_school:有, s_after_area:德州学院,
						  s_id:37, s_before_subject:计算机科学与技术,
						   s_after_education:null, c_id:11, s_sex:男, s_after_class:未分配, s_before_education:本科,
						    s_before_subject_no:null, s_manager_time:null, s_after_academy:无, s_before_school:是, 
						    s_after_subject:无, s_before_grade:2012, s_after_grade:null, 
						    s_changetime:2015/05/31 23:50:25, s_after_regist:有,
						     r_level:学生, s_img:null, s_before_regist:是,
						      s_no:201201001003, s_year:4, c_name:保留入学资格, s_after_status:有,
						       s_name:刘磊, s_before_area:德州学院, s_after_subject_no:null} -->
						<big><label style="color: blue;">申请前内容:</label>学号:${s.s_no},姓名:${s.s_name},性别:${s.s_sex},所在学院${s.s_before_academy},所在专业${s.s_before_subject }
							,所在班级:${s.s_before_class},是否注册:${s.s_before_regist} </big><br> <big><label
							style="color: blue;">申请后内容:</label>所在学院:${s.s_after_academy},所在专业:${s.s_after_subject }
							,所在班级:${s.s_after_class},是否注册:${s.s_after_regist}</big>

					</blockquote>
					<button class="button bg-sub radius-rounded float-right"
						onclick="getagree()">审核通过</button>
				</div>
			</div>


		</c:forEach>

	</div>
</body>
</html>