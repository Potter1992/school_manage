<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	
</script>
</head>
<body>
	<div class="collapse">
		<div class="panel ">
			<div class="panel-head">
				<h4>申请人:测试,学号:201201001003:申请类型:保留学籍</h4>
			</div>
			<div class="panel-body">
				详情
				<jsp:include page="click_student_apply_detail.jsp"></jsp:include></div>
		</div>
		<c:forEach items="${stulist}" var="s">
		<div class="panel">
			<div class="panel-head">
				<h4>申请人:${s.s_name},学号:<strong>${s.s_no }</strong>申请类型:<strong class="">${s.c_name}</strong></h4>
			</div>
			<div class="panel-body bg-red">
				申请人:${s.s_name},学号:${s.s_no }:申请类型:${s.c_name},${s}
			</div>
		</div>
		
		
		</c:forEach>
		
	</div>
</body>
</html>