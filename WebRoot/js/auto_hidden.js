$(document).ready(function(){
	var r_level=$("#r_level").val();
	if(r_level=="院级"||r_level=="处级"||r_level=="管理员"){
		$("#apply").hide();
		$("#process").hide();
	}
	
	if(r_level=="学生"){
		$("#student").hide();
		$("#manage").hide();
	}
	if($("#tab-apply-detail").hide()){
		$("#tab-student-detail").addClass('active');
	}
	
});