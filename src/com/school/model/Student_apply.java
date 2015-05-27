package com.school.model;

import java.util.List;

import com.jfinal.ext.plugin.tablebind.TableBind;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.DbPro;
import com.jfinal.plugin.activerecord.Model;
/*
 * 审批人
 */
//@TableBind(pkName="s_id",tableName="student_apply")
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
	public Student_apply getCurrentStudent(String sno,String sPassword) {
		Student_apply currentStu=findFirst("select * from student_apply where s_no = ? && s_password=?",sno,sPassword );
		return currentStu;
	}
//	public int update_stu() {
//		int i=Db.update("delete from  student_apply where s_no = ?","123456");
//		return i;
//	}
	/**
	 * 根据学号和密码获得学生
	 * @param sno
	 * @param pwd
	 * @return
	 */
	public Student_apply findFirstBySnoAndPwd(String sno,String pwd) {
		return Student_apply.me.findFirst("select * from student_apply where s_no =? &&s_password = ?",sno,pwd);
	}
	/**
	 * 返回所有学生申请的记录
	 */
	public List<Student_apply> findAll() {
		return find("select * from student_apply");
	}
}
