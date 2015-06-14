<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>异动管理表</title>
<style type="text/css">
select {
	margin-top: 10px;
}

option {
	bottom: 14px;
	opacity: 1;
}

option :HOVER {
	bottom: 30px;
	opacity: 1;
}
</style>
<script type="text/javascript">
	function change_onchange() {
		var change_name = $("#change").val();
		var sort_sum = $("#sort_sum").val();
		if (sort_sum == "") {
			alert("请输入您的审核人具备的最基本的元素");
		} else {
			$.post("setRoleAndSort", {
				sort_sum : sort_sum,
				c_name : change_name
			}, function(data) {
				alert(data);
				
			});
		}

		alert(change_name);
	}
</script>
</head>
<body>
	<!-- 	选中异动类型>显示角色名称 添加顺序 异动id(复学) 顺序 角色id(教务) -->
	<form action="saveRoleAndChange" method="post">
		<div id="left" class="float-left">
			<!--右侧显示异动类型的选项  -->

			<strong class="text-white bg-main">请选择异动类型</strong> <select
				class="input" id="change" onchange="change_onchange();"
				name="c_name">
				<c:forEach items="${change}" var="c">
					<option>${c.c_name}</option>
				</c:forEach>

			</select>
			<!-- 需要添加的步骤总数 -->
			步骤总数:<input type="text" id="sort_sum" /> 请选择角色: <select class="input"
				name="role_name">
				<c:forEach items="${rList }" var="role">
					<option>${role.r_name }</option>
				</c:forEach>
			</select> 添加审核的顺序 <select class="input" name="rc_sort">
				<c:forEach items="${sort_sum }" var="sort">
					<option>${sort}</option>
				</c:forEach>
			</select>

		</div>
	</form>
	<hr class="bg-blue" />
	<div id="right">
		<!--左侧显示异动类型所对应的角色和顺序  -->
		<div id="tab">这是tab显示页面,添加和查看 删除 修改</div>
	</div>
	<div id="select-info">
		<!--左侧显示异动类型所对应的角色和顺序  -->
		<div id="tab">这是tab显示页面,添加和查看 删除 修改</div>

	</div>

</body>
</html>