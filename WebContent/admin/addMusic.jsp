<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../Css/default.css"/>
<link rel="stylesheet" type="text/css" href="../jquery-easyui-1.5.1/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="../jquery-easyui-1.5.1/themes/icon.css" />

<script type="text/javascript" src="../jquery-easyui-1.5.1/jquery.min.js"></script>
<script type="text/javascript" src="../jquery-easyui-1.5.1/jquery.easyui.min.js"></script>
<script type="text/javascript" src='../js/outlook.js'></script>
<style>
        th{
            text-align: right;
        }
</style>
</head>
<body>
	<form action="">
    <table style="width: 600px;margin: 200px auto;">
        <tr>
            <th>歌曲名：</th>
            <td><input type="text" required></td>
        </tr>
        <tr>
            <th>歌手名：</th>
            <td><input type="text" required></td>
        </tr>
        <tr>
            <th>专辑名：</th>
            <td><input type="text" ></td>
        </tr>
        <tr>
            <th>发布时间：</th>
            <td><input id="dd" type="text" class="easyui-datebox" required> </td>
        </tr>
        <tr>
            <th>歌曲类型：</th>
            <td>
                <select>
                    <option value="0" selected>--请选择--</option>
                    <option value="1">流行</option>
                    <option value="2">古典</option>
                    <option value="3">爵士</option>
                    <option value="4">乡村</option>
                    <option value="5">嘻哈</option>
                    <option value="6">摇滚</option>
                    <option value="7">轻音乐</option>
                </select>
            </td>
        </tr>
        <tr>
            <th>语种：</th>
            <td>
                <select>
                    <option value="0" selected>--请选择--</option>
                    <option value="1">汉语</option>
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
            <th>存放地址：</th>
            <td><input type="text" required></td>
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