package com.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.dto.ItemDTO;
import com.shop.dto.OrderDetailDTO;
import com.shop.frame.MyService;
import com.shop.mapper.ItemMapper;

@Service
public class ItemService implements MyService<Integer, ItemDTO>{

	@Autowired
	ItemMapper mapper;
	
	
	@Override
	public void register(ItemDTO v) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Integer k) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modify(ItemDTO v) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ItemDTO get(Integer k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ItemDTO> get() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void cntdown(OrderDetailDTO od) throws Exception{
		mapper.cntdown(od);
	}



}
