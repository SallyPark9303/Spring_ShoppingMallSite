package com.board.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.board.domain.MemberVO;

public class AdminInterceptor extends HandlerInterceptorAdapter {

 @Override
 public boolean preHandle(HttpServletRequest req,
    HttpServletResponse res, Object obj) throws Exception {
  //preHandle : 컨트롤러 실행되기 전에 관리자 여부를 확인
  HttpSession session = req.getSession();
  MemberVO member = (MemberVO)session.getAttribute("member");
  if(member == null) {
	  res.sendRedirect("/member/signin");
	  return false;
	 } //로그인을 하지 않은 상태에서 관리자 화면에 접속할 때, 처음 화면이 아닌 로그인 화면으로 이동.
  if(member.getVerify() != 3) {
   res.sendRedirect("/"); //가장 처음 화면으로 되돌림.
   return false; //false를 반환.
  }
  
  return true;
 }

}
