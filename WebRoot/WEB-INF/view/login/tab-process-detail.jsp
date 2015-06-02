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
		var percent = Math.round(num / nums * 100 );
		$("#progress-number").css("width", percent+ "%");
		$("#progress-number").text("进度:" + percent  + "%");
	});
</script>
</head>
<!--  aa_current_a_type:null, s_no:201201001003, aa_next_a_type:null, c_id:7, aa_id:10, aa_time:2015/05/31 10:55:15-->

<body>${msg}<br>
	学号:${apps.s_no}异动类型:${stu.c_name}${change.c_name}当前审核人的层次:${apps.aa_current_a_type}
	下一个审核人的层次:${apps.aa_next_a_type}
	<br>当前审核步数
	<div id="step">${apps.aa_current_step}</div>
	总步数:
	<div id="steps">${apps.aa_steps}</div>
	<div class="progress progress-big">
		<div class="progress-bar" id="progress-number" style="width: 50%;">进度：50%</div>
	</div>

</body>
</html>