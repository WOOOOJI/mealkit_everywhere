package com.shop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.dto.Criteria;
import com.shop.dto.ItemDTO;
import com.shop.dto.PageDTO;
import com.shop.dto.response.ItemPageResponseDTO;
import com.shop.frame.MyService;
import com.shop.mapper.ItemMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ItemService implements MyService<Integer, ItemDTO>{

	@Autowired
	ItemMapper itemMapper;
	
	
	@Override
	public void register(ItemDTO itemDto) throws Exception {
		itemMapper.insert(itemDto);
	}

	@Override
	public void remove(Integer itemKey) throws Exception {
		itemMapper.delete(itemKey);
	}

	@Override
	public void modify(ItemDTO itemDto) throws Exception {
		itemMapper.update(itemDto);
	}

	@Override
	public ItemDTO get(Integer itemKey) throws Exception {
		return itemMapper.select(itemKey);
	}

	@Override
	public List<ItemDTO> get() throws Exception {
		return itemMapper.selectall();
	}
	
	
	public List<ItemDTO> getItemList(Criteria cri){
		try {
			return itemMapper.getItemList(cri);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public List<ItemDTO> getKoreanItemList(Criteria cri){
		try {
			return itemMapper.getKoreanItemList(cri);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public List<ItemDTO> getJapaneseItemList(Criteria cri){
		try {
			return itemMapper.getJapaneseItemList(cri);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public List<ItemDTO> getChineseItemList(Criteria cri){
		try {
			return itemMapper.getChineseItemList(cri);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public List<ItemDTO> getSouthAsiaItemList(Criteria cri){
		try {
			return itemMapper.getSouthAsiaItemList(cri);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//모든 상품 세기
	public int countItem(Criteria cri) throws Exception{
		return itemMapper.countItem(cri);
	}
	
	
	//모든 상품 페이지 메이커
	public ItemPageResponseDTO getItemPageMaker(Criteria cri) {
		PageDTO pageMaker = null;
		int active = 0;
		List<Integer> pageNumList = new ArrayList<>();
		
		try {
			pageMaker = new PageDTO(cri, itemMapper.countItem(cri));

			for(int i=pageMaker.getPageStart(); i<=pageMaker.getPageEnd(); i++) {
				pageNumList.add(i);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		/*
		 * if(pageMaker.getCri().getPageNum() == i) { active = 1; }else { active = 0; }
		 */
		
		ItemPageResponseDTO itemPageResponseDTO = ItemPageResponseDTO.builder()
				.pageMaker(pageMaker)
				.active(active)
				.pageNumList(pageNumList)
				.build();
		
		
		
		log.info("ItemService 97th line"+itemPageResponseDTO.toString());
		
		return itemPageResponseDTO;
		
//		return ItemPageResponseDTO.builder()
//		.pageMaker(pageMaker)
//		.active(active)
//		.pageNumList(pageNumList)
//		.build();
	}
	
	
	//한국 카테고리 페이지 메이커
	public ItemPageResponseDTO getKoreanItemPageMaker(Criteria cri) {
		PageDTO pageMaker = null;
		int active = 0;
		List<Integer> pageNumList = new ArrayList<>();
		
		try {
			pageMaker = new PageDTO(cri, itemMapper.countKoreanItem(cri));
			
			for(int i=pageMaker.getPageStart(); i<=pageMaker.getPageEnd(); i++) {
				pageNumList.add(i);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ItemPageResponseDTO.builder()
				.pageMaker(pageMaker)
				.active(active)
				.pageNumList(pageNumList)
				.build();
	}
	
	//일본 카테고리 페이지 메이커
	public ItemPageResponseDTO getJapaneseItemPageMaker(Criteria cri) {
		PageDTO pageMaker = null;
		int active = 0;
		List<Integer> pageNumList = new ArrayList<>();
		
		try {
			pageMaker = new PageDTO(cri, itemMapper.countJapaneseItem(cri));
			
			for(int i=pageMaker.getPageStart(); i<=pageMaker.getPageEnd(); i++) {
				pageNumList.add(i);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return ItemPageResponseDTO.builder()
				.pageMaker(pageMaker)
				.active(active)
				.pageNumList(pageNumList)
				.build();
	}

	
	//중국 카테고리 페이지 메이커
	public ItemPageResponseDTO getChineseItemPageMaker(Criteria cri) {
		PageDTO pageMaker = null;
		int active = 0;
		List<Integer> pageNumList = new ArrayList<>();
		
		try {
			pageMaker = new PageDTO(cri, itemMapper.countChineseItem(cri));
			
			for(int i=pageMaker.getPageStart(); i<=pageMaker.getPageEnd(); i++) {
				pageNumList.add(i);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ItemPageResponseDTO.builder()
				.pageMaker(pageMaker)
				.active(active)
				.pageNumList(pageNumList)
				.build();
	}
	
	
	//동남아 카테고리 페이지 메이커
	public ItemPageResponseDTO getSouthAsiaItemPageMaker(Criteria cri) {
		PageDTO pageMaker = null;
		int active = 0;
		List<Integer> pageNumList = new ArrayList<>();
		
		try {
			pageMaker = new PageDTO(cri, itemMapper.countSouthAsiaItem(cri));
			
			for(int i=pageMaker.getPageStart(); i<=pageMaker.getPageEnd(); i++) {
				pageNumList.add(i);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ItemPageResponseDTO.builder()
				.pageMaker(pageMaker)
				.active(active)
				.pageNumList(pageNumList)
				.build();
	}

}
