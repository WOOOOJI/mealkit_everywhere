package com.shop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.shop.dto.Criteria;
import com.shop.dto.NoticeDTO;
import com.shop.dto.OrderDetailDTO;
import com.shop.frame.MyMapper;

@Repository
@Mapper
public interface NoticeMapper extends MyMapper<Integer, NoticeDTO>{

	
	// 이벤트--------------------------------------------------------------------------
	
	
	// 페이징 처리를 위해 설정한 갯수만큼 이벤트페이지를 가져온다.
	public List<NoticeDTO> getEventList(Criteria cri) throws Exception;
	
	// 이벤트페이지 총 갯수
	public int countEvent(Criteria cri) throws Exception;
	
	// 해당 이벤트 페이지 정보 가져오기
	public NoticeDTO eventDetail(int noticeKey) throws Exception;
	
	
	
	
	// 공지사항--------------------------------------------------------------------------
	
	// 페이징 처리를 위해 설정한 갯수만큼 공지사항 페이지를 가져온다.
	public List<NoticeDTO> getNoticeList(Criteria cri) throws Exception;
	
	// 공지사항 페이지 총 갯수
	public int countNotice(Criteria cri) throws Exception;
	
	// 해당 이벤트 페이지 정보 가져오기
	public NoticeDTO noticeDetail(int noticeKey) throws Exception;
	
	
	
	
	
	// 해당 페이지 접속시 조회수 증가
	public void noticeHit(int noticeKey) throws Exception;
	
	
	// 지금까지 팔린 상품 총갯수 구하기
	public List<OrderDetailDTO> sumCnt() throws Exception;
	
}
