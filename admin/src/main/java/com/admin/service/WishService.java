package com.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.dto.WishDTO;
import com.admin.frame.MyService;
import com.admin.mapper.WishMapper;

@Service
public class WishService implements MyService<Integer, WishDTO>{

	@Autowired
	WishMapper mapper;

	@Override
	public void register(WishDTO v) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(Integer k) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void modify(WishDTO v) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public WishDTO get(Integer k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<WishDTO> get() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


}
