package com.shop.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.shop.dto.CategoryDTO;
import com.shop.frame.MyMapper;

@Repository
@Mapper
public interface CategoryMapper extends MyMapper<Integer, CategoryDTO>{

}
