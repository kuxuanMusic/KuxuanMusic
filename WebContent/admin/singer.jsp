<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%
	String str = request.getScheme() + "://" + request.getServerName()
			+ ":" + request.getServerPort() + request.getContextPath()
			+ "/";
%>
<base href="<%=str%>">
<title>操作歌手</title>
<link rel='icon' href='images/music.ico ' type='image/x-ico'/>
<link href="css/singercss/singerCenter.css" rel="stylesheet" />
<script type="text/javascript" src="js/singer/singer.js">
	
</script>
</head>
<body>
	<table id="SingerInfo">
		<thead>
			<tr style="text-align: center; font-family: 黑体">
				<th>歌手名</th>
				<th>个人简介</th>
				<th colspan="2">操作选项</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${pm.list}" var="singer">
				<tr>
					<input type="hidden" name="id" value="${singer.singerId}" />
					<td id="name">${singer.singerName }</td>
					<td id="profile">${singer.profile }</td>
					<td colspan="2" id="contorl"><a
						href="javascript:changeSinger(${singer.singerId})" target="_blank">修改</a>
						<a href="javascript:deleteSinger(${singer.singerId})">删除</a></td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="4" id="page"><c:if test="${pm.pageNo == 1 }">
    				首页</c:if> <c:if test="${pm.pageNo != 1 }">
						<a href="javascript:toPage(${pm.pageFirst})">首页</a>
					</c:if> <a href="javascript:toPage(${pm.pagePre})">上一页</a> <a
					href="javascript:toPage(${pm.pageNext})">下一页</a> <c:if
						test="${pm.pageNo == pm.pageLast }">
				尾页</c:if> <c:if test="${pm.pageNo != pm.pageLast}">
						<a href="javascript:toPage(${pm.pageLast})">尾页</a>
					</c:if> ${pm.pageNo}/${pm.pageLast} 共${pm.count}条数据 跳转到<input type="text"
					name="pageNo" value="${pm.pageNo}" id="pageNo"
					onkeyup="changePageNo(event)" />页 每页<input type="text"
					name="pageSize" value="${pm.pageSize}" id="pageSize"
					onkeyup="changePageNo(event)"/>条数据</td>
			<tr>
		</tfoot>
	</table>
</body>
</html>