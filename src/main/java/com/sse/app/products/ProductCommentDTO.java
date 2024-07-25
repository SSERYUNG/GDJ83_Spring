package com.sse.app.products;

import com.sse.app.boards.CommentDTO;

public class ProductCommentDTO extends CommentDTO {

	private Integer item_id;

	public Integer getItem_id() {
		return item_id;
	}

	public void setItem_id(Integer item_id) {
		this.item_id = item_id;
	}

}
