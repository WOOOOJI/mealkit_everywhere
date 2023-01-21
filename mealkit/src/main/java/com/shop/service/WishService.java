package com.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.dto.WishDTO;
import com.shop.frame.MyService;
import com.shop.mapper.WishMapper;

@Service
public class WishService implements MyService<Integer, WishDTO>{

	@Autowired
	WishMapper mapper;

	@Override
	public void register(WishDTO v) throws Exception {
		mapper.insert(v);
		
	}

	@Override
	public void remove(Integer k) throws Exception {
		mapper.delete(k);
		
	}

	@Override
	public void modify(WishDTO v) throws Exception {
		mapper.update(v);
		
	}

	@Override
	public WishDTO get(Integer k) throws Exception {
		return mapper.select(k);
	}

	@Override
	public List<WishDTO> get() throws Exception {
		return mapper.selectall();
	}

	//장바구니에 담은후 해당 찜리스트 제거
	public void wish_delete(int custKey) throws Exception{
		mapper.wish_delete(custKey);
	}
	// 특정 사용자의 찜 리스트 내용물 가져오기
	public List<WishDTO> WishList(Integer k) throws Exception {
		return mapper.WishList(k);
	}
	
	// 찜리스트에 물건 담기
	public void insertWish(int custKey, int itemKey) throws Exception{
		mapper.insertWish(custKey, itemKey);
	}
	
	
}
