package com.shop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.shop.dto.CartDTO;
import com.shop.dto.WishDTO;
import com.shop.frame.MyMapper;

@Repository
@Mapper
public interface WishMapper extends MyMapper<Integer, WishDTO>{
		//장바구니에 담았을 때 찜 리스트를 제거
		public void wish_delete(int custKey) throws Exception;
		
		// 특정 사용자의 찜 리스트 내용물 가져오기
		public List<WishDTO> WishList(int sessionKey) throws Exception;
		
		// 찜 리스트에 물건 담기
		public void insertWish(int custKey, int itemKey) throws Exception;
		
}
