package com.school.controller;

import com.jfinal.core.Controller;

public class ManageController extends Controller {
public void index() {
	render("manage.jsp");
}
public void manage_student() {
	render("manage_student.jsp");
}

}
