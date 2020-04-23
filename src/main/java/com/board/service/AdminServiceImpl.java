package com.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.domain.CategoryVO;
import com.board.domain.GoodsVO;
import com.board.domain.GoodsViewVO;
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

}
