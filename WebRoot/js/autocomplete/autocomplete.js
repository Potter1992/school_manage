	$(function() {//点击其他地方提示框隐藏
			$(document).bind('click',function(){
				$('#search-suggest').hide();
			});
		$(document).delegate('li','click',function(){
			
		var keyword=$(this).text();
			$("#search_input").val(keyword);
		});
		
		$('#search_input').bind('keyup',function(event){
		// if(event.keyCode == 38){
		// //上键
		// alert("按了上键 !")
		// }else if (event.keyCode ==40){
		// //下键#search-suggest ul li:hover{
		// /* text-decoration: underline;
		// background-color: #e5e5e5;
		// }*/
		// //获取id的值进行高亮
		// alert("按了下键!")
		// }

		var searchText = $('#search_input').
val();	
		
		$.get('getAcademy?q='+searchText,function(d){
			
		var html="";
			$.each(d,function(n,value) {//返回的数据d  n为索引
			//	var d=d[n]//取出数据
				html+="<li id='"+n+"'>"+d[n].academy_name+'</li>';
			});
			$('#search-result').html(html);
			$('#search-suggest').show().css({
				//	top:$('#search-form').offset().top+$('#search-form').height(),
					top:$('#search_input').offset().top+35,
					left:$('#search_input').offset().left,
					position:'absolute'
					});/* 当输入时显示提示框 */	
		},'json')	
		});
		});
		
		
	