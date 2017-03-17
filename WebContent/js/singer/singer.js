/**
 * 
 * @param singerId
 */
function deleteSinger(singerId) {
	var bool = confirm("确认删除");
	if (bool) {
		// 删除用户
		location.href = "SingerServlet?op=deleteSinger&singerId=" + singerId;
	}
}
