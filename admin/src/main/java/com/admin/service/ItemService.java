package com.admin.service;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.dto.Criteria;
import com.admin.dto.ItemDTO;
import com.admin.dto.PageDTO;
import com.admin.dto.response.PageResponseDTO;
import com.admin.frame.MyService;
import com.admin.mapper.ItemMapper;

@Service
public class ItemService implements MyService<Integer, ItemDTO> {

	@Autowired
	ItemMapper itemMapper;

	@Override
	public void register(ItemDTO itemDto) throws Exception {
		itemMapper.insert(itemDto);
	}

	@Override
	public void remove(Integer itemKey) {
		try {
			itemMapper.delete(itemKey);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void modify(ItemDTO itemDto) {
		try {
			itemMapper.update(itemDto);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public ItemDTO get(Integer itemKey) {
		ItemDTO result = null;
		try {
			result = itemMapper.select(itemKey);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<ItemDTO> get() {
		List<ItemDTO> result = null;
		try {
			result = itemMapper.selectall();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public void registerItem(ItemDTO item) throws Exception {
		itemMapper.registerItem(item);
	}

	public void deleted(int itemKey) {
		try {
			itemMapper.deleted(itemKey);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<ItemDTO> getItemList(Criteria cri){
		try {
			return itemMapper.getItemList(cri);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	// 모든 이벤트 페이지 개수 가져오기
	public int countEvent(Criteria cri) throws Exception{
		return itemMapper.countItem(cri);
	}

	// 상품 관리 리스트 페이징
	public PageResponseDTO getItemPageMaker(Criteria cri) {
		PageDTO pageMaker = null;
		int active = 0;
		List<Integer> pageNumList = new ArrayList<>();

		try {
			pageMaker = new PageDTO(cri, itemMapper.countItem(cri));

			for (int i = pageMaker.getPageStart(); i <= pageMaker.getPageEnd(); i++) {
				pageNumList.add(i);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		/*
		 * if(pageMaker.getCri().getPageNum() == i) { active = 1; }else { active = 0; }
		 */

		PageResponseDTO pageResponseDTO = PageResponseDTO.builder()
				.pageMaker(pageMaker)
				.active(active)
				.pageNumList(pageNumList)
				.build();

		return pageResponseDTO;

	}
}
