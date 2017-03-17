<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%
	String str = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
%>
<base href="<%=str%>">
<title>用户管理</title>
<link rel="stylesheet" type="text/css"
	href="jquery-easyui-1.4.5/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="jquery-easyui-1.4.5/themes/icon.css">
<script type="text/javascript"
	src="jquery-easyui-1.4.5/jquery.min.js"></script>
<script type="text/javascript"
	src="jquery-easyui-1.4.5/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="jquery-easyui-1.4.5/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript"
	src="js/common.js"></script>
<script type="text/javascript">
	var noticeauthor = '${adminUser.adminname}';
	var url;
	//关键字查询
	function searchSaleChance() {
		$("#dg").datagrid('load', {
			"noticeid" : $("#s_noticeid").val(),
			"noticetype" : $("#s_noticetype").combobox("getValue"),
			"noticetitle" : $("#s_noticetitle").val(),
			"noticeauthor" : $("#s_noticeauthor").val(),
		});
	}

	//添加
	function openSaleChanceAddDialog() {
		$("#dlg").dialog("open").dialog("setTitle", "添加公告信息");
		$("#createMan").val('${currentUser.trueName}');
		$("#noticetime").val(getCurrentDateTime());
		$("#noticeauthor").val(noticeauthor);
		url = "Notice/save.do";
	}

	//修改
	function openSaleChanceModifyDialog() {
		var selectedRows = $("#dg").datagrid("getSelections");
		if (selectedRows.length != 1) {
			$.messager.alert("系统提示", "请选择一条要编辑的数据！");
			return;
		}
		var row = selectedRows[0];
		$("#dlg").dialog("open").dialog("setTitle", "编辑公告信息");
		$("#fm").form("load", row);
		url = "Notice/save.do?noticeid="
				+ row.noticeid;
	}

	//保存
	function saveSaleChance() {
		$("#fm").form("submit", {
			url : url,
			onSubmit : function() {
				return $(this).form("validate");
			},
			success : function(result) {
				var result = eval('(' + result + ')');
				if (result.success) {
					$.messager.alert("系统提示", "保存成功！");
					resetValue();
					$("#dlg").dialog("close");
					$("#dg").datagrid("reload");
				} else {
					$.messager.alert("系统提示", "保存失败！");
					return;
				}
			}
		});
	}

	function resetValue() {
		$("#noticeid").val("");
		$("#noticetype").val("");
		$("#noticetitle").val("");
		$("#noticeauthor").val("");
		$("#noticecontent").val("");
		$("#noticetime").val("");
	}

	//关闭
	function closeSaleChanceDialog() {
		$("#dlg").dialog("close");
		resetValue();
	}
</script>

<title>Insert title here</title>
</head>
<body style="margin: 1px">
	<table id="dg" title="公告管理" class="easyui-datagrid" fitColumns="true"
		pagination="true" rownumbers="true"
		url="Notice/list.do" fit="true"
		toolbar="#tb">
		<thead>
			<tr>
				<th field="cb" checkbox="true" align="center"></th>
				<th field="noticeid" width="5%" align="center">编号</th>
				<th field="noticetype" width="10%" align="center">公告类型</th>
				<th field="noticetitle" width="15%" align="center">公告标题</th>
				<th field="noticeauthor" width="10%" align="center">发布人</th>
				<th field="noticecontent" width="40%" align="center">发布内容</th>
				<th field="noticetime" width="15%" align="center">发布时间</th>
			</tr>
		</thead>
	</table>
	<div id="tb">
		<div>
			<a href="javascript:openSaleChanceAddDialog()"
				class="easyui-linkbutton" iconCls="icon-add" plain="true">创建</a> <a
				href="javascript:openSaleChanceModifyDialog()"
				class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>
		</div>
		<div>
			&nbsp;公告编号：&nbsp;<input type="text" id="s_noticeid" size="20"
				onkeydown="if(event.keyCode==13) searchSaleChance()" />
			&nbsp;公告类型：&nbsp;
			<!-- <input type="text" id="s_noticetype" size="20"
				onkeydown="if(event.keyCode==13) searchSaleChance()" /> -->
			<select class="easyui-combobox" id="s_noticetype" editable="false"
				panelHeight="auto">
				<option value="">请选择...</option>
				<option value="新闻">新闻</option>
				<option value="通知">通知</option>
			</select> &nbsp;公告标题：&nbsp;<input type="text" id="s_noticetitle" size="20"
				onkeydown="if(event.keyCode==13) searchSaleChance()" />
			&nbsp;发布人：&nbsp;<input type="text" id="s_noticeauthor" size="20"
				onkeydown="if(event.keyCode==13) searchSaleChance()" /> <a
				href="javascript:searchSaleChance()" class="easyui-linkbutton"
				iconCls="icon-search" plain="true">搜索</a>
		</div>
	</div>

	<div id="dlg" class="easyui-dialog"
		style="width: 500px; height: 450px; padding: 10px 20px" closed="true"
		buttons="#dlg-buttons">

		<form id="fm" method="post">
			<table cellspacing="8px">
				<tr>
					<td>带<font color="red">*</font>为必填项
					</td>
				</tr>
				<tr>
					<td><font color="red">*</font>公告类型</td>
					<td><select class="easyui-combobox" id="noticetype"
						editable="false" panelHeight="auto" name="noticetype">
							<option value="新闻">新闻</option>
							<option value="通知">通知</option>
					</select></td>
				</tr>
				<tr>
					<td><font color="red">*</font>公告标题</td>
					<td><input type="text" id="noticetitle" name="noticetitle"
						class="easyui-validatebox" required="true" /></td>

				</tr>
				<tr hidden="true">
					<td><font color="red">*</font>发布人</td>
					<td><input type="text" id="noticeauthor" name="noticeauthor" /></td>
				</tr>
				<tr>
					<td><font color="red">*</font>发布内容</td>
					<td colspan="4"><textarea id="noticecontent"
							name="noticecontent" style="width: 300px; height: 100px;"
							class="easyui-validatebox" required="true"></textarea></td>
				</tr>
				<tr>
					<td><font color="red">*</font>发布时间</td>
					<td><input type="datetime" id="noticetime" name="noticetime"
						class="easyui-validatebox" />
				</tr>
			</table>
		</form>
	</div>

	<div id="dlg-buttons">
		<a href="javascript:saveSaleChance()" class="easyui-linkbutton"
			iconCls="icon-ok">保存</a> <a href="javascript:closeSaleChanceDialog()"
			class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
	</div>
</body>
</html>