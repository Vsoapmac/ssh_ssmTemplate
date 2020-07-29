<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta http-equiv="Content-Type"
	content="multipart/form-data;charset=utf-8" />
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script type="text/javascript" src="js/jquery-1.11.0.js"></script>
</head>
<script type="text/javascript">
	$(function() {
		var params = '{"text" : 1234}';
		$("#jsontest").submit(function() {
			$.ajax({
				url : "${pageContext.request.contextPath}/json",
				data : params,
				contentType : "application/json;charset=UTF-8",//发送数据的格式
				type : "post",
				dataType : "json",//回调
				success : function(data) {
					alert(data.name);
					alert(data.status);
					return false;
				},
			 error: function(XMLHttpRequest, textStatus, errorThrown) {
                 alert(textStatus);
             }
			});//end $.ajax
			return false;
		});//end $("#jsontest").submit
	});
</script>
<body>
	<form action="${pageContext.request.contextPath}/download"
		method="post">
		<input type="submit" value="下载色图">
	</form>

	<form action="${pageContext.request.contextPath}/pic" method="post"
		enctype="multipart/form-data">
		<c:if test="${pic !=null}">
			<img src="${pageContext.request.contextPath}/img/${pic}" width=100
				height=100 />
			<br />
		</c:if>
		<input type="file" name="picfile"> <input type="submit"
			value="提交">
	</form>

	<form id="jsontest" method="post">
		<input type="submit" value="点击提交">
	</form>
	
</body>
</html>