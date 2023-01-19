package com.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.dto.CommentsDTO;
import com.shop.frame.MyService;
import com.shop.mapper.CommentsMapper;

@Service
public class CommentsService implements MyService<Integer, CommentsDTO>{

	@Autowired
	CommentsMapper mapper;
	
	@Override
	public void register(CommentsDTO v) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Integer k) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modify(CommentsDTO v) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CommentsDTO get(Integer k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CommentsDTO> get() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	// 문의 답변 
	public CommentsDTO getreply(Integer k) throws Exception { 
		return mapper.qnaReply(k);
	}



}
