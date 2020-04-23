package com.board.domain;

import java.sql.Date;

import lombok.Data;
import lombok.ToString;

@Data
public class MemberVO {
/*
 create table tbl_member (
    userId      varchar2(50)    not null, 
    userPass    varchar2(100)   not null,
    userName    varchar2(30)    not null,
    userPhon    varchar2(20)    not null,
    userAddr1   varchar2(20)    null, 우편번호
    userAddr2   varchar2(50)    null, 주소
    userAddr3   varchar2(50)    null, 상세주소
    regiDate    date            default sysdate,
    verify      number          default 0, 회원가입시 메일로 인증할것이기 때문에 기본값은 0/인증이 안된 상태=0, 인증이 된 상태 = 0이아님
    primary key(userId)
); 
 */
	
private String userId, userPass, userName, userPhon,userAddr1, userAddr2, userAddr3;
private Date regiDate;
private int verify;
}
