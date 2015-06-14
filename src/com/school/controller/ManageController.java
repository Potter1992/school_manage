package com.school.controller;

import java.io.File;
import java.util.List;

import com.jfinal.core.Controller;
import com.jfinal.kit.JsonKit;
import com.jfinal.kit.PathKit;
import com.jfinal.plugin.activerecord.DbPro;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.upload.MultipartRequest;
import com.jfinal.upload.UploadFile;
import com.school.model.Approve_person;
import com.school.model.Change;
import com.school.model.Role;
import com.school.model.Student_apply;
import com.school.model.Xydmb;

public class ManageController extends Controller {
	/**
	 * 按照分页进行显示
	 */
	public void manage_page() {
		int paraString = getPara("page") == null ? 1 : getParaToInt("page");
		Page<Approve_person> apPage=Approve_person.me.paginate(paraString, 10);
		System.out.println(apPage);
		setAttr("approve_page",apPage );// 从url中获得参数，并将默认值转化为int类型的值.

	}
	/**
	 * 根据c_name获取c_id,添加角色id和顺序
	 */
	public void setRoleAndSort() {
		String c_nameString=getPara("c_name");
		int sort_sum=getParaToInt("sort_sum");
		Change change=Change.me.findIDChangeByName(c_nameString);
		//根据异动类型添加角色和顺序
		int c_id=change.getInt("c_id");
		//选择角色
		List<Role> rList=Role.me.findAll();
		setAttr("rList", rList);
		setAttr("sort_sum", sort_sum);
		//顺序个数,默认1为学生,不容更改
		renderJson();
	}
	/**
	 * 保存角色和异动之间的关系
	 */
	public void saveRoleAndChange() {
		String c_nameString=getPara("c_name");
		Change change=Change.me.findIDChangeByName(c_nameString);
		//根据异动类型添加角色和顺序
		int c_id=change.getInt("c_id");
		String role_nameString=getPara("role_name");
		Role role=Role.me.findByname(role_nameString);
		int r_id=role.getInt("r_id");
		int rc_sort=getParaToInt("rc_sort");
		int sort_sum=getParaToInt("sort_sum");
		Record record=new Record();
		record.set("r_id", r_id);
		record.set("c_id", c_id);
		record.set("rc_sort", rc_sort);
		boolean flag=DbPro.use().save("role_change", record);
		if (flag) {
			renderText("保存成功");
		}else {
			renderText("保存失败");
		}
		
	}

	/**
	 * 验证账号是否重复
	 */
	public void validate_account() {
		String accountString = getPara("account");
		System.out.println(accountString);
		if (Approve_person.me.accountIsExited(accountString)) {
			setAttr("validate_account", "false");
			renderJson();
		} else {
			setAttr("validate_account", "true");
			renderJson();
		}

	}
	/**
	 * 根据异动类型获取对应的角色类型和
	 */
	public void getChange() {
		getApply_Student();
		manage_page();
		getChange_apply();
		render("index.jsp");
	}
	/**
	 * 将审核人的所有信息返回到主页面
	 */
	public void index() {
		getApply_Student();
		manage_page();
		getChange_apply();
		render("index.jsp");
//		redirect("/index");
	}
	/**
	 * 获取异动类型
	 */
	public void getChange_apply() {
		List<Change> list=Change.me.findAll();
		setAttr("change", list);
	}

	/**
	 * 获取学生申请的基本信息
	 */
	public void getApply_Student() {
		List list = Student_apply.me.findByStudent_appliesAndChange();
		setAttr("stu_lists", list);

	}

	/**
	 * 添加审核人页面
	 */
	public void add_approve() {
		render("add_approve.jsp");
	}

	/**
	 * 渲染审核人页面
	 */
	public void approve() {
		render("approve.jsp");
	}

	/**
	 * 增加审核人
	 */
	public void addApprove() {
		// 获得传过来的数据
		String imgString = handleImage();
		Approve_person approve_person = getModel(Approve_person.class, "app");
		approve_person.set("a_img", imgString);
		String r_nameString = getPara("r_name");
		Role role = Role.me.findByname(r_nameString);
		approve_person.set("r_id", role.getInt("r_id"));
		approve_person.set("a_type", role.get("r_level"));
		approve_person.save();
		index();
	}

	/**
	 * 处理上传图片,返回图片路径
	 */
	public String handleImage() {
		String savepath = "/upload/image/approve/";// 定义您的图片路径基于webroot
		UploadFile file = getFile();// 获取前台上传文件
		if (file == null) {
			return null;
		}
		String nameString = getPara("app.a_account");// 自定义名称img_name
		String fileName = file.getFileName();// 获取文件名
		String subStringName = fileName.substring(fileName.lastIndexOf("."),
				fileName.length());// 文件后缀名
		String paString = savepath + nameString + subStringName;// 文件路径
		File fi = new File(PathKit.getWebRootPath() + paString);// 创建新的文件
		file.getFile().renameTo(fi);// 给保存的文件重新命名
		return paString;
	}

	public void manage_student() {
		render("manage_student.jsp");
	}

	/**
	 * 修改审核人
	 */
	public void handle_approve() {
		int a_id = getParaToInt();
		Approve_person approve_person = Approve_person.me.findById(a_id);
		int r_id = approve_person.get("r_id");
		approve_person.put("r_name", Role.me.getRNameByID(r_id));
		setAttr("app", approve_person);
		render("handle_approve.jsp");
	}

	/**
	 * 更新审核人
	 */
	public void editApprove() {

		// 获得传过来的数据
		String imgpathString = handleImage();
		Approve_person approve_person = getModel(Approve_person.class, "app");

		String r_name = getPara("r_name");
		if (imgpathString != null) {
			approve_person.set("a_img", imgpathString);
		}

		Role role = Role.me.findByname(r_name);
		approve_person.set("r_id", role.getInt("r_id"));
		String cc = role.get("r_level");
		approve_person.set("a_type", role.get("r_level"));
		// approve_person.put("a_type", role.get("r_level"));
		approve_person.update();
		index();
	}

	/**
	 * 删除审核人
	 */
	public void deleteApprove() {
		// 获得传过来的数据
		int a_id = getParaToInt();
		Approve_person approve_person=Approve_person.me.findById(a_id);
		String img_pathString=approve_person.get("a_img");
		File file=new File(PathKit.getWebRootPath()+img_pathString);
		if (file.delete()) {
			Approve_person.me.deleteById(a_id);
			//删除记录后删除资源
			redirect("/manage/index");
			// index();
		}else {
			renderText("删除失败");
		}
		
		
	}

	/**
	 * 获取学院
	 */
	public void getAcademy() {
		System.out.println(JsonKit.toJson(Xydmb.me.findAll()));
		renderJson(Xydmb.me.findAll());
	}

	/**
	 * 获取角色类型getR_name
	 */
	public void getR_name() {
		renderJson(Role.me.findAll());
	}
}
