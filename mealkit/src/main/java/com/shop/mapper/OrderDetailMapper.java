package com.shop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.shop.dto.OrderDTO;
import com.shop.dto.OrderDetailDTO;
import com.shop.frame.MyMapper;

@Repository
@Mapper
public interface OrderDetailMapper extends MyMapper<Integer, OrderDetailDTO>{
	//cart의 내용을 주문상세에 입력
	public void cart_to_detail(int cust_key,OrderDTO o) throws Exception;
	//order_key 이용해서 주문상세 갖고오기
	public List<OrderDetailDTO> get_orderdetail_by_orderkey(int order_key) throws Exception;
}
