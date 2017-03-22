/**
 * 
 */
/*function deleteAlbum(albumId){
	
	var pageNo = document.getElementById("pageNo").value;
	var pageSize = document.getElementById("pageSize").value;	
	var bool = confirm("确认删除");
	alert(albumId);
	alert(pageNo);
	alert(pageSize);
	if(bool){
		// 删除专辑		
		location.href="AlbumServlet?op=deleteAlbum&albumId=" +albumId ;		
	}	
}*/

function changeAlbum(albumId ){
	alert(albumId);
	location.href="AlbumServlet?op=changeAlbum&albumId=" +albumId ;
		
}

function toPage(no){
	alert(no);
	var pageSize = document.getElementById("pageSize").value;
	location.href="AlbumServlet?op=albuminfoFenye&pageNo=" + no + "&pageSize=" + pageSize;
}

function changePageNo(e){
	var pageNo = document.getElementById("pageNo").value;
	var pageSize = document.getElementById("pageSize").value;	
	if(e.keyCode==13){
		location.href="AlbumServlet?op=albuminfoFenye&pageNo=" + no + "&pageSize=" + pageSize;		
	}
}










