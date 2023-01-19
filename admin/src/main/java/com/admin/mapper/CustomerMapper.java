package com.admin.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.admin.dto.CustomerDTO;
import com.admin.frame.MyMapper;

@Repository
@Mapper
public interface CustomerMapper extends MyMapper<Integer, CustomerDTO>{

}
	 