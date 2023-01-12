package com.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.dto.CartDTO;
import com.shop.frame.MyService;
import com.shop.mapper.CartMapper;

@Service
public class CartService implements MyService<Integer, CartDTO>{

	@Autowired
	CartMapper mapper;
	
	
	@Override
	public void register(CartDTO v) throws Exception {
	}

	@Override
	public void remove(Integer k) throws Exception {
	}

	@Override
	public void modify(CartDTO v) throws Exception {
	}

	@Override
	public CartDTO get(Integer k) throws Exception {
		return mapper.select(k);
	}

	@Override
	public List<CartDTO> get() throws Exception {
		return mapper.selectall();
	}
	
	

}
