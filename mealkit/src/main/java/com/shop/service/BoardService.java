package com.shop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.dto.BoardDTO;
import com.shop.dto.Criteria;
import com.shop.dto.PageDTO;
import com.shop.dto.response.PageResponseDTO;
import com.shop.frame.MyService;
import com.shop.mapper.BoardMapper;

@Service
public class BoardService implements MyService<Integer, BoardDTO>{

	@Autowired
	BoardMapper boardMapper;
	
	
	@Override
	public void register(BoardDTO boardDTO) {
		try {
			boardMapper.insert(boardDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void remove(Integer k) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modify(BoardDTO boardDTO) {
		
		try {
			boardMapper.update(boardDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	// 문의글 상세보기
	@Override
	public BoardDTO get(Integer k) throws Exception {
		// TODO Auto-generated method stub
		return boardMapper.qnaDetail(k);
	}
	
	@Override
	public List<BoardDTO> get() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	//후기 전체 리스트
	public List<BoardDTO> getReviewsList(Criteria cri) {
		try {
			return boardMapper.getReviewsList(cri);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	//문의 전체 리스트
	public List<BoardDTO> getQuestionsList(Criteria cri) {
		try {
			return boardMapper.getQuestionsList(cri);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//전체 후기 개수 가져오기
	public int countReviews(Criteria cri) throws Exception{
		return boardMapper.countReviews(cri);
	}
	
	//문의 페이지 페이지 메이커
	public PageResponseDTO getQuestionsPageMaker(Criteria cri) {
		PageDTO pageMaker = null;
		List<Integer> pageNumList = new ArrayList<>();
		
		try {
			pageMaker = new PageDTO(cri, boardMapper.countQuestions(cri));
			
			for(int i=pageMaker.getPageStart(); i<=pageMaker.getPageEnd(); i++) {
				pageNumList.add(i);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		PageResponseDTO questionsPageResponseDTO = PageResponseDTO.builder()
				.pageMaker(pageMaker)
				.pageNumList(pageNumList)
				.build();
		
		return questionsPageResponseDTO;
	}

	
	//후기 페이지 페이지 메이커
	public PageResponseDTO getReviewsPageMaker(Criteria cri) {
		PageDTO pageMaker = null;
		List<Integer> pageNumList = new ArrayList<>();
		
		try {
			pageMaker = new PageDTO(cri, boardMapper.countReviews(cri));
			
			for(int i=pageMaker.getPageStart(); i<=pageMaker.getPageEnd(); i++) {
				pageNumList.add(i);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		PageResponseDTO reviewsPageResponseDTO = PageResponseDTO.builder()
				.pageMaker(pageMaker)
				.pageNumList(pageNumList)
				.build();
		
		return reviewsPageResponseDTO;
	}
	

	// 후기글 상세보기
	public BoardDTO reviewDetail(Integer k) throws Exception {
		return boardMapper.reviewDetail(k);
	}
	
	//후기글 삭제하기
	public int reviewDel(Integer k) throws Exception{
		return boardMapper.reviewDel(k);
	}

	//문의글 삭제하기
	public int qnaDel(Integer k) throws Exception{
		return boardMapper.qnaDel(k);
	}
	
	//후기글 수정하기
	public int boardEdit(int boardKey, String content) {
		int result = 0;
		
		
		try {			
			result = boardMapper.boardEdit(boardKey, content);
		}catch(Exception e) {
			System.out.println("Error Caused by at BoardService row 84 line");
			e.printStackTrace();
		}

		
		
		return result;
	}
	
	//상품 평균 평점 가져오기
	public int getRate(int itemKey) {
		
		int rate = 0;
		try {
			rate = boardMapper.getRate(itemKey);
			return rate;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	//후기 작성시 구매한 상품인지 확인하기
	public boolean searchedItemKey(BoardDTO boardDTO) {
		try {
			int payJudge = boardMapper.searchedItemKey(boardDTO);
			if(payJudge == 0) {
				return false;
			}else {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	//후기 수정시 작성했던 내용 가져오기
	public BoardDTO modifyReview(BoardDTO boardDTO) {
		BoardDTO boardDataDTO = new BoardDTO();
		try {
			boardDataDTO = boardMapper.modifyReview(boardDTO);
			return boardDataDTO;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
}
