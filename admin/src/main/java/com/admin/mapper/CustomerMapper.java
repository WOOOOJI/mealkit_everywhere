package com.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.admin.dto.Criteria;
import com.admin.dto.CustomerDTO;
import com.admin.frame.MyMapper;

@Repository
@Mapper
public interface CustomerMapper extends MyMapper<Integer, CustomerDTO>{
	
	//회원 리스트 조회
	public List<CustomerDTO> getCustList(Criteria cri) throws Exception;
	
	//회원 수 카운트
	public int countCust(Criteria cri) throws Exception;
	

	//회원 차단 설정
	public void changeLocked(CustomerDTO customerDTO) throws Exception;
}
	 