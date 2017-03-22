<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/album/albumType.js"></script>
</head>
<body>
<table id="albumTypeinfo">
    <thead>
    <tr>        
        <td>专辑类型</td>               
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${pm.list}" var="type">
	    <tr>	    	
	        <td>${type}</td>	       	        	        	        	        	     	        
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