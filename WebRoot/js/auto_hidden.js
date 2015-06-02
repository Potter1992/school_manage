$(document).ready(function(){
	var r_level=$("#r_level").val();
	if(r_level=="学生"){
		$("#manage").hide();
		$("#tab-manage-detail").hide();
	}
	if(r_level=="院级"||r_level=="处级"||r_level=="校级"){
		$("#apply").hide();
		$("#manage").hide();
	}
	if(r_level=="管理员"){
		$("#student").hide();
		$("#apply").hide();
		$("#process").hide();
		$("#tab-student-detail").hide();
		$("#tab-process-detail").hide();
		$("#tab-manage-detail").addClass('active');
	}
	
});