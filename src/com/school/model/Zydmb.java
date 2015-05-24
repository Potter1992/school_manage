package com.school.model;

import java.util.List;

import com.jfinal.plugin.activerecord.Model;

public class Zydmb extends Model<Zydmb> {
	public static final Zydmb me = new Zydmb();

	/**
	 * 
	 * @return 专业代码表
	 */
	public List<Zydmb> findAll() {
		
		return find("select * from zydmb");
	}
public List<Zydmb> findByAcademy(String para) {
		Xydmb xydmb=Xydmb.me.find("select * from xydmb where xymc like '%"+para+"%'").get(0);
		return find("select * from zydmb where ssxydm =  ? ",xydmb.get("xydm"));
	}

}
