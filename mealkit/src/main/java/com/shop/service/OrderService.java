package com.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.dto.OrderDTO;
import com.shop.frame.MyService;
import com.shop.mapper.OrderMapper;

@Service
public class OrderService implements MyService<Integer, OrderDTO>{

	@Autowired
	OrderMapper mapper;

	@Override
	public void register(OrderDTO v) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Integer k) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modify(OrderDTO v) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public OrderDTO get(Integer k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderDTO> get() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
