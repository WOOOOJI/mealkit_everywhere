package com.shop.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shop.dto.AddressDTO;
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

	String dir = "order/";

	
	// 카멜 표기법으로 수정해주세요. ex) addrservice X addrService O
	
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
	public String main(@RequestParam(value = "addrKey", defaultValue = "0") int addrKey, HttpSession session,
			Model model) {
		// 주문페이지에 들어왔을 때의 흐름
		// 1. 로그인이 되어 있는지 세션 확인
		// 2. 세션에 저장된 값이 없으면 로그인 페이지로 이동
		// 3. item의 재고를 확인하여 주문할 제품보다 수가 적으면 안내창뜨기
		// 4. 세션에 값이 있으면 기본 배송지를 확인하여 view에 뿌려주기
		// 5. 기본배송지가 없다면 view에 뿌려주지 않는다.
		// 6. 장바구니에 담긴 내용을 가져와서 상품 정보에 뿌려주기
		// 7. 결제상세에 뿌릴 데이터들 선언 후 for문으로 계산
		// 8. 배송지를 선택하면 다시 갖고오기

		AddressDTO def = null;
		List<OrderDTO> cartToOrder = null;
		List<OrderDTO> cntCheck = null;
		int sale = 0;
		int finalprice = 0;
		int deliveryfee = 0;
		int orprice = 0;
		int res = 1;
		String item = "";

		// 세션에 저장된 유저의 key를 갖고온다.
		int custKey = (int) session.getAttribute("custKey");

		// 재고 확인해주는 로직 - 재고가 부족하면 res=-1
		cntCheck = orderservice.cntCheck(custKey);
		// 가져온 값 중 0보다 작은 것이 있으면 res=-1
		for (OrderDTO c : cntCheck) {
			if (c.getCntcheck() < 0) {
				res = -1;
				item += c.getItemName() + " ";
			}
		}
		model.addAttribute("item", item);
		model.addAttribute("res", res);

		// 배송지를 선택했으면 선택한 배송지 정보 보내기
		if (addrKey != 0) {
			def = addrservice.addrKey(addrKey);
			model.addAttribute("def", def);
		} else {
			// 기본 배송지가 있으면 그 값 가져오기
			def = addrservice.checkDefault(custKey);
			model.addAttribute("def", def);
		}

		// 장바구니에 담긴 상품 정보 가져오기

		cartToOrder = orderservice.cartToOrder(custKey);
		model.addAttribute("cart_to_order", cartToOrder);

		// finalprice: 구매금액, orprice: 원래 금액(정가)
		for (OrderDTO o : cartToOrder) {
			finalprice += o.getTotal();
			orprice += o.getItemPrice();
		}

		// 배송비 구하기
		if (finalprice < 30000) {
			deliveryfee = 3000;
		}

		// 할인된 가격 구하기
		sale = orprice - finalprice;
		finalprice += deliveryfee;

		model.addAttribute("finalprice", finalprice);
		model.addAttribute("sale", sale);
		model.addAttribute("deliveryfee", deliveryfee);
		model.addAttribute("orprice", orprice);
		model.addAttribute("content", dir + "order");

		return "main";
	}

	// 배송지 선택창
	@RequestMapping("/selectaddr")
	public String selectaddr(HttpSession session, Model model) {
		// 배송지 선택창에서의 흐름
		// 1. 회원이 등록해둔 배송지를 리스트로 보여준다 (오른쪽에 선택/삭제 버튼)
		// 2. 배송지를 선택/삭제하거나 밑에 추가/취소 버튼으로 기능구현
		// 3. 추가 누르면 다시 팝업창에서 배송지 추가 폼 생성
		List<AddressDTO> addrList = null;

		// 세션에 저장된 유저의 key를 갖고온다.
		int custKey = (int) session.getAttribute("custKey");

		addrList = addrservice.userAddr(custKey);
		model.addAttribute("addrlist", addrList);

		return "order/selectaddr";
	}

	// 배송지 추가
	@RequestMapping("/addaddr")
	public String addaddr(HttpSession session, Model model) {
		// 배송지 추가창에서의 흐름
		// 1. 회원이 폼에 입력한 정보를 AddressDTO로 받아온다
		// 2. 그 정보와 session의 custKey를 가지고 배송지를 추가해준다
		// 3. 완료되면 배송지 선택 창으로 돌려준다
		List<AddressDTO> addrlist = null;

		// 세션에 저장된 유저의 key를 갖고온다.
		int custKey = (int) session.getAttribute("custKey");

		addrlist = addrservice.userAddr(custKey);
		if(addrlist.size()>=3) {
			return "redirect:/order/selectaddr";
		}
		model.addAttribute("addrlist", addrlist);

		return "order/addaddr";
	}

	// 배송지 추가(form 받아옴)
	@RequestMapping("/submitAddr")
	public String submitAddr(AddressDTO address, HttpSession session, Model model) {
		// 배송지 추가창에서의 흐름
		// 1. 회원이 폼에 입력한 정보를 AddressDTO로 받아온다
		// 2. 그 정보와 session의 custKey를 가지고 배송지를 추가해준다
		// 3. 완료되면 배송지 선택 창으로 돌려준다

		// 세션에 저장된 유저의 key를 갖고온다.
		int custKey = (int) session.getAttribute("custKey");
		addrservice.insertAddress(custKey, address);
		return "redirect:/order/selectaddr";
	}

	// 배송지 삭제
	@RequestMapping("/deleteAddr")
	public String deleteAddr(@RequestParam(value = "addrKey", defaultValue = "0") int addrKey, HttpSession session,
			Model model) {
		// 배송지 제거에서의 흐름
		// 1. 폼에서 addrKey를 받아온다
		// 2. addrKey로 주소를 삭제한다
		addrservice.remove(addrKey);

		return "redirect:/order/selectaddr";
	}
	
	// 기본배송지설정
	@RequestMapping("/setDefaultAddr")
	public String setDefaultAddr(@RequestParam(value = "addrKey", defaultValue = "0") int addrKey, HttpSession session,
			Model model) {
		// 기본배송지 설정에서의 흐름
		// 1. 폼에서 addrKey를 받아온다
		// 2. addrKey로 기본배성지로 설정
		int custKey = (int) session.getAttribute("custKey");
		
		addrservice.setDefaultAddress(custKey,addrKey);

		return "redirect:/order/selectaddr";
	}
	

	// 결제페이지
	@RequestMapping("/payment")
	public String payment(@RequestParam(value = "addrKey", defaultValue = "0") int addrKey,
			@RequestParam(value = "payment", defaultValue = "0") int payment, HttpSession session, Model model) {
		// 결제하기 페이지
		// 1. 빈 주문 테이블 만들어주기
		// 2. 장바구니를 이용하여 주문 상세 테이블을 만들기
		// 3. 주문 상세를 이용하여 주문테이블 UPDATE하기
		// 4. item 테이블의 cnt를 주문한 양 만큼 낮추기
		// 5. 장바구니 내역 삭제
		// 6. 주문내역 페이지 보여주기
		
		//주문 내용 없이 실수로 결제페이지 들어왔을 경우 다시 main으로 돌려보냄
		if(payment==0||addrKey==0) {
			return "redirect:/";
		}
		
		List<OrderDTO> cartToOrder = null;
		int orderKey;
		List<OrderDetailDTO> det = null;
		OrderDTO order = null;

		// 세션에 저장된 유저의 key를 갖고온다.
		int custKey = (int) session.getAttribute("custKey");

		// 0이면 로그인 페이지로 아니면 주문하기 페이지로 이동

		// 빈 주문 테이블 만들어주기
		orderservice.createBlank(custKey);
		// 장바구니에 있는 정보 가져오기
		cartToOrder = orderservice.cartToOrder(custKey);
		// 가져온 정보를 이용해 주문상세 생성하기
		for (OrderDTO o : cartToOrder) {
			orderdetailservice.cartToDetail(custKey, o);
		}
		// 방금 추가한 주문 번호를 가져와서 UPDATE 준비
		orderKey = orderservice.getOrderkey(custKey);
		// 주문상세를 이용하여 주문 테이블 UPDATE하기
		orderservice.orderUpdate(addrKey, orderKey, payment);
		// item 테이블의 cnt를 주문한 양 만큼 낮추기
		// 1) orderKey의 주문상세에서 item key와 cnt를 불러와서 저장
		det = orderdetailservice.getOrderDetailByOrderkey(orderKey);
		// 2) for문으로 그것의 수량, item_key 이용
		for (OrderDetailDTO od : det) {
			itemservice.cntDown(od);
		}

		// 장바구니 내역 삭제
		cartservice.cartDelete(custKey);
		// orderkey로 order 내용 불러오기
		order = orderservice.getOrderByOrderKey(orderKey);

		model.addAttribute("order", order);
		model.addAttribute("content", dir + "payment");
		return "main";
	}

	// 주문정보를 AJAX로 받아오기
	@ResponseBody
	@RequestMapping("/requestPay")
	public int requestPay(String imp_uid, String merchant_uid) {
		return 1;
	}
	
	
	// 환불 페이지 이동
	@RequestMapping("/refundform")
	public String refundForm(int orderKey, Model model) {
		model.addAttribute("orderKey", orderKey);
		return "order/refund";
	}
	
	
	// 환불처리
	@RequestMapping("/refund")
	@ResponseBody
	public int refund(String reason, String orderKey) {
		int result = 0;
		result = orderservice.refund(reason, Integer.parseInt(orderKey));
		return result;
	}
	
	
	// 주문 배송상태 확인
	@RequestMapping("/orderTracking")
	public String orderTracking(String trackingNum, Model model) {
		model.addAttribute("trackingNum", trackingNum);
		System.out.println(trackingNum);
		return "order/tracking";
	}

}
