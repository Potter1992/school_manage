package com.school.model;

import java.util.List;

import com.jfinal.plugin.activerecord.Model;
/*
 * 审批人
 */
public class Approve_person extends Model<Approve_person> {
	public static final Approve_person me=new Approve_person();
	public List<Approve_person> findByLogin(String username,String password) {
		String sql = "select * from approve_person where a_account= ? && a_password = ? ";
		List<Approve_person> list = Approve_person.me.find(sql, username,
				password);
		return list;
	}
	public List<Approve_person> getCurrentApprove_person(String username,String password) {
		String sql = "select * from approve_person where a_account= ? && a_password = ? ";
		List<Approve_person> list = Approve_person.me.find(sql, username,
				password);
		return list;
	}
}
