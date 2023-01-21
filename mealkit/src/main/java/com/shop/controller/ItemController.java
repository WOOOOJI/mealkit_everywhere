package com.shop.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shop.dto.CategoryDTO;
import com.shop.dto.Criteria;
import com.shop.dto.ItemDTO;
import com.shop.dto.response.ItemPageResponseDTO;
import com.shop.service.CategoryService;
import com.shop.service.ItemService;

//log를 찍어보기위한 Annotation

@Controller
@RequestMapping("/shoplist")
public class ItemController {
	
	@Autowired
	ItemService itemService;
	
	@Autowired
	CategoryService categoryService;
	
	String dir = "shoplist/";
	
	//카테고리 상품 리스트
	@RequestMapping("")
	public String main(@RequestParam(defaultValue="0", value="categoryKey") int categoryKey,
					   @RequestParam(defaultValue="1", value="pageNum") int pageNum,
					   @RequestParam(required = false, defaultValue = "itemKey", value = "order_cri") String order_cri,
					   @RequestParam(required = false, defaultValue = "desc", value = "asc_desc") String asc_desc,
					   Model model, Criteria cri) {

		
		List<ItemDTO> itemList = new ArrayList<>();
		//ItemPageResponseDTO(active, pageNumList, content를 묶어주기 위한 DTO) 선언 및 초기화
		
		
		cri.setOrder_cri(order_cri);
		cri.setCategoryKey(categoryKey);
		cri.setAsc_desc(asc_desc);
		
		ItemPageResponseDTO itemPageResponseDTO = itemService.getItemPageMaker(cri);
		
		List<CategoryDTO> categoryDTOList = categoryService.get();
		
		itemList = itemService.getItemList(cri);
		
		//itemList 유효성 검사(controller에선 DB에서 접근하지 않는 로직정도만 처리하는게 낫다)
		if(!itemList.isEmpty()) {
			model.addAttribute("itemList", itemList);
		} else {
			model.addAttribute("itemList", "empty");
		}
		
		//model에 변수들 담기
		model.addAttribute("pageNumList", itemPageResponseDTO.getPageNumList());
		model.addAttribute("pageMaker", itemPageResponseDTO.getPageMaker());
		
		model.addAttribute("categoryList", categoryDTOList);
		
		model.addAttribute("content", dir+"itemlist");
		
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("categoryKey", categoryKey);
		model.addAttribute("asc_desc", asc_desc);
		model.addAttribute("order_cri", order_cri);
		
		
		//model에 html 파일경로를 value로 담으면 브라우저 url창에선 감춰져 보인다
		return "main";
	}
	
	@RequestMapping("/productSingle")
	public String productSingle(@RequestParam(required = true, value="itemKey") int itemKey, 
								Model model) {
		String dir = "shoplist/";
		
		ItemDTO itemDTO = itemService.get(itemKey);
		
		model.addAttribute("content", dir+"product_single");
		model.addAttribute("item", itemDTO);
		return "main";
	}

	
}
