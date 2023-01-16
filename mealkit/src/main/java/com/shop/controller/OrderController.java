package com.shop.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shop.dto.AddressDTO;
import com.shop.dto.CustomerDTO;
import com.shop.dto.OrderDTO;
import com.shop.dto.OrderDetailDTO;
import com.shop.service.AddressService;
import com.shop.service.CartService;
import com.shop.service.ItemService;
import com.shop.service.OrderDetailService;
import com.shop.service.OrderService;

@Controller
@RequestMapping("/order")
public class OrderController {
	
	String dir="order/";
	
	@Autowired
	AddressService addrservice;
	
	@Autowired
	OrderService orderservice;
	
	@Autowired
	OrderDetailService orderdetailservice;
	
	@Autowired
	ItemService itemservice;
	
	@Autowired
	CartService cartservice;
	
	@RequestMapping("")
	public String main(@RequestParam(value="addr_key",defaultValue="0") int addr_key,HttpSession session, Model model) {
		//주문페이지에 들어왔을 때의 흐름
		//1. 로그인이 되어 있는지 세션 확인
		//2. 세션에 저장된 값이 없으면 로그인 페이지로 이동
		//3. item의 재고를 확인하여 주문할 제품보다 수가 적으면 안내창뜨기
		//4. 세션에 값이 있으면 기본 배송지를 확인하여 view에 뿌려주기
		//5. 기본배송지가 없다면 view에 뿌려주지 않는다.
		//6. 장바구니에 담긴 내용을 가져와서 상품 정보에 뿌려주기
		//7. 결제상세에 뿌릴 데이터들 선언 후 for문으로 계산
		//8. 배송지를 선택하면 다시 갖고오기
		
		
		CustomerDTO cust=null;
		AddressDTO def=null;
		List<OrderDTO> cart_to_order=null;
		List<OrderDTO> cntcheck=null;
		int sale=0;
		int finalprice=0;
		int deliveryfee=0;
		int orprice=0;
		int res=1;
		String item="";
		
		
		//세션에 저장된 유저의 key를 갖고온다.
		int cust_key=(int)session.getAttribute("cust_key");

		//0이면 로그인 페이지로 아니면 주문하기 페이지로 이동
		if(cust_key==0) {
			model.addAttribute("content", null);
		}else {
			//재고 확인해주는 로직 - 재고가 부족하면 res=-1
			try {
				cntcheck=orderservice.cntcheck(cust_key);
				//가져온 값 중 0보다 작은 것이 있으면 res=-1
				for(OrderDTO c:cntcheck) {
					if(c.getCntcheck()<0) {
						res=-1;
						item+=c.getItem_name()+" ";
					}
				}
				model.addAttribute("item", item);
				model.addAttribute("res", res);
			} catch (Exception e) {
				e.printStackTrace();
			}
			

			//배송지를 선택했으면 선택한 배송지 정보 보내기
			if(addr_key!=0) {
				try {
					def=addrservice.addr_key(addr_key);
					model.addAttribute("def", def);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else {
				//기본 배송지가 있으면 그 값 가져오기
				try {
					def=addrservice.check_default(cust_key);
					model.addAttribute("def", def);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			//장바구니에 담긴 상품 정보 가져오기
			try {
				cart_to_order=orderservice.cart_to_order(cust_key);
				model.addAttribute("cart_to_order", cart_to_order);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			
			
			//finalprice: 결제금액, orprice: 원래 금액(정가)
			for(OrderDTO o:cart_to_order) {
				finalprice+=o.getTotal();
				orprice+=o.getItem_price();
			}	
			
			//배송비 구하기
			if(finalprice<30000) {
				deliveryfee=3000;
			}
			
			//할인된 가격 구하기
			sale=orprice-finalprice;
			
			
			model.addAttribute("finalprice", finalprice);
			model.addAttribute("sale", sale);
			model.addAttribute("deliveryfee", deliveryfee);
			model.addAttribute("orprice", orprice);
			model.addAttribute("content", dir+"order");
			
		}
		
		
		return "main";
	}
	
	@RequestMapping("/selectaddr")
	public String selectaddr(HttpSession session, Model model) {
		//배송지 선택창에서의 흐름
		//1. 회원이 등록해둔 배송지를 리스트로 보여준다 (오른쪽에 선택/삭제 버튼)
		//2. 배송지를 선택/삭제하거나 밑에 추가/취소 버튼으로 기능구현
		//3. 추가 누르면 다시 팝업창에서 배송지 추가 폼 생성
		List<AddressDTO> addrlist=null;
		
		
		
		//세션에 저장된 유저의 key를 갖고온다.
		int cust_key=(int)session.getAttribute("cust_key");
		
		try {
			addrlist=addrservice.user_addr(cust_key);
			model.addAttribute("addrlist", addrlist);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "order/selectaddr";
	}
	
	@RequestMapping("/payment")
	public String payment(@RequestParam(value="addr_key",defaultValue="0") int addr_key,
			@RequestParam(value="payment",defaultValue="0") int payment,
			HttpSession session,Model model) {
		//결제하기 페이지
		//1. 빈 주문 테이블 만들어주기
		//2. 장바구니를 이용하여 주문 상세 테이블을 만들기
		//3. 주문 상세를 이용하여 주문테이블 UPDATE하기
		//4. item 테이블의 cnt를 주문한 양 만큼 낮추기
		//5. 장바구니 내역 삭제
		//6. 주문내역 페이지 보여주기

		List<OrderDTO> cart_to_order=null;
		int order_key;
		List<OrderDetailDTO> det=null;
		OrderDTO order=null;
		
		//세션에 저장된 유저의 key를 갖고온다.
		int cust_key=(int)session.getAttribute("cust_key");
		
		//0이면 로그인 페이지로 아니면 주문하기 페이지로 이동
		if(cust_key==0) {
			model.addAttribute("content", null);
		}else {
			
			
			try {
				//빈 주문 테이블 만들어주기
				orderservice.create_blank(cust_key);
				//장바구니에 있는 정보 가져오기
				cart_to_order=orderservice.cart_to_order(cust_key);
				//가져온 정보를 이용해 주문상세 생성하기
				for(OrderDTO o:cart_to_order) {
					orderdetailservice.cart_to_detail(cust_key,o);
				}
				//방금 추가한 주문 번호를 가져와서 UPDATE 준비
				order_key=orderservice.get_orderkey(cust_key);
				// 주문상세를 이용하여 주문 테이블 UPDATE하기
				orderservice.order_update(addr_key, order_key,payment);
				//item 테이블의 cnt를 주문한 양 만큼 낮추기
				//1) order_key의 주문상세에서 item key와 cnt를 불러와서 저장
				det=orderdetailservice.get_orderdetail_by_orderkey(order_key);
				//2) for문으로 그것의 수량, item_key 이용
				for(OrderDetailDTO od:det) {
					itemservice.cntdown(od);
				}
				
				//장바구니 내역 삭제
				cartservice.cart_delete(cust_key);
				//orderkey로 order 내용 불러오기
				order=orderservice.getOrderByOrderKey(order_key);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		model.addAttribute("order", order);
		model.addAttribute("content", dir+"payment");
		return "main";
	}

}
