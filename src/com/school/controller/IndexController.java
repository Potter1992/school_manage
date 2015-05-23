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
	public void index() {

		render("index.jsp");
	}

	/*
	 * 测试自动补全
	 */
	public void academy() {
		render("getdata.jsp");
	}

	

	public void login_after_student() {
		render("login/login_after_student.jsp");
	}
	

	/*
	 * 处理上传的图片
	 */
	public void handleImg() throws Exception {
		// 为每一个用户创建一个文件名以他的学号命名
		File file = getFile("image", "image").getFile();

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

	public void imagehandle() {
		render("handleImg.jsp");
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

	/**
	 * 获得专业数据
	 */
	public void getSubject() {
		String para = getPara("q");
		if (StrKit.isBlank(para)) {
			List<Zfxfzb_xsjbxxb> list = Zfxfzb_xsjbxxb.me.findAll();
			renderJson(list);
		} else {
			List<Zfxfzb_xsjbxxb> list = Zfxfzb_xsjbxxb.me.findByArgs(para);
			String jsonString = JsonKit.toJson(list);
			renderJson(jsonString);
		}
	}
	/**
	 * 删除学生申请
	 */
	public void delete_stu() {
		Student_apply.me.update_stu();
	}
}
