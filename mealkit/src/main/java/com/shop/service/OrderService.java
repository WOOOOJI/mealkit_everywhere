package com.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.dto.OrderDTO;
import com.shop.frame.MyService;
import com.shop.mapper.OrderMapper;

@Service
public class OrderService implements MyService<Integer, OrderDTO>{

	@Autowired
	OrderMapper mapper;

	@Override
	public void register(OrderDTO v) throws Exception {

	}

	@Override
	public void remove(Integer k) throws Exception {

	}

	@Override
	public void modify(OrderDTO v) throws Exception {
	}

	@Override
	public OrderDTO get(Integer k){
		OrderDTO result=null;
		try {
			result=mapper.select(k);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<OrderDTO> get(){
		List<OrderDTO> result=null;
		
		try {
			return mapper.selectall();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public List<OrderDTO> cartToOrder(int key) {
		List<OrderDTO> result=null;
		
		try {
			result=mapper.cartToOrder(key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public List<OrderDTO> cntCheck(int key) {
		List<OrderDTO> result=null;
		
		try {
			result= mapper.cntCheck(key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public void createBlank(int key) {
		try {
			mapper.createBlank(key);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int getOrderkey(int custKey){
		int result=0;
		try {
			result=mapper.getOrderkey(custKey);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;

	}
	
	public void orderUpdate(int addrKey, int orderKey, int payment) {
		try {
			mapper.orderUpdate(addrKey, orderKey, payment);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public OrderDTO getOrderByOrderKey(int orderKey){
		OrderDTO result=null;
		
		try {
			result= mapper.getOrderByOrderKey(orderKey);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public List<OrderDTO> getOrderWithItemInfo(int orderKey) {
		List<OrderDTO> result=null;
		
		try {
			result=mapper.getOrderWithItemInfo(orderKey);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
