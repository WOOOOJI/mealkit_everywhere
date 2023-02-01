package com.admin.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.admin.dto.OrderDTO;

@Mapper
@Repository
public interface RealTimeAnalyzeMapper {
	
	
	
	// 실시간 대쉬보드 현황
	public OrderDTO realTimeDashBoard(String NOWDATE, String NOWTIME) throws Exception;
	// 누적 대쉬보드 현황
	public OrderDTO totalTimeDashBoard(String NOWDATE) throws Exception;
}
