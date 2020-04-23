package com.board.service;

import java.util.List;

import com.board.domain.CategoryVO;
import com.board.domain.GoodsVO;
import com.board.domain.GoodsViewVO;

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
	
}
