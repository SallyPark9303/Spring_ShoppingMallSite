package com.board.domain;

import java.util.Date;

import lombok.Data;

@Data
public class ReplyListVO {
	private int gdsNum, rNum ;
	private String userId, rContent,userName;
	private Date rDate;
}
