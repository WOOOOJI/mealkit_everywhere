package com.admin.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.admin.dto.BoardDTO;
import com.admin.frame.MyMapper;

@Repository
@Mapper
public interface BoardMapper extends MyMapper<Integer, BoardDTO>{
	
	
}
