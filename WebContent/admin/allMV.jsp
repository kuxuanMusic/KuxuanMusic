<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%-- <%
		String str = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
	%>
	<base href="<%=str%>"> --%>
<title>Insert title here</title>
</head>
<body>
<a href="admin/MVServlet">所有mv</a>
<table>
<table>
	<tr>
		
		<th>歌曲</th>
		<th>MV</th>
		<th colspan="2">操作</th>
	</tr>
	<c:forEach items="${map}" varStatus="map">
	<tr>
		<td>${map.musicName }</td>
		<td>${map.address }</td>
		<td>重新上传</td>
		<td>删除</td>
	</tr>
	</c:forEach>
</table>
${msg }
</table>
</body>
</html>