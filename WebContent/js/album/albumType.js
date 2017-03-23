/**
 * @param no：下一页面页码
 * decription :翻页
 * 
 */
function toPage(no){
	alert(no);
	var pageSize = document.getElementById("pageSize").value;
	location.href="AlbumServlet?op=albumTypeinfoFenye&pageNo=" + no + "&pageSize=" + pageSize;
}
/**
 * 
 * decription :跳转及修改显示数量
 * 
 */
function changePageNo(e){
	var pageNo = document.getElementById("pageNo").value;
	var pageSize = document.getElementById("pageSize").value;	
	if(e.keyCode==13){
		location.href="AlbumServlet?op=albumTypeinfoFenye&pageNo=" + no + "&pageSize=" + pageSize;		
	}
}










