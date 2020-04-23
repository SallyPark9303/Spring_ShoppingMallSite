package com.board.domain;

import java.util.Date;

import lombok.Data;

@Data
public class ReplyVO {
	
	private int gdsNum, rNum ;
	private String userId, rContent;
	private Date rDate;

}
