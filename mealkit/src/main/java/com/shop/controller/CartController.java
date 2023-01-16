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

import com.shop.dto.CartDTO;
import com.shop.service.CartService;


@Controller
public class CartController {


	@Autowired
	CartService service;
	
	
	// Cart의 html을 관리하는 폴더 경로
	String dir = "cart/";
	
	// 카트 페이지로 이동         Move to cart.html Page        ------------------------------------------------------------------------------------------------
	@GetMapping("/cart/list")
	public String cartPage(Model model, HttpServletRequest req) {
		
		HttpSession session = req.getSession();
		
		// 여러개의 장바구니의 가격 총합.
		int totalPrice = 0;
		// 총 할인된 가
		int salePrice = 0;
		// 최종 결제 금엑
		int finalPrice = 0;
		// 기본 택배비
		int fee = 3000;
		

		int cust_key = (int)session.getAttribute("cust_key");
		System.out.println(cust_key);

		
		// 세션값이 없으면 로그인이 안되있는 상태 이므로 애초에 장바구니 페이지로 못온다.     if there is no sessionValue, user can't access to cart page
		// 세션값을 받은게 있다면 장바구니 페이지로 이동.                             else sessionValue Exits. -> move to cart page.
		
			
			
			// Model 객체에 세션값과 일치하는 사용자의 장바구니 정보를 담아야 한다.       you have to Add attribute( which mean : customer's cart info ) to Model object  
			// 이때 담겨있는 제품이 한개일수도 여러개 일수도 있다 -> ArrayList로 받아온다.   product could be only one or many. So need ArrayList for result of service Method   
			List<CartDTO> cartList = new ArrayList<CartDTO>();
			try {
				cartList = service.CartList(cust_key);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("-------------- CartController.java cause Error: row 38 --------------");
			}
			
			
			// Model 객체에 장바구니 리스트를 담아준다.                              addAttribute Object cartList in Model.
			model.addAttribute("list", cartList);
			// content에 cart.html을 담아준다.									 set View path to Like cart/cart.
			model.addAttribute("content", dir+"cart");
			// Test용 출력문 -> ArrayList가 비어있지 않은지 확인해준다.               // TEST Print
			// System.out.println(cartList.toString());
			
			
			
			
			for(CartDTO dto : cartList) {
				// List에서 dto객체를 꺼내 각각의 총 가격을 더해서 단순 합계 금액을 구해준다.       // Calculate totalPrice each of Cart_key
				 totalPrice += dto.getPrice() * dto.getCnt();
				 // 또한 기존가 - 세일가 의 값을 구해서 최종 할인 가격을 구해준다.                // salePrice.
				 salePrice += (dto.getPrice() - dto.getSale()) * dto.getCnt();
			}
			
			// System.out.println(salePrice);

			
			
			
			// 총합계 금액
			finalPrice = totalPrice - salePrice;
			
			
			// 총합계 금액이 3만원 이상은 배달비 무료											// if totalPrice bigger than 30$, fee is free.
			if(finalPrice >= 30000) {
				fee = 0;															
			}
			
			
			// 최종 결제 금액 구하기	(총합계 + 배송비)									 	// Calculate final Price
			finalPrice += fee;
			
			
			// 각각 금액들을 객체에 담아서 뷰로 보낸다.										// addAttriubte all of PRICE.
			model.addAttribute("totalPrice", totalPrice);
			model.addAttribute("fee", fee);
			model.addAttribute("salePrice", salePrice);
			model.addAttribute("finalPrice", finalPrice);

			
			
		
		
		
		// 세션값이 없으면 중간에 장바구니 페이지로 리턴 되지 않고, 마지막에 login페이지로 return한다.    without sessionValue, don't stop At 28 rows (return cart). must move to login.html  
		return "main";
	}
	
	
	
	// 카트 페이지로 이동         Move to cart.html Page        ------------------------------------------------------------------------------------------------

	
	
	
	
	
	
	
	
	// 장바구니 아이템 삭제.      Delete item of user's CART        ------------------------------------------------------------------------------------------------
		@ResponseBody
		@PostMapping("/cart/delete")
		public int cartList(int cust_key) {
			int result=0;
			System.out.println(cust_key);
			
			
			
			// 표기법 통일
			
			
			
			try {
				service.remove(cust_key);
				result=1;
			} catch (Exception e) {
				System.out.println("장바구니 삭제 실패--------------------------");
				e.printStackTrace();
			}
			
			return result;
		}
	// 장바구니 아이템 삭제.      Delete item of user's CART        ------------------------------------------------------------------------------------------------
		
		
		
		
		
		
		
		
	// 장바구니 수량 수정.      Update cnt of user's CART        ------------------------------------------------------------------------------------------------
		@ResponseBody
		@PostMapping("/cart/cntchange")
		public int cartCnt(CartDTO dto) {
			int result = 0;
			
			try {
				service.modify(dto);
				result++;
			} catch (Exception e) {
				System.out.println("장바구니 수량 변경 에러 ----------------------------");
				e.printStackTrace();
			}
			
			return result;
		}
	// 장바구니 수량 수정.      Delete cnt of user's CART        ------------------------------------------------------------------------------------------------

		

	// 장바구니에 상품 담기.     Insert Item on user's CART        ------------------------------------------------------------------------------------------------
		@GetMapping("/cart/cartInsert")
		public String cartInsert(int item_key, int cnt, HttpServletRequest req) {
			
			HttpSession session = req.getSession();
			int cust_key = (int)session.getAttribute("cust_key");
			
			
			if(cnt == 0) cnt = 1;
			
			List<CartDTO> dto = new ArrayList<CartDTO>();
			try {
				dto = service.CartList(cust_key);
				for(CartDTO c : dto) {
					if(c.getItem_key()==item_key) {
						service.increaseCart(c.getCart_key(), item_key, cnt);
						return "redirect:/";
					}
				}
				
				service.insertCart(cust_key, item_key, cnt);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return "redirect:/";
		}
		
		
		
		
	// 장바구니 수량 수정.      Delete cnt of user's CART        ------------------------------------------------------------------------------------------------

}
