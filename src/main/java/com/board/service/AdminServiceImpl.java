package com.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.domain.CategoryVO;
import com.board.domain.GoodsVO;
import com.board.domain.GoodsViewVO;
import com.board.domain.OrderListVO;
import com.board.domain.OrderVO;
import com.board.domain.ReplyListVO;
import com.board.mapper.adminMapper;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private adminMapper mapper;

	
	
	@Override
	public List<CategoryVO> category() {
		// TODO Auto-generated method stub
		return mapper.category();
	}


	@Override
	public void register(GoodsVO vo) {
		mapper.register(vo);
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<GoodsViewVO> goodslist() {
		// TODO Auto-generated method stub
		System.out.println("서비스");
		return mapper.goodslist();
	}


	@Override
	public GoodsViewVO goodsview(int gdsNum) {
		// TODO Auto-generated method stub
		return mapper.goodsview(gdsNum);
	}


	@Override
	public void goodsmodify(GoodsVO vo) {
		// TODO Auto-generated method stub
		 mapper.goodsmodify(vo);
	}


	@Override
	public void goodsdelete(int gdsNum) {
		// TODO Auto-generated method stub
		mapper.goodsdelete(gdsNum);
		
	}


	@Override
	public List<OrderVO> orderList() {
		// TODO Auto-generated method stub
		return mapper.orderList();
	}


	@Override
	public List<OrderListVO> orderView(OrderVO order) {
		// TODO Auto-generated method stub
		return mapper.orderView(order);
	}


	@Override
	public void delivery(OrderVO order) {
		// TODO Auto-generated method stub
		 mapper.delivery(order);
	}


	@Override
	public void changestock(GoodsVO goods) {
		// TODO Auto-generated method stub
		
		mapper.changestock(goods);
		
	}


	@Override
	public List<ReplyListVO> replylist() {
		// TODO Auto-generated method stub
		return mapper.replylist();
	}


	@Override
	public void replydelete(int rnum) {
		// TODO Auto-generated method stub
		mapper.replydelete(rnum);
	}


	@Override
	public List<GoodsVO> allgoodsList() {
		// TODO Auto-generated method stub
		return mapper.allgoodsList();
	}

}
