package com.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.admin.dto.FilterdDTO;
import com.admin.dto.ItemDTO;
import com.admin.dto.OrderDTO;

@Mapper
@Repository
public interface AnalyzeMapper {

	// 카테고리별 연간 분석 (판매액,판매량)
	public List<ItemDTO> categoryYearAnalyze(String year) throws Exception;

	// 카테고리별 월간 분석 (판매액, 판매량)
	public List<ItemDTO> categoryMonthAnalyze(String year, String month) throws Exception;

	// 카테고리별 일간 분석 (판매액, 판매량)
	public List<ItemDTO> categoryDayAnalyze(String year, String month, String day) throws Exception;

	// 특정 년도의 매출차트 데이터 가져오기(월 별)
	public List<OrderDTO> yearSalesChart(String year) throws Exception;

	// 특정 년도의 매출차트 데이터 가져오기(월 별)
	public List<OrderDTO> monthSalesChart(String year, String month) throws Exception;

	// 특정 년도의 매출차트 데이터 가져오기(월 별)
	public List<OrderDTO> daySalesChart(String year, String month, String day) throws Exception;

	
	
	public OrderDTO dashBoardCardYear(String year) throws Exception;
	public OrderDTO dashBoardCardMonth(String year, String month) throws Exception;
	public OrderDTO dashBoardCardDay(String year, String month, String day) throws Exception;
	
	
	
	// 상세 검색된 상품 리스트
	public List<FilterdDTO> filterdData(FilterdDTO filterdDTO) throws Exception; 

	//나이대별 판매개수 구하기
	public List<OrderDTO> ageRangeSales(int categoryKey, String gender, String gender1, String gender2, String startDate, String endDate) throws Exception;

	//상세검색 배송량, 판매액, 구매확정 
	public OrderDTO dashBoardCardDetail(String startDate, String endDate, String gender, String gender1, String gender2, String age, int categoryKey) throws Exception;

	//성별 판매량 구하기
	public List<OrderDTO> genderSales(int categoryKey, String age, String startDate, String endDate) throws Exception;

}
