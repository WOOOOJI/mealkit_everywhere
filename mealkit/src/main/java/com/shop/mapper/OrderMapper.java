package com.shop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.shop.dto.OrderDTO;
import com.shop.frame.MyMapper;

@Repository
@Mapper
public interface OrderMapper extends MyMapper<Integer, OrderDTO>{
	//장바구니에 담긴 제품들을 주문페이지로 가져오기
	public List<OrderDTO> cart_to_order(int key) throws Exception;
	//재고 확인(item의 cnt와 cart의 cnt 비교)
	public List<OrderDTO> cntcheck(int key) throws Exception;
	//빈 total_order 생성하여 주문상세 받을 준비
	public void create_blank(int key) throws Exception;
	//orderKey의 정보 갖고오기
	public int get_orderkey(int custKey) throws Exception;
	//total_order를 주문 내용으로 UPDATE하기
	public void order_update(int addrKey, int orderKey, int payment) throws Exception;
	//orderKey 이용해서 order 갖고오기
	public OrderDTO getOrderByOrderKey(int orderKey) throws Exception;
	//orderKey이용해서 상품 이미지,이름, 주문상품개수를 포함한 정보 가져오기
	public List<OrderDTO> getOrderWithItemInfo(int orderKey) throws Exception;
}
