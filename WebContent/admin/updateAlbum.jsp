<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>       
    
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
<form action="AlbumServlet" id="updateAlbum" method="post">
	<input name="op" type="hidden"  value="updateAlbum" />
    <table style="width: 600px;margin: 200px auto;">    	 
         <tr><input type="hidden" name="id" value="${al.albumId}"/></tr>
         <tr> <td>${msg}</td></tr> 
        <tr>        	
            <th>专辑名：</th>
            <td><input type="text" name="name" value="${al.albumName}"></td>
        </tr>
        <tr>
            <th>发行时间：</th>
            
            <td><input type="text" name="date" value="${al.releaseTime}"></td>
        </tr>
         <tr>
            <th>发行公司：</th>
            <td><input type="text" name="company" value="${al.releaseCompany }" ></td>
        </tr>
        <tr>
            <th>类型：</th>
            <td>
                <select style="width:100px;" name="type">
                    <option value="1" selected>EP</option>
                    <option value="2">录音室专辑</option>
                    <option value="3">合辑</option>
                    <option value="4">精选辑</option>
                    <option value="5">单曲</option>
                   
                </select>
            </td>
        </tr>
        <tr>
            <th>语种：</th>
            <td>
                <select style="width:100px;" name="language">
                    <option value="1" selected>汉语</option>
                    <option value="2">日语</option>
                    <option value="3">英语</option>
                    <option value="4">韩语</option>
                    <option value="5">德语</option>
                    <option value="6">法语</option>
                    <option value="7">西班牙语</option>
                    <option value="8">葡萄牙语</option>
                    <option value="9">印第安语</option>
                </select>
            </td>
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