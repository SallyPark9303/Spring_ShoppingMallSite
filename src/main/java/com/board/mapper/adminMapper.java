package com.board.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.board.domain.CategoryVO;
import com.board.domain.GoodsVO;
import com.board.domain.GoodsViewVO;
import com.board.domain.OrderListVO;
import com.board.domain.OrderVO;
import com.board.domain.ReplyListVO;


public interface adminMapper {
	
	
	public List<CategoryVO> category();
	
	public void register(GoodsVO vo); //상품등록
	
	public List<GoodsViewVO> goodslist(); 
	
	public GoodsViewVO goodsview(int gdsNum);
	
	public void goodsmodify(GoodsVO vo);
	
	public void goodsdelete(int gdsNum);
	
	public List<OrderVO> orderList();
	
	public List<OrderListVO> orderView(OrderVO order);

	public void delivery(OrderVO order);
	
    public void changestock(GoodsVO goods);
    
    public List<ReplyListVO> replylist();
    
    public void replydelete(int rnum);
    
    public List<GoodsVO> allgoodsList();
}
