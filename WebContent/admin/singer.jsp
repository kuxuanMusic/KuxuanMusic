<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String str = request.getScheme() + "://" + request.getServerName()
			+ ":" + request.getServerPort() + request.getContextPath()
			+ "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>操作歌手</title>
<link href="../css/singercss/singerCenter.css" rel="stylesheet" />
<script type="text/javascript" src="../js/singer/singer.js">
	
</script>
<link rel="stylesheet" type="text/css"
	href="../js/themes/default/easyui.css" />
<script type="text/javascript"
	src="../jquery-easyui-1.5.1/themes/icon.css"></script>
<script type="text/javascript"
	src="../jquery-easyui-1.5.1/jquery.min.js"></script>
<script type="text/javascript"
	src="../jquery-easyui-1.5.1/jquery.easyui.min.js"></script>
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
	<div id="pp" class="easyui-pagination"
		style="background: #efefef; border: 1px solid #ccc;"
		pagination:true,//分页显示 fitColumns:true,//自动适应宽度
		autoRowHeight:true,//自动行高度
		data-options="total:<%=request.getAttribute("count")%>,pageSize:10"></div>
</body>
</html>