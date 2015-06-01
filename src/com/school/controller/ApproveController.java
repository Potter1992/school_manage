package com.school.controller;

import javax.servlet.http.HttpSession;

import com.jfinal.core.Controller;

public class ApproveController extends Controller{

	/**
	 * 进行审核通过后操作
	 */
	public void approveAgree() {
		HttpSession session = getSession();
		session.invalidate();
		renderJson();
	}
}
