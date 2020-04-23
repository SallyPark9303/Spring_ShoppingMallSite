package com.board.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.board.domain.CategoryVO;
import com.board.domain.GoodsVO;
import com.board.domain.GoodsViewVO;


public interface adminMapper {
	
	
	public List<CategoryVO> category();
	
	public void register(GoodsVO vo); //상품등록
	
	public List<GoodsViewVO> goodslist(); 
	
	public GoodsViewVO goodsview(int gdsNum);
	
	public void goodsmodify(GoodsVO vo);
	
	public void goodsdelete(int gdsNum);

}
