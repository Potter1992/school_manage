package com.school.controller;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Map;

import javax.swing.ImageIcon;

import com.jfinal.core.Controller;
import com.jfinal.kit.FileKit;
import com.school.utils.HandleImage;

/**
 * 当输入完密码时进行验证，学号和密码是否正确，此时需从oral数据库中查询学生的基本信息
 * 
 * @author liulei
 *
 */
public class ApplyController extends Controller {
	/**
	 * 保存提交的表单,将提交的数据保存在数据库中的apply_student表中
	 */
	public void save() {
		Map<String, String[]> map = getParaMap();
		for (String key : map.keySet()) {
			System.out.println(key);
		}
		System.out.println(map);
	}

	/**
	 * 渲染申请页面
	 */
	public void apply_form() {
		render("apply_student.jsp");
	}

	/**
	 * 验证用户输入的学号和密码，当用户输入完学号密码和姓名的时候触发验证
	 */
	public void validate_student() {
		String para_sno=getPara("s_no");
		String para_password=getPara("s_password");
		render("apply_student.jsp");
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
}
