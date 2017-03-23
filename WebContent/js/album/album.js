/**
 * @param 专辑id
 * decription :修改专辑
 * 
 */
function changeAlbum(albumId ){
	location.href="AlbumServlet?op=changeAlbum&albumId=" +albumId ;
		
}
/**
 * @param no：下一页面页码
 * decription :翻页
 * 
 */
function toPage(no){
	var pageSize = document.getElementById("pageSize").value;
	location.href="AlbumServlet?op=albuminfoFenye&pageNo=" + no + "&pageSize=" + pageSize;
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
		location.href="AlbumServlet?op=albuminfoFenye&pageNo=" + no + "&pageSize=" + pageSize;		
	}
}










