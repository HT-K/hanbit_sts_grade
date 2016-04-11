package com.hanbit.web.global;

import org.springframework.stereotype.Component;

@Component
public class Command {
	private int pageSize,groupSize,pageNO,startPage,endPage,startRow,endRow,totalPages,count;
		
		
	private String pkg,command,keyField,keyword,view;
	public Command() {}
	public Command(String pkg,String command, String strPageNO,
			String keyField,String keyword, int count) {
		this.pageSize = Constants.PAGESIZE;
		this.groupSize = Constants.GROUPSIZE;
		this.pkg = pkg;
		this.command = command;
		this.pageNO = Integer.parseInt(strPageNO);
		this.keyField = keyField;
		this.keyword = keyword;
		int nmg = count%pageSize;
		if (nmg  != 0) {
			totalPages = (count/pageSize)+1;
		} else {
			totalPages = count/pageSize;
		}
		this.startRow = (pageNO - 1 )*pageSize+1;
		this.endRow = pageNO * pageSize;
		this.startPage = pageNO - ((pageNO-1)%groupSize);
		int end = startPage + groupSize - 1;
		if (endPage > totalPages) {
			end = totalPages;
		}
		this.endPage = end;
		this.count = count;
	}
	public int getPageSize() {
		return pageSize;
	}
	public int getGroupSize() {
		return groupSize;
	}
	public int getPageNO() {
		return pageNO;
	}
	public int getStartPage() {
		return startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public int getStartRow() {
		return startRow;
	}
	public int getEndRow() {
		return endRow;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public String getPkg() {
		return pkg;
	}
	public String getCommand() {
		return command;
	}
	public String getKeyField() {
		return keyField;
	}
	public String getKeyword() {
		return keyword;
	}
	public String getView() {
		return view;
	}
	public int getCount() {
		return count;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public void setGroupSize(int groupSize) {
		this.groupSize = groupSize;
	}
	public void setPageNO(int pageNO) {
		this.pageNO = pageNO;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public void setPkg(String pkg) {
		this.pkg = pkg;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	public void setKeyField(String keyField) {
		this.keyField = keyField;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public void setView(String view) {
		this.view = view;
	}
	

}
