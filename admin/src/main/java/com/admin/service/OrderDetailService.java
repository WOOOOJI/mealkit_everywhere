package com.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.dto.OrderDetailDTO;
import com.admin.frame.MyService;
import com.admin.mapper.OrderDetailMapper;

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

}
