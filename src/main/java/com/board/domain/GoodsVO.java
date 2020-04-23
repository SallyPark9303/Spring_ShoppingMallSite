package com.board.domain;

import java.sql.Date;

import lombok.Data;

@Data
public class GoodsVO {
	
	//tbl_goods 테이블 기반	
	private int gdsNum,gdsPrice, gdsStock;
	private String gdsName, cateCode, gdsDes, gdsImg, gdsThumbImg;
	private Date gdsDate;
	

}
