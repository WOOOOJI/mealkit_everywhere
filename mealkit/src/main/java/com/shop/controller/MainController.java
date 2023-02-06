package com.shop.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shop.dto.CustomerDTO;
import com.shop.dto.ItemDTO;
import com.shop.service.CartService;
import com.shop.service.CustomerService;
import com.shop.service.ItemService;
import com.shop.service.NoticeService;

@Controller
public class MainController {
	
	@Autowired
	ItemService iService;
	@Autowired
	CartService cService;
	
	@Autowired
	NoticeService noticeService;
	
	@Autowired
	CustomerService customerService;
	
	@RequestMapping("/")
	public String main(Model model, HttpServletRequest req) {
		// 인기상품을 담을 리스트                                  			  ArrayList for bestItems
		List<ItemDTO> bestList = new ArrayList<ItemDTO>();
		// 신상품을 담을 리스트                                 				  ArrayList for newItems
		List<ItemDTO> newList = new ArrayList<ItemDTO>();
		
		// 지금까지 팔린 총 상품수
		int sumCnt = 0;
		// 지금까지 총 회원수를 구하기 위한 List 객체		
		List<CustomerDTO> sumCust = null;
		
		// 전체 SELECT 한 orderDetailDTO List객체 받아오기
		sumCnt = noticeService.sumCnt();
		// 전체 SELECT 한 CustomerDTO List객체 받아오기
		sumCust = customerService.get();
		
		
		// 총 회원수
		int custSum = 0;
		
		// 위 아래 for문은 각 list에 담긴 객체를 하나씩 꺼내 총합을 구하기 위함임.
		for(int i=0; i<sumCust.size(); i++) {
			custSum += 1;
		}
		
		
		
		
		// 	뷰단에 뿌리기 위한 attribute.
		model.addAttribute("sum", sumCnt);
		model.addAttribute("custSum", custSum);
		
		
		// 인기상품 ----------------------------------------------------------------------------------------------------------------------
		try {
			// 인기상품 리스트를 받아온다                        			      get BESTITEMS from service Object - Method bestItme()
			bestList = iService.bestItem();
		} catch (Exception e) {
			// 에러발생시 에러문 출력                        			          Errors Cause By
			System.out.println("Failed to Select best items"); 
		}
		
		
		
		// 각각의 베스트 아이템의 Index에 해당되는 할인율을 구해서 set 해주기           SELECT Each of bestItem & calculate sale % And Setting each items
		int bestIdx=0;
		for(ItemDTO i : bestList) {
			double temp = ((double)(i.getPrice()-i.getSale()));
			temp = Math.round((temp/i.getPrice()) * 100);
			bestList.get(bestIdx).setPer((int)temp);
			bestIdx++;
			
		}
		
		// 완성된 bestItem List를 Attribute 해주기						      addAttribute bestItem's list instance named by bestList                 
		model.addAttribute("bestList", bestList);
		// 인기상품 ----------------------------------------------------------------------------------------------------------------------		
		
		
		
		
		
		
		// 신상품   ----------------------------------------------------------------------------------------------------------------------
		// 위 베스트 상품 리스트 가져오기랑 동일하다.
		try {
			newList = iService.newItem();
		} catch (Exception e) {
			System.out.println("Failed to Select new items");
			e.printStackTrace();
		}
		
		
		
		int newIdx=0;
		for(ItemDTO i : newList) {
			double temp = ((double)(i.getPrice()-i.getSale()));
			temp = Math.round((temp/i.getPrice()) * 100);
			newList.get(newIdx).setPer((int)temp);
			newIdx++;
			
			
		}
		
		model.addAttribute("newList", newList);
		// 신상품   ----------------------------------------------------------------------------------------------------------------------		
		
		
		
		
		// 장바구니 수량 보여주기 ------------------------------------------------------------------------------------------------------------
		
		// 세션값 가져오기. (int)req.getAttribute("custKey");
		
		
		
//		if((int)session.getAttribute("custKey")==0) {
//			
//		}else {
//			int custKey = (int)session.getAttribute("custKey");
//			try {
//				model.addAttribute("cartCnt", cService.cntCart(custKey));
//			} catch (Exception e) {
//				e.getMessage();
//			}
//		}
		
		
		
		return "main";
	}
	

	
}
