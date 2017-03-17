<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<title>添加歌手及简介</title>
<link href="../css/singercss/addSinger.css" rel="stylesheet" />
</head>
<body>
	<form action="">
		<table>
			<tr>
				<th>歌手名</th>
				<td id="singerName"><font face="Courier"><input
						name="singerName" size="35"> </font></td>
			</tr>
			<tr>
				<th>个人简介</th>
				<td><textarea cols="40" rows="10" required>
			</textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" name="confirm"> <input
					type="reset" name="reset"></td>
			</tr>
		</table>
	</form>
</body>
</html>