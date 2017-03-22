<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String str = request.getScheme() + "://" + request.getServerName()
			+ ":" + request.getServerPort() + request.getContextPath()
			+ "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加歌手及简介</title>
<link rel='icon' href='../images/music.ico ' type='image/x-ico'/>
<link href="../css/singercss/addSinger.css" rel="stylesheet" />
</head>
<body>
	<form action="SingerServlet?op=insertSinger" method="post">
		<table>
			<tr>
				<th>歌手名</th>
				<td><font face="Courier"> <input id="singerName"
						name="singerName" size="38.5" placeholder="请填写歌手的名字" required>
				</font></td>
			</tr>
			<tr>
				<th>个人简介</th>
				<td><textarea name="singerProfile" cols="60" rows="15"
						placeholder="请填写歌手的相关简介...." required></textarea></td>
			</tr>
			<tr>
				<td colspan="2"><span style="color: red">${msg}</span></td>
			</tr>
			<tr>
				<td colspan="2" id="sub"><input type="submit" name="confirm"
					value="提交">&nbsp;&nbsp;&nbsp; <input type="reset"
					name="reset" value="重置"></td>
			</tr>
		</table>
	</form>
</body>
</html>