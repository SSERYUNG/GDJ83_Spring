package com.sse.app.boards;

import java.sql.Date;
import java.util.List;

public class BoardDTO extends CommentDTO {

	private String boardTitle;
	private Date updateDate;
	private Long boardHit;
	private String boardCategory;
	private Integer del;
	private List<BoardFileDTO> addfiles;

	public List<BoardFileDTO> getAddfiles() {
		return addfiles;
	}

	public void setAddfiles(List<BoardFileDTO> addfiles) {
		this.addfiles = addfiles;
	}

	//
	public Integer getDel() {
		if (del == null) {
			del = 0;
		}
		return del;
	}

	public void setDel(Integer del) {
		this.del = del;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Long getBoardHit() {
		return boardHit;
	}

	public void setBoardHit(Long boardHit) {
		this.boardHit = boardHit;
	}

	public String getBoardCategory() {
		return boardCategory;
	}

	public void setBoardCategory(String boardCategory) {
		this.boardCategory = boardCategory;
	}

}
