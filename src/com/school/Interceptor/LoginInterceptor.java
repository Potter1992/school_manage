package com.school.Interceptor;

import javax.servlet.http.HttpSession;

import com.jfinal.aop.Interceptor;
import com.jfinal.core.ActionInvocation;

public class LoginInterceptor implements Interceptor {

	@Override
	public void intercept(ActionInvocation ai) {

		HttpSession session_app = ai.getController().getSessionAttr(
				"app_person");
		
		HttpSession session_stu = ai.getController().getSessionAttr("stu_list");
	
		if (session_app != null) {
			session_app.removeAttribute("app_person");
		} else if (session_stu != null) {
			session_stu.removeAttribute("stu_list");
			ai.getController().redirect("/index/index");
		}
		System.out.println("Before action invoking");
		System.out.println("After action invoking");
	}

}
