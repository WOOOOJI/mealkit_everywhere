package com.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.admin.dto.BoardDTO;
import com.admin.dto.Criteria;
import com.admin.frame.MyMapper;

@Repository
@Mapper
public interface BoardMapper extends MyMapper<Integer, BoardDTO>{
	//선택한 문의글 삭제
	public int qnaDel(int boardKey) throws Exception;

	//문의글 상세보기
	public BoardDTO qnaDetail(int boardKey) throws Exception;

	//문의글 삭제하기
	public int qnaDelete(int boardKey) throws Exception;

	//-------------후기----------------------------------------------

	//선택한 후기글 삭제
	public int reviewDel(int boardKey) throws Exception;

	//후기글 상세보기
	public BoardDTO reviewDetail(int boardKey) throws Exception;

	//후기글 삭제하기
	public int reviewDelete(int boardKey) throws Exception;

	//--------------페이징-------------------------------------------------

	//문의 목록 조회
	public List<BoardDTO> getQnaList(Criteria cri) throws Exception;

	//전체 문의 개수 가져오기
	public int countQna(Criteria cri) throws Exception;

	//후기 목록 조회
	public List<BoardDTO> getReviewList(Criteria cri) throws Exception;

	//전체 후기 개수 가져오기
	public int countReview(Criteria cri) throws Exception;
}
