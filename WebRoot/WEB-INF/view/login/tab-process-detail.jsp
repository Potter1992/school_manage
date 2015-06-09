<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	$(document).ready(function() {
		var num = $("#step").text();
		var nums = $("#steps").text();
		if (num==nums) {
			$("#agree").hide();
		}
		var percent = Math.round(num / nums * 100);
		$("#progress-number").css("width", percent + "%");
		$("#progress-number").text("进度:" + percent + "%");
	});
</script>
<style type="text/css">
dd div {
	display: inline;
}
</style>
</head>
<!--  aa_current_a_type:null, s_no:201201001003, aa_next_a_type:null, c_id:7, aa_id:10, aa_time:2015/05/31 10:55:15-->

<body>${msg}<br>
	<dl class="dl-inline clearfix">
		<dt>
			学号:${apps.s_no}<br>异动类型:<label style="color: red;">${stu.c_name}${change.c_name}</label>
		</dt>
		<dd>
			当前步数:
			<div id="step">${apps.aa_current_step}</div>
			总步骤
			<div id="steps">${apps.aa_steps}</div>
			<br>
			<div class="progress">
				<div class="progress-bar" id="progress-number${c.index}"
					style="width: 50%;">进度：50%</div>
			</div>
		</dd>
	</dl>

</body>
</html>