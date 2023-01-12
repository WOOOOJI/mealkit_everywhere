package com.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.dto.BoardDTO;
import com.shop.frame.MyService;
import com.shop.mapper.BoardMapper;

@Service
public class BoardService implements MyService<Integer, BoardDTO>{

	@Autowired
	BoardMapper mapper;
	
	
	@Override
	public void register(BoardDTO v) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Integer k) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modify(BoardDTO v) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BoardDTO get(Integer k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BoardDTO> get() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


}
