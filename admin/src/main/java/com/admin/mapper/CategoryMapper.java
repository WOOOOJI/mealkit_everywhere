package com.admin.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.admin.dto.CategoryDTO;
import com.admin.frame.MyMapper;

@Repository
@Mapper
public interface CategoryMapper extends MyMapper<Integer, CategoryDTO>{

}
