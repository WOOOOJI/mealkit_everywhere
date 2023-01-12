package com.shop.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.shop.dto.OrderDTO;
import com.shop.frame.MyMapper;

@Repository
@Mapper
public interface OrderMapper extends MyMapper<Integer, OrderDTO>{

}
