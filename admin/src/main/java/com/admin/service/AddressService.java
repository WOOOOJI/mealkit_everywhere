package com.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.dto.AddressDTO;
import com.admin.frame.MyService;
import com.admin.mapper.AddressMapper;

@Service
public class AddressService implements MyService<Integer, AddressDTO>{

	@Autowired
	AddressMapper mapper;
	
	
	@Override
	public void register(AddressDTO v) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Integer k) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modify(AddressDTO v) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AddressDTO get(Integer k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AddressDTO> get() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


}
