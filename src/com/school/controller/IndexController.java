package com.school.controller;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

import javax.swing.ImageIcon;

import com.jfinal.core.Controller;
import com.jfinal.kit.FileKit;
import com.jfinal.kit.JsonKit;
import com.jfinal.kit.StrKit;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.upload.MultipartRequest;
import com.jfinal.upload.UploadFile;
import com.oreilly.servlet.multipart.Part;
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
	public void login_student() {
		String username = getPara("username").trim();
		String password = getPara("password").trim();
		setSessionAttr("stu_list", Student_apply.me.getCurrentStudent(username, password));//设置当前用户
		List<Student_apply> stulist=getSessionAttr("stu_list");
		
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
		setSessionAttr("app_person", Approve_person.me.getCurrentApprove_person(username, password));
		// 审核人员
		List<Approve_person> list = getSessionAttr("app_person");
		// 判断角色的类型
		if (list.size() != 0) {
			int r_id = 0;
			for (Approve_person app : list) {
				r_id = app.get("r_id");// 获取审批人对象中的r_id角色类型
			}
			Role role = Role.me.findById(r_id);
			String r_name = role.get("r_name");

			if (r_name.trim().equals("学生")) {// 判断角色类型
				render("login_after_leader.jsp");
				// setAttr("blogPage", Blog.dao.paginate(1, 10, "select *",
				// "from blog");
				// Role.me.paginate(pageNumber, pageSize, select,
				// sqlExceptSelect)
			} else {
			}
		} else {
			login_student();// 判断是否为学生，yes是特定页面
		}
	}

	public void test() {
		render("test.jsp");
	}

	/*
	 * 给申请页面传数据
	 */
	/*public void regist() {
		List<Academy> aList = Academy.me.findAll();
		setAttr("list_academy", aList);
		List<Zfxfzb_xsjbxxb> zList = Zfxfzb_xsjbxxb.me.findAll();
		setAttr("list_subject", zList);
		render("apply_student.jsp");
	}*/

	/*
	 * 处理上传的图片
	 */
	public void handleImg() throws Exception {
		// 为每一个用户创建一个文件名以他的学号命名
		File file = getFile("image", "image").getFile();
		
		if (file.getName().endsWith("jpg")) {
			 file.renameTo(new File("upload/image/"+"201201001003"+".jpg"));
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
