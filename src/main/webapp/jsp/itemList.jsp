<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询商品列表</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/shopServlet"
		method="post">
		查询条件：
		<table width="100%" border=1>
			<tr>
				<td><input type="submit" value="查询" /></td>
			</tr>
		</table>
		商品列表：
		<table width="100%" border=1>
			<tr>
				<td>商品名称</td>
				<td>商品价格</td>
				<td>生产日期</td>
				<td>商品描述</td>
				<td>操作</td>
			</tr>
			<c:forEach begin="0" end="${list.size()-1}" var="item">
				<tr>
					<td>${list.get(item).name }</td>
					<td>${list.get(item).price }</td>
					<td><fmt:formatDate value="${list.get(item).createtime}"
							pattern="yyyy-MM-dd HH:mm:ss" /></td>
					<td>${list.get(item).detail }</td>
				</tr>
			</c:forEach>

		</table>
	</form>
</body>

</html>