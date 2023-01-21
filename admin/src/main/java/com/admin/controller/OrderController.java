package com.admin.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.admin.dto.Criteria;
import com.admin.dto.OrderDTO;
import com.admin.dto.response.ItemPageResponseDTO;
import com.admin.service.OrderService;


@Controller
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	OrderService oService;
	
	
	String dir = "order/";
	
	
	
	// 주문관리 페이지 이동
	@RequestMapping("")
	public String orderManage(Model model, Criteria cri, @RequestParam(defaultValue="1", value="pageNum") int pageNum, String keyword, String type, String orderBy) {
		
		
		List<OrderDTO> orderList = null;
		//ItemPageResponseDTO(active, pageNumList, content를 묶어주기 위한 DTO) 선언 및 초기화
		ItemPageResponseDTO itemPageResponseDTO = oService.getOrderPageMaker(cri);
		
		orderList = oService.getOrderList(cri, keyword, type, orderBy);
		
		//
		if(!orderList.isEmpty()) {
			model.addAttribute("orderList", orderList);
		}else {
			model.addAttribute("nothing", dir+"nothing");
		}
		
		
		model.addAttribute("content", dir+"orderlist");
		model.addAttribute("navbar", dir+"navbar");
		model.addAttribute("active", itemPageResponseDTO.getActive());
		model.addAttribute("pageNumList", itemPageResponseDTO.getPageNumList());
		model.addAttribute("pageMaker", itemPageResponseDTO.getPageMaker());		
		model.addAttribute("pageNum", pageNum);		
		
		
		return "main";
	}
	
	
	
	// 주문 상세 보기 페이지로 이동
	
}
