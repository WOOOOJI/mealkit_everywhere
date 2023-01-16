package com.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.dto.AddressDTO;
import com.shop.frame.MyService;
import com.shop.mapper.AddressMapper;

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

	public AddressDTO check_default(int key) throws Exception {
		return mapper.check_default(key);
	};
	
	public List<AddressDTO> user_addr(int cust_key) throws Exception{
		return mapper.user_addr(cust_key);
	}
	
	public AddressDTO addr_key(int addr_key) throws Exception{
		return mapper.addr_key(addr_key);
	}

}
