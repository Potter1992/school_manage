package com.school.common;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.render.ViewType;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.school.controller.ApplyController;
import com.school.controller.IndexController;
import com.school.controller.LoginController;
import com.school.controller.ManageController;
import com.school.handler.Handler;
import com.school.model.Apply_approve;
import com.school.model.Approve_person;
import com.school.model.Change;
import com.school.model.Role;
import com.school.model.Role_change;
import com.school.model.Student_apply;
import com.school.model.Xydmb;
import com.school.model.Zfxfzb_xsjbxxb;
import com.school.model.Zydmb;

public class Config extends JFinalConfig {

	@Override
	public void configConstant(Constants me) {
		loadPropertyFile("config.properties");
		me.setDevMode(true);
		me.setBaseViewPath("/WEB-INF/view");
		me.setViewType(ViewType.JSP);
		me.setEncoding("UTF-8");
	}

	@Override
	public void configRoute(Routes me) {
		me.add("index", IndexController.class);
		me.add("apply",ApplyController.class);
		me.add("manage",ManageController.class);
		me.add("login",LoginController.class);

	}

	@Override
	public void configPlugin(Plugins me) {
		C3p0Plugin cPlugin=new C3p0Plugin(getProperty("jdbcUrl"),getProperty("user"),getProperty("password"));
		me.add(cPlugin);
		
		ActiveRecordPlugin aPlugin=new ActiveRecordPlugin("mysql",cPlugin);
		me.add(aPlugin);
		aPlugin.addMapping("apply_approve", Apply_approve.class);//申请审核记录表
		aPlugin.addMapping("change_apply",Change.class);//异动表
		aPlugin.addMapping("role_change",Role_change.class);//角色异动关系表
		aPlugin.addMapping("approve_person", Approve_person.class);//审核人表
		aPlugin.addMapping("role", Role.class);//角色表
		aPlugin.addMapping("student_apply", "s_id",Student_apply.class);//学生申请表
		aPlugin.addMapping("xsjbxxb", Zfxfzb_xsjbxxb.class);//学生基本信息表
		aPlugin.addMapping("zydmb", Zydmb.class);//专业
		aPlugin.addMapping("xydmb", Xydmb.class);//学院
		/*
		//oracle
		ActiveRecordPlugin arp=null;
		String driver=getProperty("oracle.driver");
		String url=getProperty("oracle.url");
		String username=getProperty("oracle.username");
		String password=getProperty("oracle.password");
		DruidPlugin dp=new DruidPlugin(url, username, password, driver);
		me.add(dp);
		arp=new ActiveRecordPlugin(dp);//设置数据库方言
		arp.setDialect(new OracleDialect());
		arp.setContainerFactory(new CaseInsensitiveContainerFactory());//忽略大小写
		me.add(new EhCachePlugin());
		arp.addMapping("zfxfzb_xsjbxxb", "id",Zfxfzb_xsjbxxb.class);
		me.add(arp);*/
		
		
	}

	@Override
	public void configInterceptor(Interceptors me) {
		// TODO Auto-generated method stub

	}

	@Override
	public void configHandler(Handlers me) {
		// TODO Auto-generated method stub
//		me.add(new Handler());
		

	}
	

}
