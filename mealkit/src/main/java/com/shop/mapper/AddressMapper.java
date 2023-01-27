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
	public AddressDTO checkDefault(int custKey) throws Exception;
	//회원의 배송지 확인
	public List<AddressDTO> userAddr(int custKey) throws Exception;
	//addrKey를 이용하여 주소지 가져오기
	public AddressDTO addrKey(int addrKey) throws Exception;
	//배송지 추가하기
	public void insertAddress(int custKey,AddressDTO address) throws Exception;
	//배송지 삭제하기
}
