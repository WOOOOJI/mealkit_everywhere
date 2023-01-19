package com.admin.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.admin.dto.AddressDTO;
import com.admin.frame.MyMapper;

@Repository
@Mapper
public interface AddressMapper extends MyMapper<Integer, AddressDTO>{

}
