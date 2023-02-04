package com.shop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.shop.dto.BoardDTO;
import com.shop.dto.Criteria;
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
	
	//후기 갯수 카운트
	public int countReviews(Criteria cri) throws Exception;
	
	//문의 갯수 카운트
	public int countQuestions(Criteria cri) throws Exception;
	
	//후기 전체 리스트
	public List<BoardDTO> getReviewsList(Criteria cri) throws Exception;

	//문의 전체 리스트
	public List<BoardDTO> getQuestionsList(Criteria cri) throws Exception;

	//문의글 삭제하기
	public int qnaDel(int boardKey) throws Exception;
	
	//후기글 수정하기
	public int boardEdit(int boardKey, String content) throws Exception;
	
	//상품 평균 평점 가져오기
	public int getRate(int itemKey);
	
	//후기글 작성시 구매한 상품인지 확인하기
	public int searchedItemKey(BoardDTO boardDTO) throws Exception;
	
	//후기글 수정시 작성했던 내용 가져오기
	public BoardDTO modifyReview(BoardDTO boardDTO) throws Exception;
}
