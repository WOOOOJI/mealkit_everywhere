package com.shop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.shop.dto.AddressDTO;
import com.shop.frame.MyMapper;

@Repository
@Mapper
public interface AddressMapper extends MyMapper<Integer, AddressDTO>{
	//기본 배송지 확인
	public AddressDTO check_default(int cust_key) throws Exception;
	//회원의 배송지 확인
	public List<AddressDTO> user_addr(int cust_key) throws Exception;
	//addr_key를 이용하여 주소지 가져오기
	public AddressDTO addr_key(int addr_key) throws Exception;
}
