package com.gdu.app03.domain;

public class Board {
	
	// field
	private int boardNo;
	private String title;
	private String createDate;
	
	
	// constructor
	public Board() {
		
	}
	public Board(int boardNo, String title, String createDate) {
		super();
		this.boardNo = boardNo;
		this.title = title;
		this.createDate = createDate;
	}
	
	// getter/setter
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int baordNo) {
		this.boardNo = baordNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	
}
