package com.board.domain;

import java.util.Date;

import lombok.Data;

@Data
public class CartVO {

	private int cartNum, gdsNum, cartStock;
	private String userId;
	private Date addDate;
	
	
}
