package com.school.controller;

import java.util.List;
import javax.servlet.http.HttpSession;
import com.jfinal.core.Controller;
import com.school.model.Approve_person;
import com.school.model.Change;
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
		setSessionAttr("stu",
				Student_apply.me.getCurrentStudent(username, password));// 设置当前用户

		Student_apply stulist = getSessionAttr("stu");

		if (stulist != null && !stulist.equals("")) {
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
			String academy_app = app.get("a_academy").toString().trim();
			getStudent_apply(academy_app);// 这里可能用到分页
			setAttr("app", app);
			// 获取学生申请的数据,根据审核人的学院,如果没有学院就全部显示,并且还要根据审核人是否已经审核

			render("login_after_leader.jsp");

		} else {
			login_student();// 判断是否为学生，yes是特定页面
		}
	}

	/**
	 * 获得学生申请的数据,并放到request中,或者根据学院获得学生信息(根据院级的需要,不需要其他学院看见)
	 */
	public void getStudent_apply(String academy) {
		// 如果申请人的所在学院为空的话,则认为此审核人的角色级别在院级以上,故所有的信息可以输出
		boolean nn =academy.trim().equals("无学院");
		if (academy.trim().equals("无学院"))
		{
			List<Student_apply> student_applies = Student_apply.me.findAll();
			for (Student_apply student_apply : student_applies) {
				student_apply.put(
						"c_name",
						Change.me.findNameChangeByIDString(
								student_apply.getInt("c_id")).get("c_name"));
			}
			setAttr("size", student_applies.size());
			setAttr("stulist", student_applies);
		} else {
			List<Student_apply> student_applies = Student_apply.me
					.findByAcademy(academy);
			for (Student_apply student_apply : student_applies) {
				student_apply.put(
						"c_name",
						Change.me.findNameChangeByIDString(
								student_apply.getInt("c_id")).get("c_name"));
			}
			setAttr("size", student_applies.size());
			setAttr("stulist", student_applies);
		}

	}

	/**
	 * 注销重新登录
	 */
	public void unLogin() {
		HttpSession session = getSession();
		session.invalidate();
		render("../index/index.jsp");
	}
}
