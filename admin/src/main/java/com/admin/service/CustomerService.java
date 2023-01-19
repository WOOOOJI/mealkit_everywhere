package com.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.dto.CustomerDTO;
import com.admin.frame.MyService;
import com.admin.mapper.CustomerMapper;

@Service
public class CustomerService implements MyService<Integer, CustomerDTO> {

	@Autowired
	CustomerMapper mapper;

	@Override
	public void register(CustomerDTO v) throws Exception {
		mapper.insert(v);
	}

	@Override
	public void remove(Integer k) throws Exception {
		mapper.delete(k);
	}

	@Override
	public void modify(CustomerDTO v) throws Exception {
		mapper.update(v);
	}

	@Override
	public CustomerDTO get(Integer k) throws Exception {
		return mapper.select(k);
	}

	@Override
	public List<CustomerDTO> get() throws Exception {
		return mapper.selectall();
	}


}






