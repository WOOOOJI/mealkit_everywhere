package com.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.admin.dto.Criteria;
import com.admin.dto.CustomerDTO;
import com.admin.dto.ItemDTO;
import com.admin.dto.OrderDTO;
import com.admin.frame.MyMapper;

@Repository
@Mapper
public interface OrderMapper extends MyMapper<Integer, OrderDTO>{
		
	
	
	
	// 주문리스트 --------------------------------------------------------------------------
	
	// 페이징 처리를 위해 설정한 갯수만큼 공지사항 페이지를 가져온다.
	public List<OrderDTO> getOrderList(Criteria cri) throws Exception;
	
	// 공지사항 페이지 총 갯수
	public int countOrder(Criteria cri) throws Exception;
	
	// 해당 이벤트 페이지 정보 가져오기
	public OrderDTO OrderDetail(int OrderKey) throws Exception;
	
	// 주문 상태 변경
	public int statusChange(String status, int orderKey) throws Exception;
	
	// 주문명세서에 해당되는 주문아이템의 상세 정보 가져오기
	public List<ItemDTO> getOrderDetail(int orderKey) throws Exception;
	
	// 구매한 회원의 정보 가져오기
	public CustomerDTO getCustInfo(int orderKey) throws Exception;
	
	// 주문을 받는 분의 정보 가져오기
	public OrderDTO getToWho(int orderKey) throws Exception;
	
	// 운송장번호 입력 및 수정 (삭제는 없음)
	public int insertTrackingNum(String trackingNum, int orderKey) throws Exception;
	
	
	
	// TOP10, BOT10, 매출 차트 데이터 ===================================================================

	// 연도별 TOP10 리스트
	public List<OrderDTO> getYearTOP10List(String year) throws Exception;

	// 연도별 BOT10 리스트	
	public List<OrderDTO> getYearBOT10List(String year) throws Exception;

	// 월별 TOP10 리스트	
	public List<OrderDTO> getMonthTOP10List(String month) throws Exception;
	
	// 월별 BOT10 리스트	
	public List<OrderDTO> getMonthBOT10List(String month) throws Exception;
	
	// 일별 TOP10 리스트	
	public List<OrderDTO> getDayTOP10List(String day) throws Exception;
	
	// 일별 BOT10 리스트	
	public List<OrderDTO> getDayBOT10List(String day) throws Exception;
	
	
	
}
