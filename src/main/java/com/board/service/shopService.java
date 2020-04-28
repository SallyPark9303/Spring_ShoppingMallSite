package com.board.service;

import java.util.List;

import com.board.domain.CartListVO;
import com.board.domain.CartVO;
import com.board.domain.CategoryVO;
import com.board.domain.GoodsVO;
import com.board.domain.GoodsViewVO;
import com.board.domain.OrderDetailVO;
import com.board.domain.OrderListVO;
import com.board.domain.OrderVO;
import com.board.domain.ReplyListVO;
import com.board.domain.ReplyVO;

public interface shopService {

//카테고리별 상품 리스트
	public List<GoodsViewVO> list1(int cateCode);
	
	//상품조회
	public GoodsViewVO goodsView(int gdsNum);
	
	//상품 소감
	public void registerReply(ReplyVO reply);
	
	
	//상품 소감 리스트
	public List<ReplyListVO> replylist(int gdsNum);
	
	//카트 담기
	public void addCart(CartVO cart);
	//카트 목록
	public List<CartListVO> cartList(String userId);
	
	//카트 삭제
	public void deleteCart(CartVO cart);
	
	//주문 정보
	public void orderInfo(OrderVO order);
	
	//주문 상세 정보
	
	public void orderInfo_Details(OrderDetailVO orderDetail);

	//카트 비우기
	
	public void cartAllDelete(String userId);
	
	//주문 목록
	public List<OrderVO> orderList(OrderVO orderList);
	
	//주문 상세 목록
	public List<OrderListVO> orderView(OrderVO order);
	
	//상품 소감 삭제
	public void deleteReply(ReplyVO reply);
	
	//상품 소감 삭제 시 아이디 체크
	public String idCheck(int rNum);
	

	
	
	
}
