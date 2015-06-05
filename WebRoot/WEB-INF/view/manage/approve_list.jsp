<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<div class="table-responsive" id="remove">
		<table class="table">
			<thead>
				<tr class="text-main">
					<td>审核人账号</td>
					<td>审核人姓名</td>
					<td>审核人密码</td>
					<td>审核人级别</td>
					<td>审核人签字</td>
					<td>审核人角色类型</td>
					<td>审核人学院</td>
					<td class="text-dot">操作</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${approve }" var="app">
					<tr id="hover">
						<td>${app.a_account }</td>
						<td>${app.a_name }</td>
						<td>${app.a_password }</td>
						<td>${app.a_type }</td>
						<td><img width="50px" height="25px" src="${app.a_img }" /></td>
						<td>${app.r_name }</td>
						<td>${app.a_academy }</td>
						<td><a href="handle_approve/${app.a_id}" id="edit_approve">修改</a>
						</td>
						<td><a href="deleteApprove/${app.a_id}">删除</a></td>
					</tr>


				</c:forEach>
			</tbody>
		</table>
	</div>
	</body>
</html>