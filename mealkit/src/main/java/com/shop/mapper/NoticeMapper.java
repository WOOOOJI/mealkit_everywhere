package com.shop.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.shop.dto.NoticeDTO;
import com.shop.frame.MyMapper;

@Repository
@Mapper
public interface NoticeMapper extends MyMapper<Integer, NoticeDTO>{

}
