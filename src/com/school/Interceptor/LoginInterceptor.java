package com.school.Interceptor;

import javax.servlet.http.HttpSession;

import com.jfinal.aop.Interceptor;
import com.jfinal.core.ActionInvocation;

public class LoginInterceptor implements Interceptor {

	@Override
	public void intercept(ActionInvocation ai) {
		
		HttpSession session=ai.getController().getSessionAttr("app_person");
		if (session==null) {
			
			ai.getController().redirect("/index");
		}
		System.out.println("Before action invoking");
		System.out.println("After action invoking");
	}
	

}
