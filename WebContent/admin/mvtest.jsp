<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%
		String str = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
	%>
	<base href="<%=str%>">
<title>Insert title here</title>
</head>
<body>

<form action="MVServlet?op=getMVBySingerName">
<input type="text" name="singerName" id = "singerName">
<input type = "submit" value="根据歌手名查歌手所有mv">
</form>
</body>
</html>