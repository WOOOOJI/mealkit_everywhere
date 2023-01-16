package com.shop.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.shop.dto.CartDTO;
import com.shop.frame.MyMapper;

@Repository
@Mapper
public interface CartMapper extends MyMapper<Integer, CartDTO>{
	//주문 완료시 장바구니를 제거
	public void cart_delete(int cust_key) throws Exception;
}
