<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP 'getdata.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script src="http://code.jquery.com/jquery-1.8.2.js"></script>

<script type="text/javascript">
function getcomplete(search_input,datasource,showtext){
	


$(function() {//点击其他地方提示框隐藏
	$(document).bind('click',function(){
		$('#search-suggest').hide();
	});
$(document).delegate('li','click',function(){
	
var keyword=$(this).text();
	$(search_input).val(keyword);
});

$(search_input).bind('keyup',function(event){
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

var searchText = $(search_input).val();	

$.get(datasource+'?q='+searchText,function(d){
	
var html="";
	$.each(d,function(n,value) {//返回的数据d  n为索引
	//	var d=d[n]//取出数据
		html+="<li id='"+n+"'>"+d[n].academy_name+'</li>';
	});
	$('#search-result').html(html);
	$('#search-suggest').show().css({
		//	top:$('#search-form').offset().top+$('#search-form').height(),
			top:$(search_input).offset().top+35,
			left:$(search_input).offset().left,
			position:'absolute'
			});/* 当输入时显示提示框 */	
},'json')	
});
});
}


</script>
<style type="text/css">
#search-suggest {
	width: 388px;
	background-color: #fff;
	border: 1px solid #999;
}

#search-suggest ul {
	list-style: none;
	margin: 0;
	padding: 0;
}

#search-suggest ul li {
	padding: 3px;
	font-size: 14px;
	line-height: 25px;
	cursor: pointer;
}
#search-suggest ul li:hover{
text-decoration: underline;
background-color: #e5e5e5;
}
</style>
</head>

<body>
<form action="" id="search-form">
	<input type="text" id="search_input" 
		name="academy_name" onclick="getcomplete('#search_input','getAcademy','academy_name');"/>
		
		<!--下面是显示的内容  -->
	<div id="search-suggest"
		style="display: none;"><!-- display：none 让其不显示 -->
		<ul id="search-result">
			<li >jieguo1</li>
		</ul>
	</div>
	</form>
</body>
</html>
