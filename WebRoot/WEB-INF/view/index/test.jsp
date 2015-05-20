<%@ page language="java" contentType="text/html; charset=utf-8""
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"">
<title>Insert title here</title>
</head>
<body>
123456
<table border="1">
<tr>1</tr>
<c:forEach items="${list }" var="l">
		<tr>${l.academy_name}</tr>
</c:forEach>
</table>
</body>
</html>