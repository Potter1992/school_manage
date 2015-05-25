//admin.js
$(document).ready(function() {
		var academy = $("#s_after_academy").val();
		$.post("getSubjectbyAcademy", {
			q : academy
		}, function(data) {
			var html = "";
			for ( var i in data) {
				html += "<option>" + data[i].zymc + "</option>";
			}
			$("#s_after_subject").html(html);
		});
		$("#s_after_academy").change(function() {
			var academy = $("#s_after_academy").val();
			$.post("getSubjectbyAcademy", {
				q : academy
			}, function(data) {
				var html = "";
				for ( var i in data) {
					html += "<option>" + data[i].zymc + "</option>";
				}
				$("#s_after_subject").html(html);
			});
		});
	});