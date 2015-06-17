<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script src="<%=request.getContextPath()%>/js/jquery.js"></script>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/pintuer.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/admin.css" />
<meta name="viewport" content="width=device-width,initial-scale=1">

<script src="<%=request.getContextPath()%>/js/pintuer.js"></script>
<script src="<%=request.getContextPath()%>/js/respond.js"></script>
<script src="<%=request.getContextPath()%>/js/admin.js"></script>
<script type="text/javascript">
	$(function() {
		$("input").addClass("input");
	});
</script>
<style type="text/css">
td {
	text-align: center;
	height: 30px;
	line-height: 30px;
}
</style>
<script type="text/javascript">
	$(function() {
		$("#addApprove input").addClass("input");
		$.post("../getAcademy", "", function(data) {
			var html = "";
			html += "<option>${app.a_academy }</option>";
			$.post("../getR_name", "", function(data) {
				var html = "";
				html += "<option>${app.r_name }</option>";
				for ( var i in data) {
					html += "<option>" + data[i].r_name + "</option>";
				}
				$("#r_name").html(html);
			});
			for ( var i in data) {
				html += "<option>" + data[i].xymc + "</option>";
			}
			$("#academy").html(html);
		});

	});
</script>
</head>

</html>