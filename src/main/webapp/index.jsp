<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- <c:forEach begin="0" end="${list.size()-1}"  var="i">
	<span>${list.get(i).getName()}</span><br/>
	<span>${list.get(i).getCountryCode()}</span><br/>
</c:forEach> --%>
	<form action="${pageContext.request.contextPath }/updates.action"
		method="post">
		<table width="100%" border=1>
			<tr>
				<td><input type="checkbox" name="ids" value=""></td>
				<td>名称</td>
				<td>城市代码</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${list}" var="i" varStatus="s">
				<tr>
					<td><input type="checkbox" name="ids" value="${i.ID }"></td>
					<td><input type="text" name="list[${s.index}].name"
						value="${i.name }"></td>
					<td><input type="text" name="list[${s.index}].countryCode"
						value="${i.countryCode }"></td>
					<td><a
						href="${pageContext.request.contextPath }/itemEdit.action?id=${item.id}">修改</a></td>
				</tr>
			</c:forEach>
		</table>
		<input type="submit" value="删除"> <input type="submit"
			value="修改">
	</form>
</body>
</html>