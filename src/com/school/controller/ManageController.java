package com.school.controller;

import java.io.File;
import java.util.List;

import com.jfinal.core.Controller;
import com.jfinal.kit.JsonKit;
import com.jfinal.kit.PathKit;
import com.jfinal.upload.MultipartRequest;
import com.jfinal.upload.UploadFile;
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

	public void add_approve() {
		render("add_approve.jsp");
	}

	/**
	 * 渲染审核人页面
	 */
	public void approve() {
		render("approve.jsp");
	}

	/**
	 * 增加审核人
	 */
	public void addApprove() {
		// 获得传过来的数据
		Approve_person approve_person = getModel(Approve_person.class, "app");
		String r_nameString = getPara("r_name");
		int r_id = Role.me.findByname(r_nameString);
		approve_person.set("r_id", r_id);
		approve_person.save();
		index();
	}

	/**
	 * 处理上传图片,返回图片路径
	 */
	public String handleImage(String name) {
		UploadFile file = getFile("app.a_img");
		if (file == null) {
			return null;
		}
		String fileName = file.getFileName();
		
//		String pathString = PathKit.getWebRootPath()
//				+ "/upload/image/approve/"
//				+ name
//				+ fileName.substring(fileName.lastIndexOf("."),
//						fileName.length());
		String pathString = "/upload/image/approve/"
				+ name
				+ fileName.substring(fileName.lastIndexOf("."),
						fileName.length());
		File fi = new File(pathString);
		file.getFile().renameTo(fi);
		// 读取数据库中图片的路径
		return pathString;
	}

	public void manage_student() {
		render("manage_student.jsp");
	}

	// public void handle_approve1() {
	// render("handle_approve.jsp");
	// }

	/**
	 * 修改审核人
	 */
	public void handle_approve() {
		int a_id = getParaToInt();
		Approve_person approve_person = Approve_person.me.findById(a_id);
		int r_id = approve_person.get("r_id");
		approve_person.put("r_name", Role.me.getRNameByID(r_id));
		setAttr("app", approve_person);
		render("handle_approve.jsp");
		// handle_approve1();
	}

	/**
	 * 更新审核人
	 */
	public void editApprove() {
		// 获得传过来的数据
		String image_path = handleImage("1234");
		Approve_person approve_person = getModel(Approve_person.class, "app");
		String r_name = getPara("r_name");
		approve_person.set("a_img", image_path);
		int r_id = Role.me.findByname(r_name);
		approve_person.put("r_id", r_id);
		approve_person.update();
		index();
	}

	/**
	 * 删除审核人
	 */
	public void deleteApprove() {
		// 获得传过来的数据
		int a_id = getParaToInt();
		Approve_person.me.deleteById(a_id);
		index();
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
