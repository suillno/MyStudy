package kr.co.kh.vo;

public class SearchHelper {
	private String searchType;
	private String searchKeyword;
	private Long page = 0L;
	private Long pageSize = 10L;
	
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public String getSearchKeyword() {
		return searchKeyword;
	}
	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}
	public Long getPage() {
		return page;
	}
	public void setPage(Long page) {
		this.page = page;
	}
	public Long getPageSize() {
		return pageSize;
	}
	public void setPageSize(Long pageSize) {
		this.pageSize = pageSize;
	}
	@Override
	public String toString() {
		return "SearchHelper [searchType=" + searchType + ", searchKeyword=" + searchKeyword + ", page=" + page
				+ ", pageSize=" + pageSize + "]";
	}
	
	
	
	
}
