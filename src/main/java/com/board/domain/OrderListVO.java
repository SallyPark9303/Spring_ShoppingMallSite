package com.board.domain;

import lombok.Data;

@Data
public class OrderListVO {

	private String orderId, userId, orderRec, userAddr1, userAddr2, userAddr3, orderPhon, gdsName, gdsThumbImg;
	private int amount, orderDetailsNum, gdsNum, cartStock, gdsPrice;
	
	private String delivery;
	
}
