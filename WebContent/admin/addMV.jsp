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
<form action="MVServlet?op=addMV" method="post">
    <table style="width: 600px;margin: 200px auto;">
        <tr>
            <th>歌曲名：</th>
            <td><input type="text" name="musicName" id="musicName" required></td>
        </tr>
          <tr>
            <th>歌手名：</th>
            <td><input type="text" name="singerName" id=""singerName"" required></td>
        </tr>
        <tr>
            <th>存放地址：</th>
            <td><input type="text" name="mvAddress" required></td>
        </tr>
        <tr>
            <th colspan="2" style="text-align:center;">
            	<br><input type="submit" value="提交">
            	<input type="reset" value="重置">
            </th>
        </tr>
    </table>
</form>

</body>
</html>