package com.school.controller;

import java.util.List;

import com.jfinal.core.Controller;
import com.jfinal.kit.JsonKit;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.school.model.Approve_person;
import com.school.model.Role;
import com.school.model.Xydmb;

public class ManageController extends Controller {
	/**
	 * 将审核人的所有信息返回到主页面
	 */
	public void index() {
		List<Approve_person> approve_persons = Approve_person.me.findAll();
		for (Approve_person approve_person : approve_persons) {
			int r_id = approve_person.getInt("r_id");
			String r_name = Role.me.getRNameByID(r_id);
			approve_person.put("r_name", r_name);
		}
		setAttr("approve", approve_persons);

		render("index.jsp");
	}

	/**
	 * 渲染审核人页面
	 */
	public void approve() {
		render("approve.jsp");
	}

	public void manage_student() {
		render("manage_student.jsp");
	}

	/**
	 * 增加审核人
	 */
	public void addApprove() {
		// 获得传过来的数据
		Approve_person approve_person=getModel(Approve_person.class, "app");
		String r_nameString=getPara("r_name");
		int r_id=Role.me.findByname(r_nameString);
		approve_person.set("r_id", r_id);
		approve_person.save();
		render("../login/login_index");
	}
	/**
	 * 判断审核人账号是否存在
	 */
	public void checkApprove_account() {
		// 获得传过来的数据
		
	}

	/**
	 * 获取学院
	 */
	public void getAcademy() {
		System.out.println(JsonKit.toJson(Xydmb.me.findAll()));
		renderJson(Xydmb.me.findAll());
	}

	/**
	 * 获取角色类型getR_name
	 */
	public void getR_name() {
		renderJson(Role.me.findAll());
	}
}
