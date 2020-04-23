package com.board.service;

import java.util.List;

import com.board.domain.CartListVO;
import com.board.domain.CartVO;
import com.board.domain.CategoryVO;
import com.board.domain.GoodsVO;
import com.board.domain.GoodsViewVO;
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
	
}
