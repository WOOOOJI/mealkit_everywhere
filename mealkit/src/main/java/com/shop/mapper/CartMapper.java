package com.shop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.shop.dto.CartDTO;
import com.shop.frame.MyMapper;

@Repository
@Mapper
public interface CartMapper extends MyMapper<Integer, CartDTO>{
	
	// 특정 사용자의 장바구니 리스트 내용물 가져오기
	public List<CartDTO> CartList(int sessionKey) throws Exception;
}
