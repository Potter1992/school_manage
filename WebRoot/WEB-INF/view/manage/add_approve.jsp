<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="css_js_add.jsp"></jsp:include>
<title>Insert title here</title>
<script type="text/javascript">
	$(function() {
		$("#addApprove input").addClass("input");
		$.post("../manage/getAcademy", "", function(data) {
			var html = "";
			html += "<option>无学院</option>";
			for ( var i in data) {
				html += "<option>" + data[i].xymc + "</option>";
			}
			$("#academy").html(html);
		});
		$.post("../manage/getR_name", "", function(data) {
			var html = "";
			for ( var i in data) {
				html += "<option>" + data[i].r_name + "</option>";
			}
			$("#r_name").html(html);
		});
	});
</script>
<style type="text/css">
</style>
</head>
<body>
	<jsp:include page="head.jsp"></jsp:include><!-- 管理员页面头部 -->
	<form action="addApprove" id="addApprove" method="post"
		class="form">
		<table class="table">
			<tr>
				<td><label>审核账号:</label></td>
				<td>
					<div class="form-group">
						<input class="input" type="text" name="app.a_account"
							value="${app.a_account }" data-validate="required:*"
							placeholder="审核账号">
					</div>
				</td>
				<td><label>审核密码:</label></td>
				<td>
					<div class="form-group">
						<input type="text" name="app.a_password"
							value="${app.a_password }" data-validate="required:*"
							placeholder="审核密码">
					</div>
				</td>

				<td><label>审核姓名:</label></td>
				<td><input type="text" name="app.a_name" placeholder="审核姓名"
					value="${app.a_name}"></td>
			</tr>
			<tr>
				<td><label>审核部门:</label></td>
				<td><input type="text" name="app.a_part" placeholder="审核部门"
					value="${app.a_part}"></td>

				<!-- <input type="text" name="app.a_type"placeholder="审核级别"></td>r_level -->
				<td><label>审核角色:</label></td>
				<td><select id="r_name" name="r_name" class="input"
					value="${r_name}">
						<option>审核角色</option>
				</select> <!-- <input type="text" name="app.r_id" placeholder="审核角色"></td>r_name -->
			</tr>
			<tr>
				<td><label>审核学院:</label></td>
				<td><select id="academy" name="app.a_academy" class="input"
					value="${app.a_academy }">
						<option>学院</option>
				</select>
				<td><label>审核签字: </label></td>
				<td><a class="button input-file" href="javascript:void(0);">
						+ 上传签字 <input type="file" name="app.a_img"
						data-validate="required:必填" value="${app.a_img }" />
				</a></td>
			</tr>

		</table>
		<div class="form-button">
			<input class="button bg-red" type="submit" value="修改" /> <a
				href="../manage/index" class="button bg-green" style="margin-top: 10px;">返回</a>
		</div>
	</form>
</body>
</html>