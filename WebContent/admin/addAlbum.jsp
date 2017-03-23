<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="../css/album/albumall.css" rel="stylesheet" />
</head>
<body>
<form action="../AlbumServlet" id="addAlbum" method="post">
	<input name="op" type="hidden"  value="addAlbum" />	
    <table style="width: 600px;margin: 200px auto;">    
        <tr> <td colspan="2" style="text-align:center;" id="msg">${msg}</td></tr>
        <tr>
            <th>专辑名：</th>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <th>发行时间：</th>
            <td><input id="dd" type="text" name="date" class="easyui-datebox" required> </td>
        </tr>
         <tr>
            <th>发行公司：</th>
            <td><input type="text" name="company" ></td>
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
            	<input type="reset" value="重置" style="margin-left:30px;"/>
            </th>
        </tr>
    </table>
</form>

</body>
</html>