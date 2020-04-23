package com.board.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.domain.MemberVO;
import com.board.mapper.MemberMapper;

import lombok.Setter;
@Service
public class MemberServiceImpl implements MemberService {
     
	@Autowired
	private MemberMapper mapper;
	
	
	@Override
	public void signup(MemberVO vo) {
		// TODO Auto-generated method stub
		mapper.signup(vo);
		
	}


	@Override
	public MemberVO signin(MemberVO vo) {
		// TODO Auto-generated method stub
		return mapper.signin(vo);
	}


	@Override
	public void signout(HttpSession session) {
	 session.invalidate();
		
	}

}
