package com.school.controller;

import java.io.File;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.jfinal.core.Controller;
import com.jfinal.kit.FileKit;
import com.jfinal.kit.JsonKit;
import com.jfinal.kit.StrKit;
import com.school.model.Academy;
import com.school.model.Approve_person;
import com.school.model.Role;
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

	/*
	 * 登录验证--学生
	 */
//	@Before (LoginInterceptor.class)
	public void login_student() {
		String username = getPara("username").trim();
		String password = getPara("password").trim();
		setSessionAttr("stu_list",
				Student_apply.me.getCurrentStudent(username, password));// 设置当前用户
		List<Student_apply> stulist = getSessionAttr("stu_list");

		if (stulist.size() != 0) {
			render("login_after_student.jsp");
		} else {
			setAttr("msg", "帐号或密码错误或者你没有资格访问");
			setAttr("username", username);
			render("index.jsp");
		}
	}

	/*
	 * 登录验证--审核人员
	 */
	
	public void login() {
		String username = getPara("username").trim();
		String password = getPara("password").trim();
		
		Approve_person approve_person = Approve_person.me.findByLogin(username,
				password);

		// 判断角色的类型
		if (approve_person != null && !approve_person.equals("")) {
			setSessionAttr("app_person", approve_person);
			// 审核人员
			Approve_person app = getSessionAttr("app_person");
			int r_id = app.get("r_id");
			// 根据角色id取得角色类型
			String role=Role.me.getLevelByID(r_id);
			if (role == null && role.equals("")) {
				setAttr("msg", "您没有相应的权限来访问此页面");
			} else {
				setSessionAttr("r_level", role);
			}
			render("login_after_leader.jsp");

		} else {
			login_student();// 判断是否为学生，yes是特定页面
		}
	}

	public void login_after_student() {
		render("login_after_student.jsp");
	}
	/**
	 * 注销重新登录
	 */
	public void unLogin() {
		HttpSession session=getSession();
		Enumeration<String> attrs=session.getAttributeNames();
		while (attrs.hasMoreElements()) {
			String string = (String) attrs.nextElement();
			session.removeAttribute(string);
		}
		render("index.jsp");
		
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
}
