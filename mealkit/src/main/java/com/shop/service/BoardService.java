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
	
	//모든 문의 페이지 페이지 메이커
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

	
	//모든 후기 페이지 페이지 메이커
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


	// 나의 문의 목록
	public List<BoardDTO> qnaList(Integer k) throws Exception {
		return boardMapper.qnaList(k);
	}
	

	// 나의 후기 목록
	public List<BoardDTO> reviewList(Integer k) throws Exception {
		return boardMapper.reviewList(k);
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
	
}
