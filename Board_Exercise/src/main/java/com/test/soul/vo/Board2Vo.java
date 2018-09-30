package com.test.soul.vo;

import java.util.Date;

public class Board2Vo {
	private int num;
	private String writer;
	private String title;
	private String content;
	private int hit;
	private Date regdate;
	
	public Board2Vo() {
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

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "Board2Vo [num=" + num + ", writer=" + writer + ", title=" + title + ", content=" + content + ", hit="
				+ hit + ", regdate=" + regdate + "]";
	}

	public Board2Vo(int num, String writer, String title, String content, int hit, Date regdate) {
		super();
		this.num = num;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.hit = hit;
		this.regdate = regdate;
	}
	
	
}
