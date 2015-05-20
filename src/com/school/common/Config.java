package com.school.common;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.plugin.ehcache.EhCachePlugin;
import com.jfinal.render.ViewType;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.CaseInsensitiveContainerFactory;
import com.jfinal.plugin.activerecord.dialect.OracleDialect;
import com.school.controller.ApplyController;
import com.school.controller.IndexController;
import com.school.model.Academy;
import com.school.model.Approve_person;
import com.school.model.Change;
import com.school.model.Role;
import com.school.model.Student_apply;
import com.school.model.Zfxfzb_xsjbxxb;

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
		me.add("/", IndexController.class,"index");
		me.add("apply",ApplyController.class);

	}

	@Override
	public void configPlugin(Plugins me) {
		C3p0Plugin cPlugin=new C3p0Plugin(getProperty("jdbcUrl"),getProperty("user"),getProperty("password"));
		me.add(cPlugin);
		
		ActiveRecordPlugin aPlugin=new ActiveRecordPlugin("mysql",cPlugin);
		me.add(aPlugin);
		aPlugin.addMapping("change",Change.class);
		aPlugin.addMapping("academy",Academy.class);
		aPlugin.addMapping("approve_person", Approve_person.class);
		aPlugin.addMapping("role", Role.class);
		aPlugin.addMapping("student_apply", Student_apply.class);
		aPlugin.addMapping("zfxfzb_xsjbxxb", Zfxfzb_xsjbxxb.class);
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

	}
	

}
