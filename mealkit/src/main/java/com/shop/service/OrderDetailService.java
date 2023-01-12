package com.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.dto.OrderDetailDTO;
import com.shop.frame.MyService;
import com.shop.mapper.OrderDetailMapper;

@Service
public class OrderDetailService implements MyService<Integer, OrderDetailDTO>{

	@Autowired
	OrderDetailMapper mapper;

	@Override
	public void register(OrderDetailDTO v) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Integer k) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modify(OrderDetailDTO v) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public OrderDetailDTO get(Integer k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderDetailDTO> get() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
