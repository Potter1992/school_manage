function getcomplete_subject(search_input, datasource) {

	$(function() {//点击其他地方提示框隐藏
		var search_input_val=search_input;
		search_input="";
		$(document).bind('click', function() {
			$('#search-suggest').hide();
		});
		$(document).delegate('li', 'click', function() {

			var keyword = $(this).text();
			$(search_input_val).val(keyword);
		});

		$(search_input_val).bind('keyup', function(event) {

			var searchText = $(search_input_val).val();

			$.get(datasource + '?q=' + searchText, function(d) {

				var html = "";
				$.each(d, function(n, value) {//返回的数据d  n为索引
					html += "<li id='" + n + "'>" + d[n].zymc+ '</li>';

				});
				$('#search-result').html(html);
				$('#search-suggest').show().css({
					top : $(search_input_val).offset().top + 35,
					left : $(search_input_val).offset().left,
					position : 'absolute'
				});
				/* 当输入时显示提示框 */
			}, 'json');
		});
	 });
}
function getcomplete_subject1(search_input, datasource) {

	$(function() {//点击其他地方提示框隐藏
		var search_input_val=search_input;
		search_input="";
		$(document).bind('click', function() {
			$('#search-suggest').hide();
		});
		$(document).delegate('li', 'click', function() {

			var keyword = $(this).text();
			$(search_input_val).val(keyword);
		});

		$(search_input_val).bind('keyup', function(event) {

			var searchText = $(search_input_val).val();

			$.get(datasource + '?q=' + searchText, function(d) {

				var html = "";
				$.each(d, function(n, value) {//返回的数据d  n为索引
					html += "<li id='" + n + "'>" + d[n].zymc+ '</li>';

				});
				$('#search-result').html(html);
				$('#search-suggest').show().css({
					top : $(search_input_val).offset().top + 35,
					left : $(search_input_val).offset().left,
					position : 'absolute'
				});
				/* 当输入时显示提示框 */
			}, 'json');
		});
	 });
}
