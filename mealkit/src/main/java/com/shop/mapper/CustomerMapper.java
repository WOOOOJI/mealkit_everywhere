package com.shop.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.shop.dto.CustomerDTO;
import com.shop.frame.MyMapper;

@Repository
@Mapper
public interface CustomerMapper extends MyMapper<Integer, CustomerDTO>{

}
