$(document).ready(function() {
	var r_level = $("#r_level").val();
	if (r_level == "学生") {
		$("#manage").hide();
		$("#manage_hidden").hide();
		$("#tab-manage-detail").hide();
		$("#tab-panel-manage").hide();
	}
	if (r_level == "院级" || r_level == "处级" || r_level == "校级") {
		$("#apply").hide();
		$("#manage_hidden").hide();
		$("#manage").hide();
		$("#tab-panel-manage").hide();
	}
	// if (r_level == "管理员") {
		// $("#student").hide();
		// $("#apply").hide();
		// $("#process").hide();
		// $("#tab-student-detail").hide();
		// $("#tab-process-detail").hide();
		// $("#alert_main").hide();
// 
		// $("#main_manage").removeClass();
		// $("#tab-manage-detail").addClass("active");
		// $("#alert").hide();
	// }

}); 