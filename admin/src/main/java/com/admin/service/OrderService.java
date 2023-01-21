package com.admin.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.dto.OrderDTO;
import com.admin.frame.MyService;
import com.admin.mapper.OrderMapper;
import com.admin.dto.Criteria;
import com.admin.dto.PageDTO;
import com.admin.dto.response.ItemPageResponseDTO;

@Service
public class OrderService implements MyService<Integer, OrderDTO> {

	@Autowired
	OrderMapper orderMapper;

	@Override
	public void register(OrderDTO v) throws Exception {

	}

	@Override
	public void remove(Integer k) throws Exception {

	}

	@Override
	public void modify(OrderDTO v) throws Exception {
	}

	@Override
	public OrderDTO get(Integer k) throws Exception {
		return orderMapper.select(k);
	}

	@Override
	public List<OrderDTO> get() throws Exception {
		return orderMapper.selectall();
	}

	
	
	
	// 페이징 처리를 위해서 설정한 개수만큼의 공지사항 페이지 리스트 가져오기
	public List<OrderDTO> getOrderList(Criteria cri, String keyword, String type, String orderBy){
		try {
			return orderMapper.getOrderList(cri, keyword, type, orderBy);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	
	
	// 공지사항 페이징에 필요한 데이터 가져오기
	public ItemPageResponseDTO getOrderPageMaker(Criteria cri) {
		
		PageDTO pageMaker = null;
		int active = 0;
		List<Integer> pageNumList = new ArrayList<>();

		try {
			pageMaker = new PageDTO(cri, orderMapper.countOrder(cri));

			for (int i = pageMaker.getPageStart(); i <= pageMaker.getPageEnd(); i++) {
				pageNumList.add(i);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		/*
		 * if(pageMaker.getCri().getPageNum() == i) { active = 1; }else { active = 0; }
		 */

		ItemPageResponseDTO itemPageResponseDTO = ItemPageResponseDTO.builder().pageMaker(pageMaker).active(active)
				.pageNumList(pageNumList).build();


		return itemPageResponseDTO;

	}
	
	
	
	
	
	// 공지사항 페이지 전체 개수 가져오기
	public int countNotice(Criteria cri) throws Exception{
		return orderMapper.countOrder(cri);
	}
	
	
	
	
	
	
	
	
	

}
