package com.school.controller;

import java.io.File;
import java.util.List;
import java.util.Map;

import com.jfinal.core.Controller;
import com.jfinal.kit.FileKit;
import com.school.model.Change;
import com.school.model.Student_apply;
import com.school.model.Zfxfzb_xsjbxxb;

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
		
		if (student_apply.save()) {
			renderText("保存失败");
		}
		render("index/login_after_student");

	}

	/*
	 * 处理上传的图片
	 */
	public void handleImg() throws Exception {
		// 为每一个用户创建一个文件名以他的学号命名
		File file = getFile("image", "image").getFile();
		// GraphicsUtilities.

		if (file.getName().endsWith("jpg")) {
			file.renameTo(new File("upload/image/" + "201201001003" + ".jpg"));
			setAttr("img", "upload/image/" + file.getName());
			setAttr("msg", "上传成功");
			render("handleImg.jsp");
		} else {
			FileKit.delete(file);
			setAttr("msg", "格式错误");
			render("handleImg.jsp");
		}
	}
}
