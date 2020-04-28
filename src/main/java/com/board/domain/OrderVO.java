package com.board.domain;

import java.util.Date;

import lombok.Data;
@Data
public class OrderVO {
	
	private String orderId, userId, orderRec, userAddr1, userAddr2, userAddr3,orderPhon;
	private int amount;
	private Date orderDate;
	
	private String delivery;

}
