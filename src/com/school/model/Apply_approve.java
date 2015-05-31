package com.school.model;

import java.util.List;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.DbPro;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Record;

public class Apply_approve extends Model<Apply_approve> {
	/**
	 * 
	 */
	public static final String TableName = "apply_approve";
	public static final Apply_approve me = new Apply_approve();

	/**
	 * 通过学号获得审核申请记录,以便学生查看
	 * 
	 * @param s_no
	 * @return
	 */
	public List<Apply_approve> findByS_no(String s_no) {
		return find("select * from " + TableName + " where s_no = " + s_no);
	}
	/**
	 * 通过学院得到学院的信息,并通过此学院获得记录
	 * 
	 * @param s_academy
	 * @return
	 */
	public List<Apply_approve> findA_academy(String s_academy) {
		List<Student_apply> student_applies=Student_apply.me.findByAcademy(s_academy);
		List<Apply_approve> apps=null;
		for (Student_apply student_apply : student_applies) {
			String sno=student_apply.get("s_no");
			Apply_approve approve=Apply_approve.me.findByS_no(sno).get(0);
			apps.add(approve);
		}
		return apps;
	}
	/**
	 * 查找全部的信息
	 * 
	 * @param s_no
	 * @return
	 */
	public List<Apply_approve> findAll( ) {
		return find("select * from " + TableName );
	}

	/**
	 * 通过record保存申请审核
	 * 
	 * @param record
	 * @return
	 */
	public boolean saveByRecordorUpdate(Record record) {
		String s_noString=record.get("s_no");
		String result=Db.queryStr("select s_no from " + TableName + " where  s_no = ?",
				s_noString) ;
		if (result!=null) {
			if (Db.update(TableName, "s_no", record)) {
				return true;
			} else {
				return false;
			}
		}else {
			if (Db.save(TableName, record)) {
				return true;
			} else {
				return false;
			}
		}

	}
}
