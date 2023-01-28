package com.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.admin.dto.Criteria;
import com.admin.dto.CustomerDTO;
import com.admin.dto.ItemDTO;
import com.admin.dto.OrderDTO;
import com.admin.dto.response.ItemPageResponseDTO;
import com.admin.service.OrderService;


@Controller
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	OrderService oService;
	
	
	String dir = "order/";
	
	
	// Move to order Management page.
	// 주문관리 페이지 이동
	@RequestMapping("")
	public String orderManage(Model model, Criteria cri, @RequestParam(defaultValue="1", value="pageNum") int pageNum, String keyword, String type, @RequestParam(defaultValue="DESC", value="orderBy")String orderBy) {
		
		System.out.println(cri);
		if(keyword == null) keyword = "nothing";
		
		cri.setKeyword(keyword);
		cri.setOrderBy(orderBy);
		cri.setType(type);
		
		List<OrderDTO> orderList = null;
		//ItemPageResponseDTO(active, pageNumList, content를 묶어주기 위한 DTO) 선언 및 초기화
		ItemPageResponseDTO itemPageResponseDTO = oService.getOrderPageMaker(cri);
		
		orderList = oService.getOrderList(cri);
		
		// 받아온 데이터가 비어있을때의 if문 처리
		if(!orderList.isEmpty()) {
			model.addAttribute("orderList", orderList);
		}else {
			model.addAttribute("nothing", dir+"nothing");
		}
		model.addAttribute("content", dir+"orderlist");
		model.addAttribute("active", itemPageResponseDTO.getActive());
		model.addAttribute("pageNumList", itemPageResponseDTO.getPageNumList());
		model.addAttribute("pageMaker", itemPageResponseDTO.getPageMaker());		
		model.addAttribute("pageNum", pageNum);	
		
		model.addAttribute("keyword", keyword);
		model.addAttribute("type", type);
		model.addAttribute("orderBy", orderBy);
		
		System.out.println(orderList);
		
		return "main";
	}
	
	// Change order's status
	//주문 상태 변경                       전달 받은 데이터는 select's option의 value값들을 배열에 담아 전송했다.
	@PostMapping("/changeStatus")
	@ResponseBody
	public int changeStatus(Model model, String status, @RequestParam(value = "arr[]") List<String> orderKeyList) {
		int result = 0;
		
		for(String orderKey : orderKeyList) {
			result = oService.statusChange(status, Integer.parseInt(orderKey));
		}
		
		return result;
		
	}
	
	
	// get data order detail's info
	// 주문 상세 페이지 데이터 가져오기
	@RequestMapping("/orderDetail")
	public String orderDetail(Model model, int orderKey) {
		List<ItemDTO> itemList = null;
		OrderDTO order = null;
		CustomerDTO cust = null;
		
		// 주문관련 회원의 개인정보
		cust = oService.getCustInfo(orderKey);
		// 주문관련 상품의 정보
		itemList = oService.getOrderDetail(orderKey);
		// 주문상세 정보
		order = oService.getToWho(orderKey);
		
		model.addAttribute("content", "order/orderdetail");
		model.addAttribute("itemList", itemList);
		model.addAttribute("order", order);
		model.addAttribute("cust", cust);
		
		return "main";
	}
	
	
	// Refund method
	// 환불처리 기능
	@RequestMapping("/refundOk")
	@ResponseBody
	public int refundOk(String status, int orderKey) {
		int result = 0;
		
		result = oService.statusChange(status, orderKey);
		
		return result;
	}
	
	
	// Tracking
	// 배송조회
	@RequestMapping("/orderTracking")
	public String orderTracking(String trackingNum, Model model) {
		model.addAttribute("trackingNum", trackingNum);
		System.out.println(trackingNum);
		return "order/tracking";
	}
	
	
	// Update trackingNum
	// 운송장번호 입력(수정)
	@RequestMapping("insertTrackingNum")
	@ResponseBody
	public int insertTrackingNum(String trackingNum, String orderKey) {
		int result = 0;
		
		result = oService.insertTrackingNum(trackingNum, Integer.parseInt(orderKey));
		
		return result;
	}
}
