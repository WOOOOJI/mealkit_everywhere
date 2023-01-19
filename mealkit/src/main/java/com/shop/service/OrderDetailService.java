package com.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.dto.OrderDTO;
import com.shop.dto.OrderDetailDTO;
import com.shop.frame.MyService;
import com.shop.mapper.OrderDetailMapper;

@Service
public class OrderDetailService implements MyService<Integer, OrderDetailDTO>{

	@Autowired
	OrderDetailMapper mapper;

	@Override
	public void register(OrderDetailDTO v) throws Exception {
		
	}

	@Override
	public void remove(Integer k) throws Exception {
		
	}

	@Override
	public void modify(OrderDetailDTO v) throws Exception {
		
	}

	@Override
	public OrderDetailDTO get(Integer k) throws Exception {
		return mapper.select(k);
	}

	@Override
	public List<OrderDetailDTO> get() throws Exception {
		return mapper.selectall();
	}
	
	public void cart_to_detail(int cust_key,OrderDTO o) throws Exception{
		mapper.cart_to_detail(cust_key,o);
	}
	
	public List<OrderDetailDTO> get_orderdetail_by_orderkey(int order_key){
		List<OrderDetailDTO> result=null;
		try {
			result=mapper.get_orderdetail_by_orderkey(order_key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
