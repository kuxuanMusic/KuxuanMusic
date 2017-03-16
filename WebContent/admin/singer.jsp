<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>操作歌手</title>
<link href="css/singerCenter.css" rel="stylesheet">
<style>
#userinfo {
	border: 1px solid #9aa8ff;
	border-collapse: collapse;
}

#profile {
	width: 1100px;
}

#userinfo td {
	border: 1px solid #9aa8ff;
	padding: 2px;
}

#userinfo thead {
	text-align: center;
	background-color: #E0ECFF;
}

#userinfo tbody tr:hover {
	background-color: #D4D4D4;
}

#userinfo tbody a:LINK, a:VISITED {
	font-family: "黑体";
	color: #727272;
	text-decoration: none;
}

#userinfo tbody a:HOVER {
	color: #400040;
	text-decoration: underline;
}
</style>

<script type="text/javascript">
	function deleteSinger(singerId) {
		var bool = confirm("确认删除");
		if (bool) {
			// 删除用户		
			location.href = "SingerServlet?op=deleteSinger&singerId="
					+ singerId;
		}
	}
</script>

</head>
<body>
	<table id="userinfo">
		<thead>
			<tr>
				<th>歌手名</th>
				<th>个人简介</th>
				<th colspan="2">操作选项</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${singer}" var="singer">
				<tr>
					<input type="hidden" name="op" value="login" />
					<input type="hidden" name="id" value="${singer.singerId}" />
					<td>${singer.singerName }</td>
					<td id="profile">${singer.profile }</td>
					<td colspan="2"><a
						href="javascript:changeSinger(${singer.singerId})">修改</a> <a
						href="javascript:deleteSinger(${singer.singerId})">删除</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>