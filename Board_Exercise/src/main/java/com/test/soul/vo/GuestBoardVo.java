package com.test.soul.vo;

public class GuestBoardVo {
	private int num;
	private String writer;
	private String title;
	private String content;
	private int hit;
	
	public GuestBoardVo() {
		// TODO Auto-generated constructor stub
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public GuestBoardVo(int num, String writer, String title, String content, int hit) {
		super();
		this.num = num;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.hit = hit;
	}

	@Override
	public String toString() {
		return "GuestBoardVo [num=" + num + ", writer=" + writer + ", title=" + title + ", content=" + content
				+ ", hit=" + hit + "]";
	}
	
	
}
