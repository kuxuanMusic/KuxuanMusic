<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<title>修改歌手信息</title>
<link rel='icon' href='images/music.ico ' type='image/x-ico'/>
<link href="css/singercss/addSinger.css" rel="stylesheet" />
</head>
<body>
	<form action="admin/SingerServlet?op=updateSinger" method="post">
		<table>
			<tr>
				<th>歌手名</th>
				<input type="hidden" name="id" value="${list[0].singerId}" />
				<td><font face="Courier"> <input type="text"
						style="color: #838B8B" id="singerName" name="singerName"
						size="38.5" value="${list[0].singerName}" required
						readonly="readonly">
				</font></td>
			</tr>
			<tr>
				<th>个人简介</th>
				<td><textarea id="singerProfile" name="singerProfile" cols="60"
						rows="15">${list[0].profile}</textarea></td>
			</tr>
			<%-- 	<tr>
				<td colspan="2"><span style="color: red">${msg}</span></td>
			</tr> --%>
			<tr>
				<td colspan="2" id="sub"><input type="submit" name="confirm"
					value="保存">&nbsp;&nbsp;&nbsp; <input
					type="button" name="cancel" value="取消"
					onClick="javascript:history.go(-1);"></td>
			</tr>
		</table>
	</form>
</body>
</html>