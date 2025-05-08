package kr.co.kh.vo;

import java.sql.Date;

public class BoardVO {
	private Long boardNO;
	private String boardTitle;
	private String boardContent;
	private String boardWrite;
	private Date regDate;
	
	public BoardVO() {
		super();
	}
	public BoardVO(Long boardNO, String boardTitle, String boardContent, String boardWrite, Date regDate) {
		super();
		this.boardNO = boardNO;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardWrite = boardWrite;
		this.regDate = regDate;
	}
	public Long getBoardNO() {
		return boardNO;
	}
	public void setBoardNO(Long boardNO) {
		this.boardNO = boardNO;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public String getBoardWrite() {
		return boardWrite;
	}
	public void setBoardWrite(String boardWrite) {
		this.boardWrite = boardWrite;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return "BoardVO [boardNO=" + boardNO + ", boardTitle=" + boardTitle + ", boardContent=" + boardContent
				+ ", boardWrite=" + boardWrite + ", regDate=" + regDate + "]";
	}

	
}
