package com.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.dto.NoticeDTO;
import com.shop.frame.MyService;
import com.shop.mapper.NoticeMapper;

@Service
public class NoticeService implements MyService<Integer, NoticeDTO>{

	@Autowired
	NoticeMapper mapper;

	@Override
	public void register(NoticeDTO v) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Integer k) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modify(NoticeDTO v) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public NoticeDTO get(Integer k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<NoticeDTO> get() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
