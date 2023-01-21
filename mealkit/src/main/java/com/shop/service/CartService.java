package com.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.dto.CartDTO;
import com.shop.frame.MyService;
import com.shop.mapper.CartMapper;

@Service
public class CartService implements MyService<Integer, CartDTO>{

	@Autowired
	CartMapper mapper;
	
	@Override
	public void register(CartDTO v) throws Exception {
		mapper.insert(v);
	}

	@Override
	public void remove(Integer k) throws Exception {
		mapper.delete(k);
	}

	@Override
	public void modify(CartDTO v) throws Exception {
		mapper.update(v);
	}

	@Override
	public CartDTO get(Integer k) throws Exception {
		return mapper.select(k);
	}

	@Override
	public List<CartDTO> get() throws Exception {
		return mapper.selectall();
	}
	
	//주문완료 후 해당 장바구니 제거
	public void cart_delete(int custKey) throws Exception{
		mapper.cart_delete(custKey);
	}
	// 특정 사용자의 장바구니 리스트 내용물 가져오기
	public List<CartDTO> CartList(Integer k) throws Exception {
		return mapper.CartList(k);
	}

	// 사용자의 장바구니에 담긴 상품의 개수 가져오기
	public int cntCart(Integer k) throws Exception{
		return mapper.cntCart(k);
	}
	
	// 장바구니에 물건 담기
	public void insertCart(int custKey, int itemKey, int cnt) throws Exception{
		mapper.insertCart(custKey, itemKey, cnt);
	}
	
	// 장바구니에 이미 존재하는 물건을 추가를 하면 수량을 증가시키기
	public void increaseCart(int cartKey, int itemKey, int cnt) throws Exception{
		mapper.increaseCart(cartKey, itemKey, cnt);
	}
}

