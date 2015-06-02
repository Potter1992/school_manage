package com.school.controller;

import javax.servlet.http.HttpSession;

import com.jfinal.core.Controller;
import com.school.model.Apply_approve;

public class ApproveController extends Controller {

	/**
	 * 进行审核通过后操作
	 */
	public void approveAgree() {
		String snoString = getPara("sno");
		if (Apply_approve.me.agree(snoString)) {
			forwardAction("/login/login_index");
		} else {
			renderText("更新失败");
		}
	}
}
