<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
	String str = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>
<base href="<%=str%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/album/album.js"></script>

<title>Insert title here</title>
</head>
<body>
<table id="userinfo" >

    <thead>
    <tr>
    	<td>专辑id</td>
        <td>专辑名</td>
        <td>语种</td>
        <td>发行时间</td>
        <td>发行公司</td>
        <td>类型</td>        
        <td>操作</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${pm.list}" var="album">
	    <tr>
	    	<input type="hidden" name="id" value="${album.albumId}"/>
	    	<td>${album.albumId}</td>
	        <td>${album.albumName}</td>
	        <td><c:choose>
	        		<c:when test="${album.languageId ==1}">
	        			汉语
	        		</c:when>
	        		<c:when test="${album.languageId ==2}">
	        			日语
	        		</c:when>
	        		<c:when test="${album.languageId ==3}">
	        			英语
	        		</c:when>
	        		<c:when test="${album.languageId ==4}">
	        			韩语
	        		</c:when>
	        		<c:when test="${album.languageId ==5}">
	        			德语
	        		</c:when>
	        		<c:when test="${album.languageId ==6}">
	        			法语
	        		</c:when>
	        		<c:when test="${album.languageId ==7}">
	        			西班牙语
	        		</c:when>
	        		<c:when test="${album.languageId ==8}">
	        			葡萄牙语
	        		</c:when>
	        		<c:otherwise>
	        			印第安语
	        		</c:otherwise>
	        	</c:choose>	</td>	        
	        	        
	        <td>
	        	<fmt:formatDate value="${album.releaseTime }" pattern="yyyy年MM月dd日"/>       
	        </td>
	         <td>${album.releaseCompany }</td>
	         <td><c:choose>
	        		<c:when test="${album.typeid ==1}">
	        			EP
	        		</c:when>
	        		<c:when test="${album.typeid ==2}">
	        			录音室专辑
	        		</c:when>
	        		<c:when test="${album.typeid ==3}">
	        			合辑
	        		</c:when>
	        		<c:when test="${album.typeid ==4}">
	        			精选辑
	        		</c:when>	        		
	        		<c:otherwise>
	        			单曲
	        		</c:otherwise>
	        	</c:choose></td>	        	        	        
	        <td>	        
	        	<a href="javascript:changeAlbum(${album.albumId})">修改</a>
	        	        
	        </td>	        
	    </tr>   
    </c:forEach>     
    </tbody>
    <tfoot>
    	<tr>
    		<td colspan="9">
    			<c:if test="${pm.pageNo == 1 }">
    				首页
    			</c:if>
    			<c:if test="${pm.pageNo != 1 }">
    				<a href="javascript:toPage(${pm.pageFirst})">首页</a>
    			</c:if>    			
    			<a href="javascript:toPage(${pm.pagePre})">上一页</a>
    			<a href="javascript:toPage(${pm.pageNext})">下一页</a>
    			<a href="javascript:toPage(${pm.pageLast})">尾页  </a>
    			
    			${pm.pageNo}/${pm.pageLast}
    			共${pm.count}条数据 
    			跳转到<input type="text" name="pageNo" value="${pm.pageNo}" id="pageNo" onkeyup="changePageNo(event)"/>页  
    			每页<input type="text" name="pageSize" value="${pm.pageSize}" id="pageSize" />条数据
    		</td>
    	<tr>
    </tfoot>    
</table>

</body>
</html>