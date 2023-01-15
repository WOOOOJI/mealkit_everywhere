package com.shop.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shop.dto.ItemDTO;
import com.shop.service.CartService;
import com.shop.service.ItemService;

@Controller
public class MainController {
	
	@Autowired
	ItemService iService;
	@Autowired
	CartService cService;
	
	
	@RequestMapping("/")
	public String main(Model model) {
		// 인기상품을 담을 리스트                                  			  ArrayList for bestItems
		List<ItemDTO> bestList = new ArrayList<ItemDTO>();
		// 신상품을 담을 리스트                                 				  ArrayList for newItems
		List<ItemDTO> newList = new ArrayList<ItemDTO>();
		
		
		
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
		
		// 세션값 가져오기. (int)req.getAttribute("cust_key");
		int cust_key = 3;
		
		
		try {
			model.addAttribute("cartCnt", cService.cntCart(cust_key));
		} catch (Exception e) {
			e.getMessage();
		}
		
		return "main";
	}
	// 장바구니 수량 보여주기 ------------------------------------------------------------------------------------------------------------

	
	
	

	
	
}
