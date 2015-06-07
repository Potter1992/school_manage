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
		String imgString = handleImage();
		Approve_person approve_person = getModel(Approve_person.class, "app");
		approve_person.set("a_img", imgString);
		String r_nameString = getPara("r_name");
		Role role = Role.me.findByname(r_nameString);
		approve_person.set("r_id", role.getInt("r_id"));
		approve_person.set("a_type", role.get("r_level"));
		approve_person.save();
		index();
	}

	/**
	 * 处理上传图片,返回图片路径
	 */
	public String handleImage() {
		String savepath = "/upload/image/approve/";// 定义您的图片路径基于webroot
		UploadFile file = getFile();// 获取前台上传文件
		if (file == null) {
			return null;
		}
		String nameString = getPara("app.a_account");// 自定义名称img_name
		String fileName = file.getFileName();// 获取文件名
		String subStringName = fileName.substring(fileName.lastIndexOf("."),
				fileName.length());// 文件后缀名
		String paString = savepath + nameString + subStringName;// 文件路径
		File fi = new File(PathKit.getWebRootPath() + paString);// 创建新的文件
		file.getFile().renameTo(fi);// 给保存的文件重新命名
		return paString;
	}

	public void manage_student() {
		render("manage_student.jsp");
	}

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
	}

	/**
	 * 更新审核人
	 */
	public void editApprove() {

		// 获得传过来的数据
		String imgpathString = handleImage();
		Approve_person approve_person = getModel(Approve_person.class, "app");

		String r_name = getPara("r_name");
		if (imgpathString != null) {
			approve_person.set("a_img", imgpathString);
		}

		Role role = Role.me.findByname(r_name);
		approve_person.set("r_id", role.getInt("r_id"));
		String cc=role.get("r_level");
		approve_person.set("a_type", role.get("r_level"));
//		approve_person.put("a_type", role.get("r_level"));
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
