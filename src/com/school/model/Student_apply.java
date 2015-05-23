package com.school.model;

import java.util.List;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.DbPro;
import com.jfinal.plugin.activerecord.Model;
/*
 * 审批人
 */
public class Student_apply extends Model<Student_apply> {
	public static final Student_apply me=new Student_apply();
	/**
	 * 通过学号和密码进行登陆
	 * @param username
	 * @param password
	 * @return
	 */
	public List<Student_apply> findByLogin(String username,String password) {
		String sql = "select * from student_apply where s_no= ? && s_password = ? ";
		List<Student_apply> stulist =find(sql, username,
				password);
		
		return stulist;
	}
	/**
	 * 查找学生
	 * @param sno
	 * @param sPassword
	 * @return
	 */
	public List<Student_apply> getCurrentStudent(String sno,String sPassword) {
		List<Student_apply> currentStu=find("select * from student_apply where s_no = ? && s_password=?",sno,sPassword );
		return currentStu;
	}
	public int update_stu() {
		int i=Db.update("delete from  student_apply where s_no = ?","123456");
		return i;
	}
}
