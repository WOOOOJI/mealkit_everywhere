package com.admin.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.admin.dto.OrderDTO;

@Mapper
@Repository
public interface AnalyzeMapper {
	
	
	
	public OrderDTO dashBoardCardYear(String year) throws Exception;
	public OrderDTO dashBoardCardMonth(String year, String month) throws Exception;
	public OrderDTO dashBoardCardDay(String year, String month, String day) throws Exception;
	
	
}
