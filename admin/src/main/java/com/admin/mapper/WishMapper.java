package com.admin.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.admin.dto.WishDTO;
import com.admin.frame.MyMapper;

@Repository
@Mapper
public interface WishMapper extends MyMapper<Integer, WishDTO>{

}
