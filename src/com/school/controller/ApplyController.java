package com.school.controller;

import java.util.List;

import com.jfinal.core.Controller;
import com.school.model.Change;
import com.school.model.Student_apply;
import com.school.model.Xydmb;
import com.school.model.Zfxfzb_xsjbxxb;
import com.school.model.Zydmb;

/**
 * 当输入完密码时进行验证，学号和密码是否正确，此时需从oral数据库中查询学生的基本信息
 * 
 * @author liulei
 *
 */
public class ApplyController extends Controller {

	/**
	 * 渲染申请页面,点击申请时进行申请学生学号密码验证，并获取学生的信息，初始化申请页面,取出异动类型
	 */
	public void apply_form() {

		List<Change> changess = Change.me.findAll();
		// setAttr("change_data", changess);
		setSessionAttr("change_data", changess);
		render("validate_student.jsp");
	}

	/**
	 * 验证用户输入的学号和密码,获取异动类型的id
	 */
	public void validate_student() {
		String para_sno = getPara("s_no");
		String para_password = getPara("s_password");
		String change_name = getPara("c_name");
		// 根据id获取异动类型的名称
		Change change = Change.me.findIDChangeByName(change_name);

		List<Zfxfzb_xsjbxxb> student = Zfxfzb_xsjbxxb.me.findWithValidate(
				para_sno, para_password);

		if (student != null && student.size() > 0) {
			List<Xydmb> academies=Xydmb.me.findAll();
			setAttr("list_academy", academies);
			setSessionAttr("current_student", student.get(0));
			setAttr("student", getSessionAttr("current_student"));
			setAttr("change", change);
			render("apply_stu.jsp");
		} else {
			setAttr("s_no", para_sno);
			setAttr("msg", "登陆失败,学号或密码不正确");
			render("validate_student.jsp");
		}
	}

	/**
	 * 保存学生提交的表单到数据库
	 */
	public void save_apply() {
		Student_apply student_apply = getModel(Student_apply.class, "stu");
		
		if (student_apply != null&&!student_apply.equals("")) {
			if (student_apply.save()) {
				render("../login/login_after_student");
			} else {
				renderText("保存失败");
			}
		}
		renderText("您没有改变任何信息");

	}
	/**
	 * 获得专业数据
	 */
	public void getSubjectbyAcademy() {
		String para = getPara("q");
		List<Zydmb> zydmbs=Zydmb.me.findByAcademy(para);
		renderJson(zydmbs);
//		if (StrKit.isBlank(para)) {
//			List<Zfxfzb_xsjbxxb> list = Zfxfzb_xsjbxxb.me.findAll();
//			renderJson(list);
//		} else {
//			List<Zfxfzb_xsjbxxb> list = Zfxfzb_xsjbxxb.me.findByArgs(para);
//			String jsonString = JsonKit.toJson(list);
//			renderJson(jsonString);
//		}
	}
}
