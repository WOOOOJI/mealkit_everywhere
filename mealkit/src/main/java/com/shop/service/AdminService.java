package com.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.dto.AdminDTO;
import com.shop.frame.MyService;
import com.shop.mapper.AdminMapper;

@Service
public class AdminService implements MyService<Integer, AdminDTO>{

	@Autowired
	AdminMapper mapper;
	
	@Override
	public void register(AdminDTO v) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Integer k) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modify(AdminDTO v) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AdminDTO get(Integer k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AdminDTO> get() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


}
