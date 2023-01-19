package com.shop.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.shop.dto.CommentsDTO;
import com.shop.frame.MyMapper;
@Repository
@Mapper
public interface CommentsMapper extends MyMapper<Integer, CommentsDTO>{

	//관리자 답변
	public CommentsDTO qnaReply(int board_key) throws Exception; 
}
