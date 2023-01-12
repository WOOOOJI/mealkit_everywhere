package com.shop.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.shop.dto.AddressDTO;
import com.shop.frame.MyMapper;

@Repository
@Mapper
public interface AddressMapper extends MyMapper<Integer, AddressDTO>{

}
