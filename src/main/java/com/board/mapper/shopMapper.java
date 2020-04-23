package com.board.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.board.domain.CartListVO;
import com.board.domain.CartVO;
import com.board.domain.CategoryVO;
import com.board.domain.GoodsVO;
import com.board.domain.GoodsViewVO;
import com.board.domain.ReplyListVO;
import com.board.domain.ReplyVO;


public interface shopMapper {
	
	public List<GoodsViewVO> list1(int cateCode); 
	
	public void  registerReply(ReplyVO reply);
	
	public List<ReplyListVO> replylist(int gdsNum);

	
	public void addCart(CartVO cart);
    
	public List<CartListVO> cartList(String userId); 	

}


