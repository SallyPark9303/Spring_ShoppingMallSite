package com.board.domain;




import lombok.Data;

@Data
public class CategoryVO {
	
	private String cateName,cateCode,cateCodeRef;
	private int level;
}
