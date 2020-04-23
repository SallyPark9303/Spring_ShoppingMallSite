package com.board.service;

import javax.servlet.http.HttpSession;

import com.board.domain.MemberVO;

public interface MemberService {
	
	//회원 가입
	public void signup(MemberVO vo);
	
	//로그인
	public MemberVO signin(MemberVO vo);
	
	//로그아웃
	public void signout(HttpSession session);

}
