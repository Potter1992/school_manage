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
}
