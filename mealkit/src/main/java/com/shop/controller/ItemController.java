package com.shop.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shop.dto.Criteria;
import com.shop.dto.ItemDTO;
import com.shop.dto.response.ItemPageResponseDTO;
import com.shop.service.ItemService;

import lombok.extern.slf4j.Slf4j;

//log를 찍어보기위한 Annotation
@Slf4j
@Controller
@RequestMapping("/shoplist")
public class ItemController {
	
	@Autowired
	ItemService itemService;
	
	
	String dir = "shoplist/";
	
	//모든 상품 리스트
	@RequestMapping("")
	public String main(Model model, Criteria cri) {

		log.info("itemController 33th line, Criteria "+cri);
		
		List<ItemDTO> itemList = new ArrayList<>();
		//ItemPageResponseDTO(active, pageNumList, content를 묶어주기 위한 DTO) 선언 및 초기화
		ItemPageResponseDTO itemPageResponseDTO = itemService.getItemPageMaker(cri);
		
		itemList = itemService.getItemList(cri);
		
		//itemList 유효성 검사(controller에선 DB에서 접근하지 않는 로직정도만 처리하는게 낫다)
		if(!itemList.isEmpty()) {
			model.addAttribute("itemList", itemList);
		} else {
			model.addAttribute("itemList", "empty");
		}
		
		//model에 변수들 담기
		log.info("itemController 34th line, active "+itemPageResponseDTO.getActive());
		model.addAttribute("active", itemPageResponseDTO.getActive());
		model.addAttribute("pageNumList", itemPageResponseDTO.getPageNumList());
		model.addAttribute("pageMaker", itemPageResponseDTO.getPageMaker());		
		model.addAttribute("content", dir+"itemlist");
		
		
		//model에 html 파일경로를 value로 담으면 브라우저 url창에선 감춰져 보인다
		return "main";
	}
	
	
	//한국 상품(cartegory_key = 1) 리스트
	@RequestMapping("/korean")
	public String korean(Model model, Criteria cri) {
		
		List<ItemDTO> itemList = new ArrayList<>();
		//ItemPageResponseDTO(active, pageNumList, content를 묶어주기 위한 DTO) 선언 및 초기화
		ItemPageResponseDTO itemPageResponseDTO = itemService.getKoreanItemPageMaker(cri);
		
		itemList = itemService.getKoreanItemList(cri);
		
		//itemList 유효성 검사(controller에선 DB에서 접근하지 않는 로직정도만 처리하는게 낫다)
		if(!itemList.isEmpty()) {
			model.addAttribute("itemList", itemList);
		} else {
			model.addAttribute("itemList", "empty");
		}
		
		//model에 변수들 담기
		model.addAttribute("active", itemPageResponseDTO.getActive());
		model.addAttribute("pageNumList", itemPageResponseDTO.getPageNumList());
		model.addAttribute("pageMaker", itemPageResponseDTO.getPageMaker());		
		model.addAttribute("content", dir+"korean");
		
		
		//model에 html 파일경로를 value로 담으면 브라우저 url창에선 감춰져 보인다
		return "main";
	}
	
	//일본 상품(category_key = 2) 리스트
	@RequestMapping("/japanese")
	public String japanese(Model model, Criteria cri) {
		
		List<ItemDTO> itemList = new ArrayList<>();
		//ItemPageResponseDTO(active, pageNumList, content를 묶어주기 위한 DTO) 선언 및 초기화
		ItemPageResponseDTO itemPageResponseDTO = itemService.getJapaneseItemPageMaker(cri);
		
		itemList = itemService.getJapaneseItemList(cri);
		
		//itemList 유효성 검사(controller에선 DB에서 접근하지 않는 로직정도만 처리하는게 낫다)
		if(!itemList.isEmpty()) {
			model.addAttribute("itemList", itemList);
		} else {
			model.addAttribute("itemList", "empty");
		}
		
		//model에 변수들 담기
		model.addAttribute("active", itemPageResponseDTO.getActive());
		model.addAttribute("pageNumList", itemPageResponseDTO.getPageNumList());
		model.addAttribute("pageMaker", itemPageResponseDTO.getPageMaker());		
		model.addAttribute("content", dir+"japanese");
		
		
		//model에 html 파일경로를 value로 담으면 브라우저 url창에선 감춰져 보인다
		return "main";
	}
	
	//중국 상품(category_key = 3) 리스트
	@RequestMapping("/chinese")
	public String chinese(Model model, Criteria cri) {
		
		List<ItemDTO> itemList = new ArrayList<>();
		//ItemPageResponseDTO(active, pageNumList, content를 묶어주기 위한 DTO) 선언 및 초기화
		ItemPageResponseDTO itemPageResponseDTO = itemService.getChineseItemPageMaker(cri);
		
		itemList = itemService.getChineseItemList(cri);
		
		//itemList 유효성 검사(controller에선 DB에서 접근하지 않는 로직정도만 처리하는게 낫다)
		if(!itemList.isEmpty()) {
			model.addAttribute("itemList", itemList);
		} else {
			model.addAttribute("itemList", "empty");
		}
		
		//model에 변수들 담기
		model.addAttribute("active", itemPageResponseDTO.getActive());
		model.addAttribute("pageNumList", itemPageResponseDTO.getPageNumList());
		model.addAttribute("pageMaker", itemPageResponseDTO.getPageMaker());		
		model.addAttribute("content", dir+"chinese");
		
		
		//model에 html 파일경로를 value로 담으면 브라우저 url창에선 감춰져 보인다
		return "main";
	}

	//동남아 상품(category_key = 4) 리스트
	@RequestMapping("/southasia")
	public String southAsia(Model model, Criteria cri) {
		
		List<ItemDTO> itemList = new ArrayList<>();
		//ItemPageResponseDTO(active, pageNumList, content를 묶어주기 위한 DTO) 선언 및 초기화
		ItemPageResponseDTO itemPageResponseDTO = itemService.getSouthAsiaItemPageMaker(cri);
		
		itemList = itemService.getSouthAsiaItemList(cri);
		
		//itemList 유효성 검사(controller에선 DB에서 접근하지 않는 로직정도만 처리하는게 낫다)
		if(!itemList.isEmpty()) {
			model.addAttribute("itemList", itemList);
		} else {
			model.addAttribute("itemList", "empty");
		}
		
		//model에 변수들 담기
		model.addAttribute("active", itemPageResponseDTO.getActive());
		model.addAttribute("pageNumList", itemPageResponseDTO.getPageNumList());
		model.addAttribute("pageMaker", itemPageResponseDTO.getPageMaker());		
		model.addAttribute("content", dir+"southasia");
		
		
		//model에 html 파일경로를 value로 담으면 브라우저 url창에선 감춰져 보인다
		return "main";
	}
	
}
