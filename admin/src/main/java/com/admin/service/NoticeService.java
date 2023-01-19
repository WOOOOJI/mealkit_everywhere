package com.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.dto.NoticeDTO;
import com.admin.frame.MyService;
import com.admin.mapper.NoticeMapper;


@Service
public class NoticeService implements MyService<Integer, NoticeDTO>{

	@Autowired
	NoticeMapper noticeMapper;

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
