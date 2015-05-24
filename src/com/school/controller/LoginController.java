package com.school.controller;

import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.school.Interceptor.LoginInterceptor;
import com.school.model.Approve_person;
import com.school.model.Role;
import com.school.model.Student_apply;

public class LoginController extends Controller {
	public void login_after_student() {
		render("login_after_student.jsp");
	}
	
	
	
	/**
	 * 检测用户是否登陆
	 */
	public void login_validate() {
		HttpSession session = getSession();
		session.removeAttribute("stu_list");
		;
		session.removeAttribute("app_person");
		render("../index/index.jsp");
	}

	/*
	 * 登录验证--学生
	 */
	// @Before (LoginInterceptor.class)
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
			render("../index/index.jsp");
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
			String role = Role.me.getLevelByID(r_id);
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

	/**
	 * 注销重新登录
	 */
	public void unLogin() {
		HttpSession session = getSession();
		Enumeration<String> attrs = session.getAttributeNames();
		while (attrs.hasMoreElements()) {
			String string = (String) attrs.nextElement();
			session.removeAttribute(string);
		}
		render("index.jsp");
	}
}
