<%@page import="smg.Vsoapmac.bean.city"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="smg.Vsoapmac.springmvc.Utils.springUtls"%>
<%@page import="smg.Vsoapmac.springmvc.service.cityService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css"
	tppabs="http://cdn.bootcss.com/bootstrap/3.3.4/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="css/dashboard.css"
	tppabs="http://v3.bootcss.com/examples/dashboard/dashboard.css"
	rel="stylesheet">

<script src="js/ie-emulation-modes-warning.js"
	tppabs="http://v3.bootcss.com/assets/js/ie-emulation-modes-warning.js"></script>

<!-- 引入bootstrap主题文件 -->
<link rel="stylesheet" href="css/bootstrap-theme.min.css">

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="js/jquery-1.11.0.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="js/bootstrap.min.js"></script>
</head>
<body>
	<%
		int show = 5;//默认展示5个
		
		cityService service = (cityService) springUtls.getBean("cityServiceImpl");
		String selectPage = request.getParameter("selectPage");
		if (selectPage == null || selectPage=="1") {
			List<city> list = service.findlimit(1, show);
			pageContext.setAttribute("list", list);
		}
	%>
	<table class="table table-striped">
		<tr>
			<td>id</td>
			<td>name</td>
			<td>countryCode</td>
		</tr>
		<c:forEach begin="0" end="${list.size()-1}" var="i">
			<tr>
				<td>${list.get(i).getID()}</td>
				<td>${list.get(i).getName()}</td>
				<td>${list.get(i).getCountryCode()}</td>
			</tr>
		</c:forEach>
	</table>

	<nav>
		<ul class="pagination">
			<c:forEach begin="1" end="${pageSize}" var="i">
				<li><a
					href="${pageContext.request.contextPath}/fenye.action?selectPage=${i}">${i}</a></li>
			</c:forEach>
		</ul>
	</nav>
</body>
</html>