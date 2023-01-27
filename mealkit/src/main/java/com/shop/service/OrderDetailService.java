package com.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.dto.OrderDTO;
import com.shop.dto.OrderDetailDTO;
import com.shop.frame.MyService;
import com.shop.mapper.OrderDetailMapper;

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
	public List<OrderDetailDTO> get() {
		List<OrderDetailDTO> result=null;
		try {
			result=mapper.selectall();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	public void cartToDetail(int custKey,OrderDTO o){
		try {
			mapper.cartToDetail(custKey,o);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<OrderDetailDTO> getOrderDetailByOrderkey(int orderKey){
		List<OrderDetailDTO> result=null;
		try {
			result=mapper.getOrderdetailByOrderkey(orderKey);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
