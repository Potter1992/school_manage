function getcomplete(input, datasource) {
	$(function() {//点击其他地方提示框隐藏
		$(document).bind('click', function() {
			$('#search-suggest').hide();
		});
		$(document).delegate('li', 'click', function() {
			var keyword = $(this).text();
			$(input).val(keyword);
		});
	});
	$(input).bind('keyup', function(event) {
		var searchText = $(this).val();
		$.get(datasource + '?q=' + searchText, function(d) {
			var html = "";
			$.each(d, function(n, value) {//返回的数据d  n为索引
				html += "<li id='" + n + "'>" + d[n].academy_name + '</li>';
			});
			$('#search-result').html(html);
			$('#search-suggest').show().css({
				top : $(this).offset().top + 35,
				left : $(this).offset().left,
				position : 'absolute'
			});
			/* 当输入时显示提示框 */
		}, 'json');
	});
}
function getcomplete1(input, datasource) {
	$(function() {//点击其他地方提示框隐藏
		$(document).bind('click', function() {
			$('#search-suggest').hide();
		});
		$(document).delegate('li', 'click', function() {
			var keyword = $(this).text();
			$(input).val(keyword);
		});
	});
	$(input).bind('keyup', function(event) {
		var searchText = $(this).val();
		$.get(datasource + '?q=' + searchText, function(d) {
			var html = "";
			$.each(d, function(n, value) {//返回的数据d  n为索引
				html += "<li id='" + n + "'>" + d[n].academy_name + '</li>';
			});
			$('#search-result').html(html);
			$('#search-suggest').show().css({
				top : $(this).offset().top + 35,
				left : $(this).offset().left,
				position : 'absolute'
			});
			/* 当输入时显示提示框 */
		}, 'json');
	});
}
