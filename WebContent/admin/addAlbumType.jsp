<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
	String str = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>
<base href="<%=str%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/album/albumall.css" rel="stylesheet" />          
</head>
<body>
<form action="AlbumServlet" id="addAlbumType" method="post">
	<input name="op" type="hidden"  value="addAlbumType" />
    <table style="width: 1000px;margin: 200px auto;">
        <tr> <td colspan="2" style="text-align:center;" id="msg">${msg}</td></tr>  
        <tr>
            <th>新增类型名称：</th>
            <td><input type="text"  name="type"></td>
        </tr>               
        <tr>
            <th colspan="2" style="text-align:center;">
            	<br><input type="submit" value="提交" style="margin-left:-60px;"/>           
            </th>
        </tr>
    </table>
</form>

</body>
</html>