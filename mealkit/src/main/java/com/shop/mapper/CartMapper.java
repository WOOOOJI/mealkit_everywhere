package com.shop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.shop.dto.CartDTO;
import com.shop.frame.MyMapper;

@Repository
@Mapper
public interface CartMapper extends MyMapper<Integer, CartDTO>{
	//주문 완료시 장바구니를 제거
	public void cartDelete(int custKey) throws Exception;
	
	// 특정 사용자의 장바구니 리스트 내용물 가져오기
	public List<CartDTO> CartList(int sessionKey) throws Exception;
	
	// 장바구니에 담긴 상품 개수를 가져오기
	public int cntCart(int custKey) throws Exception;
	
	// 장바구니에 물건 담기
	public void insertCart(int custKey, int itemKey, int cnt) throws Exception;
	
	// 장바구니에 이미 존재하는 물건을 추가를 하면 수량을 증가시키기
	public void increaseCart(int cart_key, int itemKey, int cnt) throws Exception;
	
}
