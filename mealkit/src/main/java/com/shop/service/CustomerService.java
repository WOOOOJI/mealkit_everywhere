package com.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.dto.CustomerDTO;
import com.shop.frame.MyService;
import com.shop.mapper.CustomerMapper;

@Service
public class CustomerService implements MyService<Integer, CustomerDTO>{

	@Autowired
	CustomerMapper mapper;

	@Override
	public void register(CustomerDTO v) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Integer k) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modify(CustomerDTO v) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CustomerDTO get(Integer k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CustomerDTO> get() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
