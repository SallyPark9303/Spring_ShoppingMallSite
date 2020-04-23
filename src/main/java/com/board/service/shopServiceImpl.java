package com.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.domain.CartListVO;
import com.board.domain.CartVO;
import com.board.domain.CategoryVO;
import com.board.domain.GoodsVO;
import com.board.domain.GoodsViewVO;
import com.board.domain.ReplyListVO;
import com.board.domain.ReplyVO;
import com.board.mapper.adminMapper;
import com.board.mapper.shopMapper;

@Service
public class shopServiceImpl implements shopService {
	@Autowired
	private shopMapper mapper;
	
	@Autowired
	private adminMapper amapper;
	
	

	@Override
	public List<GoodsViewVO> list1(int cateCode) {
		// TODO Auto-generated method stub
		return mapper.list1(cateCode);
	}

	@Override
	public GoodsViewVO goodsView(int gdsNum) {
		// TODO Auto-generated method stub
		return amapper.goodsview(gdsNum);
	}

	@Override
	public void registerReply(ReplyVO reply) {
	    mapper.registerReply(reply);
		
	}

	@Override
	public List<ReplyListVO> replylist(int gdsNum) {
		// TODO Auto-generated method stub
		return mapper.replylist(gdsNum);
	}

	@Override
	public void addCart(CartVO cart) {
		// TODO Auto-generated method stub
		 mapper.addCart(cart);
		
	}

	@Override
	public List<CartListVO> cartList(String userId) {
		// TODO Auto-generated method stub
		return mapper.cartList(userId);
	}

	


}
