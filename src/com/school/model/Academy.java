package com.school.model;

import java.util.List;

import com.jfinal.plugin.activerecord.Model;

public class Academy extends Model<Academy> {
	public static final Academy me = new Academy();

	/**
	 * 
	 * @return 学院数据
	 */
	public List<Academy> findAll() {

		return find("select * from academy");
	}

	public List<Academy> findByArgs(String para) {
		return Academy.me
				.find("select * from academy where academy_name like '%" + para
						+ "%'");
	}
}
