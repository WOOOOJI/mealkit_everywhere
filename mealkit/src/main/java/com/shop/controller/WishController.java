package com.shop.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shop.dto.WishDTO;
import com.shop.service.WishService;

@Controller
public class WishController {
	
	@Autowired
	WishService service;
	
	
	// html을 관리하는 폴더 경로
		String dir = "wish/";
		
		// 찜 페이지로 이동       
		@GetMapping("/wish/list")
		public String wishPage(Model model, HttpServletRequest req) {
			
			HttpSession session = req.getSession();
			

			int custKey = (int)session.getAttribute("custKey");
		//	System.out.println(custKey);

			
			// 세션값이 없으면 로그인이 안되있는 상태 이므로 애초에 찜리스트 페이지로 못온다.     
			// 세션값을 받은게 있다면 찜리스트 페이지로 이동.                             
			
				
				
				// Model 객체에 세션값과 일치하는 사용자의 찜리스트 정보를 담아야 한다.      
				// 이때 담겨있는 제품이 한개일수도 여러개 일수도 있다 -> ArrayList로 받아온다.   
				List<WishDTO> wishList = new ArrayList<WishDTO>();
				try {
					wishList = service.WishList(custKey);
				} catch (Exception e) {
					e.printStackTrace();
				//	System.out.println("----------------------------");
				}
				
				
				// Model 객체에 찜 리스트를 담아준다.                              
				model.addAttribute("list", wishList);
				// content에 wish.html을 담아준다.									 
				model.addAttribute("content", dir+"wish");
				// Test용 출력문 -> ArrayList가 비어있지 않은지 확인해준다.               
				// System.out.println(wishList.toString());
				

			// 세션값이 없으면 중간에 찜 페이지로 리턴 되지 않고, 마지막에 login페이지로 return한다.    without sessionValue, don't stop At 28 rows (return cart). must move to login.html  
			return "main";
		}	
		
		
		
		
		// 찜 아이템 삭제.        
			@ResponseBody
			@PostMapping("/wish/delete")
			public int wishList(int custKey) {
				int result=0;
			//	System.out.println(custKey);
				
				
				
				// 표기법 통일
				
				
				
				try {
					service.remove(custKey);
					result=1;
				} catch (Exception e) {
				//	System.out.println("찜리스트 삭제 실패--------------------------");
					e.printStackTrace();
				}
				
				return result;
			}
	
			

		// 찜에 상품 담기.          
			@GetMapping("/wish/wishInsertToMain")
			public String wishInsert(int itemKey,  HttpServletRequest req) {
				
				HttpSession session = req.getSession();
				int custKey = (int)session.getAttribute("custKey");
				
				
				List<WishDTO> dto = new ArrayList<WishDTO>();
				try {
					dto = service.WishList(custKey);
					for(WishDTO c : dto) {
						if(c.getItemKey()==itemKey) {
						//	service.increaseWish(c.getwisthKey(), itemKey);
							return "redirect:/";
						}
					}
					
					service.insertWish(custKey, itemKey);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				return "redirect:/";
			}
			
			// 찜에 상품 담기.  상품 리스트화면 리턴   
			@GetMapping("/wish/wishInsertToItem")
			public String wishInsertToItem(int itemKey,  HttpServletRequest req) {
				
				HttpSession session = req.getSession();
				int custKey = (int)session.getAttribute("custKey");
				
				
				List<WishDTO> dto = new ArrayList<WishDTO>();
				try {
					dto = service.WishList(custKey);
					for(WishDTO c : dto) {
						if(c.getItemKey()==itemKey) {
						//	service.increaseWish(c.getwisthKey(), itemKey);
							return "redirect:/shoplist/product?itemKey="+itemKey;
						}
					}
					
					
					service.insertWish(custKey, itemKey);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				return "redirect:/shoplist/product?itemKey="+itemKey;
			}
			
			
			@GetMapping("/wish/wishInsertToList")
			public String wishInsertToList(int itemKey,  HttpServletRequest req) {
				
				HttpSession session = req.getSession();
				int custKey = (int)session.getAttribute("custKey");
				
				
				List<WishDTO> dto = new ArrayList<WishDTO>();
				try {
					dto = service.WishList(custKey);
					for(WishDTO c : dto) {
						if(c.getItemKey()==itemKey) {
						//	service.increaseWish(c.getwisthKey(), itemKey);
							return "redirect:/shoplist";
						}
					}
					
					
					service.insertWish(custKey, itemKey);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				return "redirect:/shoplist";
			}
			
	

}
