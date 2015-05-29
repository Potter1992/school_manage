package com.school.model;

import java.util.List;

import com.jfinal.plugin.activerecord.Model;
/*
 * 审批人
 */
public class Approve_person extends Model<Approve_person> {
	public static final String TableName = "approve_person";
	public static final Approve_person me=new Approve_person();
	public Approve_person findByLogin(String username,String password) {
		String sql = "select * from  "+TableName+"    where a_account= ? && a_password = ? ";
		List<Approve_person> list = Approve_person.me.find(sql, username,
				password);
		if (list.size()!=0) {
			Approve_person app=list.get(0);
			return app;
		}
		return null;
	}
	public List<Approve_person> getCurrentApprove_person(String username,String password) {
		String sql = "select * from  "+TableName+"    where a_account= ? && a_password = ? ";
		List<Approve_person> list = Approve_person.me.find(sql, username,
				password);
		return list;
	}
}
