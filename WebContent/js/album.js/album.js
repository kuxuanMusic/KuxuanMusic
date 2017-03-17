/**
 * 
 */
function deleteAlbum(albumId){
	var pageNo = document.getElementById("pageNo").value;
	var pageSize = document.getElementById("pageSize").value;	
	var bool = confirm("确认删除");
	//alert(cusId);
	if(bool){
		// 删除专辑		
		location.href="admin/album?op=deleteAlbum&albumId=" +albumId + "&pageNo=" + pageNo + "&pageSize=" + pageSize;		
	}	
}

function changeAlbum(allbumId ){
	location.href="admin/album?op=changeAlbum&cusId=" + allbumId ;
}

function toPage(no){
	var pageSize = document.getElementById("pageSize").value;
	location.href="admin/album?op=albuminfoFenye&pageNo=" + no + "&pageSize=" + pageSize;
}

function changePageNo(e){
	var pageNo = document.getElementById("pageNo").value;
	var pageSize = document.getElementById("pageSize").value;	
	if(e.keyCode==13){
		location.href="admin/album?op=albuminfoFenye&pageNo=" + pageNo + "&pageSize=" + pageSize;		
	}
}










