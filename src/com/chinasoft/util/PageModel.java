package com.chinasoft.util;

import java.util.ArrayList;

public class PageModel {
	// ���ж���������
	private int count = 0;
	// ÿҳ����������
	private int pageSize = 0;
	// ��ǰ�ǵڼ�ҳ
	private int pageNo = 0;
	// ��һҳ
	private int pagePre = 0;
	// ��һҳ
	private int pageNext = 0;
	// ��һҳ
	private int pageFirst = 0;
	// βҳ
	private int pageLast = 0;
	// ��ҳ����
	private ArrayList list;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPagePre() {
		pagePre = pageNo - 1 == 0 ? 1 : pageNo - 1;
		return pagePre;
	}

/*	public void setPagePre(int pagePre) {
		this.pagePre = pagePre;
	}*/

	public int getPageNext() {
		pageNext = pageNo + 1 > getPageLast() ? getPageLast() : pageNo + 1;		
		return pageNext;
	}

/*	public void setPageNext(int pageNext) {
		this.pageNext = pageNext;
	}*/

	public int getPageFirst() {
		pageFirst = 1;
		return pageFirst;
	}

//	public void setPageFirst(int pageFirst) {
//		this.pageFirst = pageFirst;
//	}

	public int getPageLast() {
		// ͨ��������
		pageLast = count == 0 ? 1 : (count % pageSize == 0 ? count / pageSize : count / pageSize + 1);
		return pageLast;
	}

//	public void setPageLast(int pageLast) {
//		this.pageLast = pageLast;
//	}

	public ArrayList getList() {
		return list;
	}

	public void setList(ArrayList list) {
		this.list = list;
	}

}
