package com.board.domain;

import java.util.Date;

import lombok.Data;

@Data
public class CartListVO {
	
	private int gdsNum, cartNum, num, gdsPrice, cartStock;
	private String gdsName, userId, gdsThumbImg;
    private Date addDate;
}
