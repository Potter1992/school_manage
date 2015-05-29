package com.school.model;

import java.util.List;

import com.jfinal.plugin.activerecord.Model;

public class Xydmb extends Model<Xydmb> {
	public static final String TableName ="xydmb";
	public static final Xydmb me = new Xydmb();

	/**
	 * 
	 * @return 专业代码表
	 */
	public List<Xydmb> findAll() {
		
		return find("select * from xydmb");
	}
	/**
	 * 
	 * 通过学院名称获得代码
	 */
	public String findByAcademyName(String name) {
		Xydmb xydmb=findFirst("select * from "+TableName+"where xymc = ?", name);
		return xydmb.get("xydm");
	}

}
