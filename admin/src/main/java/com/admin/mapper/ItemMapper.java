package com.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.admin.dto.Criteria;
import com.admin.dto.ItemDTO;
import com.admin.frame.MyMapper;

@Repository
@Mapper
public interface ItemMapper extends MyMapper<Integer, ItemDTO>{
	public void registerItem(ItemDTO item) throws Exception;
	public void deleted(int itemKey) throws Exception;
	
	// 페이징처리--------------------------------------------------------------------------
	// 페이징 처리를 위해 설정한 갯수만큼 상품관리페이지를 가져온다.
	public List<ItemDTO> getItemList(Criteria cri) throws Exception;
	
	// 상품관리페이지 총 갯수
	public int countItem(Criteria cri) throws Exception;
	
	// 해당 상품관리 페이지 정보 가져오기
	public ItemDTO itemDetail(int itemKey) throws Exception;
}
