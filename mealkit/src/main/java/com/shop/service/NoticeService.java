package com.shop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.dto.Criteria;
import com.shop.dto.NoticeDTO;
import com.shop.dto.PageDTO;
import com.shop.dto.response.ItemPageResponseDTO;
import com.shop.frame.MyService;
import com.shop.mapper.NoticeMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
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
	
	
	// 페이징 처리를 위해서 설정한 개수만큼의 이벤트 페이지 리스트 가져오기
	public List<NoticeDTO> getEventList(Criteria cri){
		try {
			return noticeMapper.getEventList(cri);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	// 모든 이벤트 페이지 개수 가져오기
	public int countEvent(Criteria cri) throws Exception{
		return noticeMapper.countEvent(cri);
	}
	
	
	// 이벤트 리스트 페이징
	public ItemPageResponseDTO getEventPageMaker(Criteria cri) {
		PageDTO pageMaker = null;
		int active = 0;
		List<Integer> pageNumList = new ArrayList<>();
		
		try {
			pageMaker = new PageDTO(cri, noticeMapper.countEvent(cri));

			for(int i=pageMaker.getPageStart(); i<=pageMaker.getPageEnd(); i++) {
				pageNumList.add(i);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		/*
		 * if(pageMaker.getCri().getPageNum() == i) { active = 1; }else { active = 0; }
		 */
		
		ItemPageResponseDTO itemPageResponseDTO = ItemPageResponseDTO.builder()
				.pageMaker(pageMaker)
				.active(active)
				.pageNumList(pageNumList)
				.build();
		
		
		
		log.info("ItemService 97th line"+itemPageResponseDTO.toString());
		
		return itemPageResponseDTO;

	}
	
	// 이벤트 상세 페이지 접속시 필요한 데이터 가져오기
	public NoticeDTO eventDetail(int notice_key) {
		NoticeDTO dto = new NoticeDTO();
		try {
			dto = noticeMapper.eventDetail(notice_key);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dto;
	}
	

	
	
	
	// -------------------------------------------------------------------------------------------------
	
	// 페이징 처리를 위해서 설정한 개수만큼의 공지사항 페이지 리스트 가져오기
		public List<NoticeDTO> getNoticeList(Criteria cri){
			try {
				return noticeMapper.getNoticeList(cri);
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		
		
		// 공지사항 페이지 전체 개수 가져오기
		public int countNotice(Criteria cri) throws Exception{
			return noticeMapper.countNotice(cri);
		}
		
		
		// 공지사항 페이징에 필요한 데이터 가져오기
		public ItemPageResponseDTO getNoticePageMaker(Criteria cri) {
			PageDTO pageMaker = null;
			int active = 0;
			List<Integer> pageNumList = new ArrayList<>();
			
			try {
				pageMaker = new PageDTO(cri, noticeMapper.countNotice(cri));

				for(int i=pageMaker.getPageStart(); i<=pageMaker.getPageEnd(); i++) {
					pageNumList.add(i);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			/*
			 * if(pageMaker.getCri().getPageNum() == i) { active = 1; }else { active = 0; }
			 */
			
			ItemPageResponseDTO itemPageResponseDTO = ItemPageResponseDTO.builder()
					.pageMaker(pageMaker)
					.active(active)
					.pageNumList(pageNumList)
					.build();
			
			
			
			log.info("ItemService 97th line"+itemPageResponseDTO.toString());
			
			return itemPageResponseDTO;

		}
		
		// 공지사항 상세 페이지 접속시 필요한 데이터 가져오기
		public NoticeDTO noticeDetail(int notice_key) {
			NoticeDTO dto = new NoticeDTO();
			try {
				dto = noticeMapper.noticeDetail(notice_key);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return dto;
		}
	
		
	
		// -------------------------------------------------------------------------------------------------------------------------------
		
		
		
		
		
		// 상세 페이지 접속시 조회수 1 증가
		public void noticeHit(int notice_key) {
			try {
				noticeMapper.noticeHit(notice_key);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	
	
}
