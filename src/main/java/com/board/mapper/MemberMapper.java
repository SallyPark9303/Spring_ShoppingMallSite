package com.board.mapper;

import com.board.domain.MemberVO;

public interface MemberMapper {
	
	public int signup(MemberVO vo); //회원가입
	
	public MemberVO signin(MemberVO vo); //로그인
	

}
