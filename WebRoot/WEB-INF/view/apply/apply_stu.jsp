<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="css_js.jsp"></jsp:include>
<title>申请页面</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

</head>

<body>

	<form action="" id="search-form">
		<div class="panel-body" style="padding: 40px;">

			<div class="form-group">
				<div class="field field-icon-right">
					<div style="width: 100%; height: 40px">
						<div class=" border border-blue radius-big float-left "
							id="option_head">学生信息</div>
						<div class="border border-blue radius-big float-right"
							id="option_head">变动信息</div>
					</div>
					<div class="border border-green radius-big float-left"
						style="width: 40%; padding: 10px 20px">
						<label id="option_label">学号:</label><input readonly="readonly"
							type="text" class="input" id="s_no" name="s_no" placeholder="学号"
							value="${student.xh }" /><br> <label id="option_label ">姓名:</label>
						<input readonly="readonly" type="text" class="input" id="s_name"
							name="s_name" placeholder="姓名" value="${student.xm }" /> <br>
						<label id="option_label">性别:</label><input readonly="readonly"
							type="text" name="s_sex" value="${student.xb}"><br>
						<input type="text" value="1" name="c_id" hidden="hidden"><br>
						<label id="option_label id="option_label">您所在的学院:</label> <select
							id="s_before_academy" readonly="readonly" class="input"
							name="s_before_academy">
							<option>${student.xy}</option>

						</select> <br> <label id="option_label">您的专业:</label> <select
							id="s_before_subject" class="input" name="s_before_academy">
							<option>${student.zymc}</option>
						</select> <br> <label id="option_label">您所在的年级:</label> <input
							type="text" class="input" readonly="readonly"
							name="s_before_grade" placeholder="异动前年级" readonly="readonly"
							value="${student.dqszj}" /> <br> <label id="option_label">您所在的班级:</label>
						<input type="text" class="input" name="s_before_class"
							readonly="readonly" placeholder="异动前班级" value="${student.xzb }" />
						<br> <label id="option_label">学年:</label> <input
							type="s_year" class="input" readonly="readonly" name="s_year"
							placeholder="学制" value="${student.xz }" /> <br> <label
							id="option_label">学籍状态:</label> <input type="text"
							readonly="readonly" name="s_before_status"
							value="${student.xjzt}" class="input" /> <br> <label
							id="option_label">学历状态:</label> <input type="text" class="input"
							readonly="readonly" name="s_before_education" placeholder="学历前"
							value="${student.cc}" /> <br> <label id="option_label">注册状态:</label>
						<input type="text" name="s_before_regist" class="input"
							readonly="readonly" value="${student.zc }"> <br> <label
							id="option_label">在校状态:</label> <input type="text" class="input"
							readonly="readonly" name="s_before_school" value="${student.zx}">

					</div>
				</div>






				<div class="border border-green radius-big float-right"
					style="width: 50%; padding: 10px 20px; margin-left: 10px">
					<br> <label id="option_label">学院:</label> <select
						id="s_after_academy" class="input" name="s_after_academy">
						<c:forEach items="${list_academy}" var="academy">
							<option>${academy.academy_name}</option>
						</c:forEach>
					</select> <br> <label id="option_label">专业:</label> <select
						id="s_after_subject" class="input" name="s_after_academy">
						<c:forEach items="${list_subject}" var="subject">
							<option>${subject.zymc}</option>
						</c:forEach>
					</select> <br> <label id="option_label">年级:</label> <input
						type="s_after_grade" class="input" name="s_after_grade"
						placeholder="异动后年级" /> <br> <label id="option_label">班级:</label>
					<input type="s_after_class" class="input" name="s_after_class"
						placeholder="异动后班级" /> <br> <label id="option_label">学籍状态:</label><input
						type="radio" name="s_after_status" value="有" checked="checked">
					有<input type="radio" name="s_after_status" value="无"
						style="margin-left: 20px"> 无<br> <br> <label
						id="option_label">学历:</label><select id="s_after_education"
						class="input" name="s_after_education">
						<option>无</option>
						<option>本科</option>
						<option>专科</option>
					</select> <br> <label id="option_label">注册状态:</label><input
						type="radio" name="s_after_regist" value="有" checked="checked">
					有 <input type="radio" name="s_after_regist" value="无"
						style="margin-left: 20px"> 无<br> <label
						id="option_label">在校状态:</label><input type="radio"
						name="s_after_school" value="有" checked="checked"> 有 <input
						type="radio" name="s_after_school" value="无"
						style="margin-left: 20px"> 无<br> <input type="submit"
						value="提交申请" class="button radius-big text-green "
						style="margin-top: 20px; width: 100%" />
				</div>
				<!--  <input type="text" name="s_before_academy" class="input academy drop open" id="s_before_academy"
        placeholder="请输入学院" onclick="getcomplete('#s_before_academy','getAcademy');"> -->
				<!-- <input type="text" class="input" name="s_after_academy"
                id="s_after_academy" placeholder="异动后学院"
                onclick="getcomplete1('#s_after_academy','getAcademy');" /> <input
                type="text" class="input" name="s_before_subject"
                id="s_before_subject" placeholder="异动前专业"
                onclick="getcomplete_subject('#s_before_subject','getSubject');" />
            <input type="text" class="input" name="s_after_subject"
                id="s_after_subject" placeholder="异动后专业"
                onclick="getcomplete_subject1('#s_after_subject','getSubject');" />
                	id: 学号:s_no 姓名:s_name 密码:s_password 性别:s_sex 签字图片s_img 异动类型:c_id
	异动前学院:s_before_academy 异动后学院s_after_academy 异动前专业:s_before_subject
	异动后专业s_after_subject 异动前班级s_before_class 异动后班级s_after_class
	异动前年级:s_before_grade 异动后年级s_after_grade 学制:s_year 专业代码(前后,根据学生所选专业定)
	s_before_subject_no s_after_subject_no 异动前是否有学籍s_before_status
	异动后是否有学籍s_after_status 学历(前后)s_before_education s_after_education
	是否注册(前后) s_before_regist s_after_regist 是否在校(前后) s_before_school
	s_after_school 异动时间s_changetime
                
                 -->

			</div>
		</div>
		</div>

	</form>

</body>
</html>

