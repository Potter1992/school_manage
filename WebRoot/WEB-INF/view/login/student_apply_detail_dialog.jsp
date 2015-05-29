<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
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
						<!-- <p>...</p> -->
						<small>${s}</small>

					</blockquote>
					<button class="button bg-sub radius-rounded float-right">审核通过</button>
				</div>
			</div>


		</c:forEach>

	</div>
</body>
</html>