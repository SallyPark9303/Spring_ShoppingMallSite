package com.board.domain;

import java.sql.Date;

import lombok.Data;

@Data
public class GoodsViewVO { // 상품+ 카테고리 조인
	
	private int gdsNum, gdsPrice, gdsStock;
	private String gdsName, cateCode, gdsDes, gdsImg, cateCodeRef, cateName, gdsThumbImg;
	private Date gdsDate;
}
