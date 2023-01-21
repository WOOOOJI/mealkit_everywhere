package com.shop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.shop.dto.BoardDTO;
import com.shop.frame.MyMapper;

@Repository
@Mapper
public interface BoardMapper extends MyMapper<Integer, BoardDTO>{
	//나의 문의 목록
	public List<BoardDTO> qnaList(int sessionKey) throws Exception;
	
	//나의 후기 목록
	public List<BoardDTO> reviewList(int sessionKey) throws Exception;
	
	//문의글 상세보기
	public BoardDTO qnaDetail(int boardKey) throws Exception;
	
	//후기글 상세보기
	public BoardDTO reviewDetail(int boardKey) throws Exception;
	
	//후기글 삭제하기
	public int reviewDel(int boardKey) throws Exception;
	
	
}
