package com.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.admin.dto.Criteria;
import com.admin.dto.OrderDTO;
import com.admin.frame.MyMapper;

@Repository
@Mapper
public interface OrderMapper extends MyMapper<Integer, OrderDTO>{
		
	
	
	
	// 주문리스트 --------------------------------------------------------------------------
	
	// 페이징 처리를 위해 설정한 갯수만큼 공지사항 페이지를 가져온다.
	public List<OrderDTO> getOrderList(Criteria cri, String keyword, String type, String orderBy) throws Exception;
	
	// 공지사항 페이지 총 갯수
	public int countOrder(Criteria cri) throws Exception;
	
	// 해당 이벤트 페이지 정보 가져오기
	public OrderDTO OrderDetail(int OrderKey) throws Exception;
	
	
	
	
}
