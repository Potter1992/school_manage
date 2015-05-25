package com.school.model;

import java.util.List;

import com.jfinal.plugin.activerecord.Model;

public class Change extends Model<Change> {
	public static final Change me = new Change();

	/**
	 * 
	 * @return 异动类型
	 */
	public List<Change> findAll() {
		
		return find("select * from change_apply");
	}

	/**
	 * 根据异动类型名称查找c_id
	 */
	public Change findIDChangeByName(String c_name) {
		Change change = findFirst("select * from change_apply where c_name = ?",c_name);
		return change;
	}
	/**
	 * 根据异动类型名称查找c_name
	 */
	public Change findNameChangeByIDString(int  c_id) {
		Change change = findFirst("select * from change_apply where c_id = ?",c_id);
		return change;
	}
}
