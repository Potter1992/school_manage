package com.school.controller;

import java.io.File;
import java.util.List;
import com.jfinal.core.Controller;
import com.jfinal.kit.FileKit;
import com.jfinal.kit.JsonKit;
import com.jfinal.kit.StrKit;
import com.school.model.Academy;
import com.school.model.Student_apply;
import com.school.model.Zfxfzb_xsjbxxb;

public class IndexController extends Controller {
	/**
	 * 首页
	 */
	public void index() {
		render("index.jsp");
	}
	/**
	 * 跳转到login中的学生登陆后的页面
	 */

	public void login_after_student() {
		render("login/login_after_student.jsp");
	}
	
	/**
	 * 获得学院数据
	 */
	public void getAcademy() {
		String para = getPara("q");
		if (StrKit.isBlank(para)) {
			renderJson(Academy.me.findAll());
		} else {
			List<Academy> list = Academy.me.findByArgs(para);
			String jsonString = JsonKit.toJson(list);
			renderJson(jsonString);
		}
	}
}
