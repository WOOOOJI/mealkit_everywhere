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
	
	// 문의글 상세보기
	@Override
	public BoardDTO get(Integer k) throws Exception {
		// TODO Auto-generated method stub
		return mapper.qnaDetail(k);
	}

	@Override
	public List<BoardDTO> get() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	// 나의 문의 목록
	public List<BoardDTO> qnaList(Integer k) throws Exception {
		return mapper.qnaList(k);
	}
	

	// 나의 후기 목록
	public List<BoardDTO> reviewList(Integer k) throws Exception {
		return mapper.reviewList(k);
	}
	

	// 후기글 상세보기
	public BoardDTO reviewDetail(Integer k) throws Exception {
		return mapper.reviewDetail(k);
	}
	
	//후기글 삭제하기
	public int reviewDel(Integer k) throws Exception{
		return mapper.reviewDel(k);
	}

	//문의글 삭제하기
	public int qnaDel(Integer k) throws Exception{
		return mapper.qnaDel(k);
	}
	
}
