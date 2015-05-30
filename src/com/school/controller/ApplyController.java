package com.school.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.jfinal.core.Controller;
import com.jfinal.ext.kit.ModelKit;
import com.jfinal.ext.kit.RecordKit;
import com.jfinal.kit.JsonKit;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.DbPro;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.plugin.activerecord.RecordBuilder;
import com.school.model.Change;
import com.school.model.Student_apply;
import com.school.model.Xydmb;
import com.school.model.Zfxfzb_xsjbxxb;
import com.school.model.Zydmb;

/**
 * 当输入完密码时进行验证，学号和密码是否正确，此时需从oral数据库中查询学生的基本信息
 * 
 * @author liulei
 *
 */
public class ApplyController extends Controller {

	/**
	 * 渲染申请页面,点击申请时进行申请学生学号密码验证，并获取学生的信息，初始化申请页面,取出异动类型
	 */
	public void apply_form() {

		List<Change> changess = Change.me.findAll();
		// setAttr("change_data", changess);
		setSessionAttr("change_data", changess);
		render("validate_student.jsp");
	}

	/**
	 * 验证用户输入的学号和密码,获取异动类型的id
	 */
	public void validate_student() {
		String para_sno = getPara("s_no").toString().trim();
		String para_password = getPara("s_password").toString().trim();
		String change_name = getPara("c_name");
		// 根据id获取异动类型的名称
		Change change = Change.me.findIDChangeByName(change_name);

		List<Zfxfzb_xsjbxxb> student = Zfxfzb_xsjbxxb.me.findWithValidate(
				para_sno, para_password);

		if (student != null && student.size() > 0) {
			List<Xydmb> academies = Xydmb.me.findAll();
			setAttr("list_academy", academies);
			setSessionAttr("current_student", student.get(0));
			setAttr("student", getSessionAttr("current_student"));
			setAttr("change", change);
			render("apply_stu.jsp");
		} else {
			setAttr("s_no", para_sno);
			setAttr("msg", "登陆失败,学号或密码不正确");
			render("validate_student.jsp");
		}
	}

	/**
	 * 保存学生提交的表单到数据库
	 */
	public void save_apply() {
		Student_apply student_apply = getModel(Student_apply.class, "stu");

		// 根据获得的专业获得学历

		Record record = ModelKit.toRecord(student_apply);

		if (student_apply != null && !student_apply.equals("")) {
			String zydm_after = Zydmb.me.getZydm(
					student_apply.get("s_after_academy").toString().trim(),
					student_apply.get("s_after_subject").toString().trim());
			String zydm_before = Zydmb.me.getZydm(
					student_apply.get("s_before_academy").toString().trim(),
					student_apply.get("s_before_subject").toString().trim());
			record.set("s_after_subject_no", zydm_after);// 学生异动后专业代码
			record.set("s_before_subject_no", zydm_before);// 学生异动后专业代码
			String education = Zydmb.me.getZydmCC(zydm_after);
			record.set("s_after_education", education);
			if (updateGetIDBySno(student_apply.get("s_no").toString(), record)) {// 如果学号存在就更新,不存在就save
				Student_apply student_apply2 = Student_apply.me
						.findFirstBySnoAndPwd(student_apply.get("s_no")
								.toString(), student_apply.get("s_password")
								.toString());
				setAttr("stu", student_apply2);
				Change change = Change.me
						.findNameChangeByIDString((int) student_apply2
								.get("c_id"));
				setAttr("change", change);
				//保存成功后交给审批人进行处理
				
				forwardAction("/login/login_after_student");
			} else {
				record.set("s_changetime", getCurrentTime().toString());
				if (DbPro.use().save("student_apply", record)) {
					forwardAction("/login/login_after_student");
				} else {
					renderText("保存失败");
				}
			}
		} else {
			renderText("申请信息为空");
		}

		// render("login/login_after_student");
		// renderText("您没有改变任何信息");

	}

	/**
	 * 
	 * 根据学号获得id
	 */
	public boolean updateGetIDBySno(String sno, Record record) {
		Student_apply student_apply = Student_apply.me.findFirst(
				"select * from student_apply where s_no=?", sno);
		if (student_apply != null) {
			record.set("s_id", student_apply.get("s_id"));

			record.set("s_changetime", getCurrentTime().toString());
			DbPro.use().update("student_apply", "s_id", record);
			return true;
		} else {
			return false;
		}

	}

	/**
	 * 获得当前时间
	 */
	public String getCurrentTime() {
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy/MM/dd HH:mm:ss");
		String currentTimedate = dateFormat.format(now);
		return currentTimedate;
	}

	/**
	 * 获得专业数据
	 */
	public void getSubjectbyAcademy() {
		String para = getPara("q");
		
		if (para.equals("无")) {
			String ppString=JsonKit.toJson("无");
			renderJson(ppString);
		}else{
		List<Zydmb> zydmbs = Zydmb.me.findByAcademy(para);
		renderJson(zydmbs);}
	}
	/**
	 * 根据异动类型获得不同的数据,显示要提交的数据
	 */
	public void findByChangeType() {
		String para = getPara("q");
		Change change=Change.me.findIDChangeByName(para);
		
		renderJson(change);
	}
}
