package com.admin.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.dto.BoardDTO;
import com.admin.frame.MyService;
import com.admin.mapper.BoardMapper;
import com.admin.dto.response.ItemPageResponseDTO;
import com.admin.dto.PageDTO;
import com.admin.dto.Criteria;


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

	//선택한 문의글 삭제
	public int qnaDel(int boardKey) {
		int result=0;
		try {
			result = mapper.qnaDel(boardKey);
		}catch(Exception e) {
			e.printStackTrace();
		}
			return result;
	}
	
	// 문의글 상세보기
	public BoardDTO qnaDetail(Integer k) throws Exception {
		return mapper.qnaDetail(k);
	}
	
	//문의글 삭제하기
	public int qnaDelete(Integer k) throws Exception{
		return mapper.qnaDelete(k);
	}

	//------------------------후기-------------------------------------
	
	//선택한 후기글 삭제
	public int reviewDel(int boardKey) {
		int result=0;
		try {
			result = mapper.qnaDel(boardKey);
		}catch(Exception e) {
			e.printStackTrace();
		}
			return result;
	}
	
	// 후기글 상세보기
	public BoardDTO reviewDetail(Integer k) throws Exception {
		return mapper.reviewDetail(k);
	}
	
	//후기글 삭제하기
	public int reviewDelete(Integer k) throws Exception{
		return mapper.reviewDelete(k);
	}
	
	//-------------------------페이징------------------------------------------
	//문의 목록 조회
	public List<BoardDTO> getQnaList(Criteria cri){
		try {
			return mapper.getQnaList(cri);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//전체 문의 개수 가져오기
	public int countQna(Criteria cri) throws Exception{
		return mapper.countQna(cri);
	}
	
	// 문의 페이지 메이커
	public ItemPageResponseDTO getQnaPageMaker(Criteria cri) {
		PageDTO pageMaker = null;
		int active = 0;
		List<Integer> pageNumList = new ArrayList<>();
		
		try {
			pageMaker = new PageDTO(cri, mapper.countQna(cri));
			
			for(int i=pageMaker.getPageStart(); i<=pageMaker.getPageEnd(); i++) {
				pageNumList.add(i);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		ItemPageResponseDTO itemPageResponseDTO = ItemPageResponseDTO.builder()
				.pageMaker(pageMaker)
				.active(active)
				.pageNumList(pageNumList)
				.build();
		
		return itemPageResponseDTO;
	}
	
	
	//후기 목록 조회
	public List<BoardDTO> getReviewList(Criteria cri){
		try {
			return mapper.getReviewList(cri);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//전체 후기 개수 가져오기
	public int countReview(Criteria cri) throws Exception{
		return mapper.countReview(cri);
	}
	
	// 후기 페이지 메이커
	public ItemPageResponseDTO getReviewPageMaker(Criteria cri) {
		PageDTO pageMaker = null;
		int active = 0;
		List<Integer> pageNumList = new ArrayList<>();
		
		try {
			pageMaker = new PageDTO(cri, mapper.countReview(cri));
			
			for(int i=pageMaker.getPageStart(); i<=pageMaker.getPageEnd(); i++) {
				pageNumList.add(i);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		ItemPageResponseDTO itemPageResponseDTO = ItemPageResponseDTO.builder()
				.pageMaker(pageMaker)
				.active(active)
				.pageNumList(pageNumList)
				.build();
		
		return itemPageResponseDTO;
	}
	
}
