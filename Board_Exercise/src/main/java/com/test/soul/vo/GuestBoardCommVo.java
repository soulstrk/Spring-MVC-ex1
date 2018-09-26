package com.test.soul.vo;

public class GuestBoardCommVo {
	private int cnum;
	private int mnum;
	private String writer;
	private String content;
	private int pwd;
	
	public GuestBoardCommVo() {
		// TODO Auto-generated constructor stub
	}

	public GuestBoardCommVo(int cnum, int mnum, String writer, String content, int pwd) {
		super();
		this.cnum = cnum;
		this.mnum = mnum;
		this.writer = writer;
		this.content = content;
		this.pwd = pwd;
	}

	public int getCnum() {
		return cnum;
	}

	public void setCnum(int cnum) {
		this.cnum = cnum;
	}

	public int getMnum() {
		return mnum;
	}

	public void setMnum(int mnum) {
		this.mnum = mnum;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getPwd() {
		return pwd;
	}

	public void setPwd(int pwd) {
		this.pwd = pwd;
	}


	@Override
	public String toString() {
		return "GuestBoardCommVo [cnum=" + cnum + ", mnum=" + mnum + ", writer=" + writer + ", content=" + content
				+ ", pwd=" + pwd + ", recommend=" + "]";
	}
	
	
}
