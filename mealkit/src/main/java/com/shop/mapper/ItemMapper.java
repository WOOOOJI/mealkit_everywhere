package com.shop.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.shop.dto.ItemDTO;
import com.shop.dto.OrderDetailDTO;
import com.shop.frame.MyMapper;

@Repository
@Mapper
public interface ItemMapper extends MyMapper<Integer, ItemDTO>{
	//주문 완료 후 수량을 줄여주는 기능
	public void cntdown(OrderDetailDTO od) throws Exception;
}
