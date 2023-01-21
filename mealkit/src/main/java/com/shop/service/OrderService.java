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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<OrderDTO> get() throws Exception {
		return mapper.selectall();
	}
	
	public List<OrderDTO> cart_to_order(int key) throws Exception{
		return mapper.cart_to_order(key);
	}
	
	public List<OrderDTO> cntcheck(int key) throws Exception{
		return mapper.cntcheck(key);
	}
	
	public void create_blank(int key) throws Exception{
		mapper.create_blank(key);
	}
	
	public int get_orderkey(int custKey) throws Exception{
		return mapper.get_orderkey(custKey);
	}
	
	public void order_update(int addrKey, int orderKey, int payment) throws Exception{
		mapper.order_update(addrKey, orderKey, payment);
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
