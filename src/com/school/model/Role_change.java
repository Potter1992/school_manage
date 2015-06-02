package com.school.model;

import java.util.List;

import com.jfinal.plugin.activerecord.DbPro;
import com.jfinal.plugin.activerecord.Model;

public class Role_change extends Model<Role_change> {
	/**
	 * 角色异动关系表
	 */
	public static final String TableName = "role_change";
	public static final Role_change me = new Role_change();
	
	public List<Role_change> findByC_id(int c_id) {
		List<Role_change> list = find("select * from " + TableName
				+ " where c_id = ?", c_id);
		if (list.size()==0) {
			return null;
		}
		return list;
	}
	public List<Role_change> findByR_id(int r_id) {
		List<Role_change> list = find("select * from " + TableName
				+ " where r_id = ?", r_id);
		if (list.size()==0) {
			return null;
		}
		return list;
	}
}
