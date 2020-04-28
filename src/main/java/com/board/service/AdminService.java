package com.board.service;

import java.util.List;

import com.board.domain.CategoryVO;
import com.board.domain.GoodsVO;
import com.board.domain.GoodsViewVO;
import com.board.domain.OrderListVO;
import com.board.domain.OrderVO;
import com.board.domain.ReplyListVO;

public interface AdminService {

	//카테고리
	public List<CategoryVO> category();
	
	//상품등록
	public void register(GoodsVO vo);
	//상품 목록
	public List<GoodsViewVO> goodslist();
	
	//상품 조회
	public GoodsViewVO goodsview(int gdsNum);
	
	//상품 수정
	public void goodsmodify(GoodsVO vo);
	//상품 삭제 
	public void goodsdelete(int gdsNum);
	
	//주문목록
	public List<OrderVO> orderList();
	
	//특정 주문 목록
	public List<OrderListVO> orderView(OrderVO order);
	
	//주문
	public void delivery(OrderVO order) ;
	
	//재고 수량 업데이트
	public void changestock(GoodsVO goods);
	
	//소감 댓글 목록
	public List<ReplyListVO> replylist();
	
	//소감 삭제
	
	public void replydelete(int rnum);
	
	
	//소감 댓글 삭제
	
	//모든 상품 리스트
	public List<GoodsVO> allgoodsList();
	
}
