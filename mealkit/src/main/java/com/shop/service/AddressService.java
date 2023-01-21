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
	public void register(AddressDTO v) {
		try {
			mapper.insert(v);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void remove(Integer k) {
		try {
			mapper.delete(k);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void modify(AddressDTO v) {
		try {
			mapper.update(v);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public AddressDTO get(Integer k) {
		AddressDTO res=null;
		
		try {
			res=mapper.select(k);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public List<AddressDTO> get(){
		
		List<AddressDTO> res=null;
		try {
			res=mapper.selectall();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}

	public AddressDTO check_default(int key) throws Exception {
		return mapper.check_default(key);
	};
	
	public List<AddressDTO> user_addr(int custKey) throws Exception{
		return mapper.user_addr(custKey);
	}
	
	public AddressDTO addrKey(int addrKey) throws Exception{
		return mapper.addrKey(addrKey);
	}
	
	public void insertAddress(int custKey,AddressDTO address) {
		try {
			mapper.insertAddress(custKey, address);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
