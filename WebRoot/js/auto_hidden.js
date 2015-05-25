$(document).ready(function(){
	var r_level=$("#r_level").val();
	if(r_level=="院级"||r_level=="处级"){
		$("#apply").hide();
		$("#process").hide();
		$("#manage").hide();
	}
	if(r_level=="管理员"){
		$("#student").hide();
		$("#apply").hide();
		$("#process").hide();
		$("#tab-student-detail").hide();
		$("#tab-manage-detail").addClass('active');
	}
	// if(r_level=="学生"){
		// $("#student").hide();
		// $("#manage").hide();
	// }
	if($("#tab-apply-detail").hide()){
		$("#tab-student-detail").addClass('active');
	}
	
});