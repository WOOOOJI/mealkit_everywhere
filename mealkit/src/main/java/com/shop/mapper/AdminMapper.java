package com.shop.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.shop.dto.AdminDTO;
import com.shop.frame.MyMapper;

@Repository
@Mapper
public interface AdminMapper extends MyMapper<Integer, AdminDTO>{

}
