package com.admin.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.admin.dto.OrderDetailDTO;
import com.admin.frame.MyMapper;

@Repository
@Mapper
public interface OrderDetailMapper extends MyMapper<Integer, OrderDetailDTO>{

}
