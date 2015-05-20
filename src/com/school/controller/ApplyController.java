package com.school.controller;

import java.util.Map;

import com.jfinal.core.Controller;
/**
 * 当输入完密码时进行验证，学号和密码是否正确，此时需从oral数据库中查询学生的基本信息
 * @author liulei
 *
 */
public class ApplyController extends Controller {
	/**
	 * 保存提交的表单,将提交的数据保存在数据库中的apply_student表中
	 */
	public void save() {
		Map<String, String[]> map=getParaMap();
		System.out.println(map);
	}
	/**
	 * 渲染申请页面
	 */
	public void apply_form() {
		render("apply_student.jsp");
	}
	/**
	 * 验证用户输入的学号和密码
	 */
	public void validate_student() {
		
	}
}
