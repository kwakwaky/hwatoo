package com.webapp.util;

public class Pagination {
	final static int ITEMS_PER_PAGE = 3; // 한 페이지당 보여줄 게시글
	final static int PAGES_PER_GROUP = 3; // 현재 페이지에서 보이는 페이지 개수

	private int totalItem; // 모든 게시물 수
	private int totalPage; // 총 페이지 수
	private int pageNo; // 현재 페이지 넘버

	public Pagination() {
		if (pageNo < 1)
			pageNo = 1;
	}

	// 총 아이템 개수 겟&세팅
	public int getTotalItem() {
		return totalItem;
	}

	public void setTotalItem(int totalItem) {
		if (totalItem < 0)
			this.totalItem = 0;
		else
			this.totalItem = totalItem;
	}

	// 현재 페이지 겟&셋팅
	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		if (pageNo < 1) // 현재 페이지는 1보다 작을 수 없음
			this.pageNo = 1;
		else if (pageNo > getTotalPage()) // 현재 페이지는 총 페이지 수 보다 많을 수 없음
			this.pageNo = getTotalPage();
		else
			this.pageNo = pageNo;
	}

	// 총 페이지 수 연산
	public int getTotalPage() {
		totalPage = totalItem / ITEMS_PER_PAGE; // items=100 ==> pages=10
		if (totalItem % ITEMS_PER_PAGE != 0) // 103 % 10 == 3
			totalPage += 1; // items=103 ==> pages=11
		return totalPage;
	}

	// 각 페이지의 첫 아이템 번호 연산
	public int getStartNum() {
		int startNum = (pageNo - 1) * ITEMS_PER_PAGE + 1;// pageNo=4 ==> startNum=31
															// (4-1) * 10 + 1 = 31
		return startNum;
	}

	// 각 페이지의 마지막 아이템 번호 연산
	public int getEndNum() {
		int endNum = pageNo * ITEMS_PER_PAGE; // pageNo=99 ==> endNum=990
		if (endNum > totalItem) // totalItem=985 라면 endNum은 990이 될 수 없음
			endNum = totalItem;
		return endNum;
	}

	// 현재 페이지에서 보이는 첫번째 페이지 번호 연산
	public int getStartPage() {
		int startPage = (this.pageNo - 1) / PAGES_PER_GROUP * PAGES_PER_GROUP + 1;
		return startPage;
	}

	// 현재 페이지에서 보이는 마지막 페이지 번호 연산
	public int getEndPage() {
		
		int endPage = getStartPage() + PAGES_PER_GROUP - 1;
		if (endPage > getTotalPage() )
			endPage = getTotalPage();
		return endPage;
	}

	// 이전, 다음 버튼 활성화를 위해 첫째 페이지와 마지막 페이지인지 여부를 연산
	public boolean isFirstGroup() {
		boolean isFirstGroup = false;
		if (getStartPage() == 1)
			isFirstGroup = true;
		return isFirstGroup;
	}
	public boolean isLastGroup() {
		boolean isLastGroup = false;
		if (getEndPage() == totalPage)
			isLastGroup = true;
		return isLastGroup;
	}
}
