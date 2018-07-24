package com.java.domain;

public class SearchPageHandler extends PageHandler {
	
	private String searchType;
	private String keyword;
	private String searchSort;
	
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getSearchSort() {
		return searchSort;
	}
	public void setSearchSort(String searchSort) {
		this.searchSort = searchSort;
	}
	@Override
	public String toString() {
		return "SearchPageHandler [searchType=" + searchType + ", keyword=" + keyword + ", searchSort=" + searchSort
				+ "]";
	}
}
