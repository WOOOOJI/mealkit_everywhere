package com.admin.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.admin.dto.Criteria;
import com.admin.dto.ItemDTO;
import com.admin.dto.response.PageResponseDTO;
import com.admin.frame.fileRename;
import com.admin.service.ItemService;

@Controller
@RequestMapping("/item")
public class ItemController {

	@Autowired
	ItemService itemService;

	@Value("${itemdir}")
	String itemdir;

	String dir = "item/";

	@RequestMapping("")
	public String main(Model model, HttpSession session) {

		return "redirect:/item/list";
	}

	@RequestMapping("/list")
	public String list(Model model, HttpSession session, Criteria cri,
			@RequestParam(defaultValue = "1", value = "pageNum") int pageNum,
			@RequestParam(defaultValue = "0", value = "categoryKey") int categoryKey,
			@RequestParam(defaultValue = "DESC", value = "ascDesc") String ascDesc,
			@RequestParam(defaultValue = "itemKey", value = "orderCri") String orderCri,
			@RequestParam(defaultValue = "none", value = "keyword") String keyword,
			@RequestParam(defaultValue = "name", value = "type") String type
			) {

		List<ItemDTO> itemList = null;
		cri.setAscDesc(ascDesc);
		cri.setOrderCri(orderCri);
		cri.setCategoryKey(categoryKey);
		cri.setKeyword(keyword);
		cri.setType(type);
		// ItemPageResponseDTO(active, pageNumList, content를 묶어주기 위한 DTO) 선언 및 초기화
		PageResponseDTO pageResponseDTO = itemService.getItemPageMaker(cri);
		
		itemList = itemService.getItemList(cri);
		// 페이징 관련 변수들 모두 담아주기.
		model.addAttribute("type", type);
		model.addAttribute("categoryKey",categoryKey);
		model.addAttribute("ascDesc",ascDesc);
		model.addAttribute("orderCri",orderCri);
		model.addAttribute("pageNumList", pageResponseDTO.getPageNumList());
		model.addAttribute("pageMaker", pageResponseDTO.getPageMaker());
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("list", itemList);
		model.addAttribute("content", dir + "itemlist");
		return "main";
	}

	@RequestMapping("/registerform")
	public String register(Model model, HttpSession session) {

		model.addAttribute("content", dir + "registerform");
		return "main";
	}

	@RequestMapping("/register")
	public String register(ItemDTO item, Model model, HttpSession session) {
		// view에서 받아온 item의 img의 이름들을 저장
		String img1 = item.getImgFile1().getOriginalFilename();
		String img2 = item.getImgFile2().getOriginalFilename();
		String img3 = item.getImgFile3().getOriginalFilename();
		String img4 = item.getImgFile4().getOriginalFilename();
		String img5 = item.getImgFile5().getOriginalFilename();

		try {
			// 이름이 없으면 파일을 첨부하지 않았으니 실행 안함
			if (!img1.equals("") && img1 != null) {
				// File 객체를 생성하여 path와 파일명을 설정
				File saveFile1 = new File(itemdir + img1);
				// 그 곳에 같은 이름이 있으면 fileRename객체 호출하여 이름 다시 작성 (com.admin.frame)
				saveFile1 = new fileRename().rename(saveFile1);
				// item객체의 img의 이름을 설정하여 나중에 불러올 수 있게 설정
				item.setImg1(saveFile1.getName());
				// 실제 파일 저장
				item.getImgFile1().transferTo(saveFile1);
			}
			if (!img2.equals("") && img2 != null) {
				File saveFile2 = new File(itemdir + img2);
				saveFile2 = new fileRename().rename(saveFile2);
				item.setImg2(saveFile2.getName());
				item.getImgFile2().transferTo(saveFile2);
			}

			if (!img3.equals("") && img3 != null) {
				File saveFile3 = new File(itemdir + img3);
				saveFile3 = new fileRename().rename(saveFile3);
				item.setImg3(saveFile3.getName());
				item.getImgFile3().transferTo(saveFile3);
			}

			if (!img4.equals("") && img4 != null) {
				File saveFile4 = new File(itemdir + img4);
				saveFile4 = new fileRename().rename(saveFile4);
				item.setImg4(saveFile4.getName());
				item.getImgFile4().transferTo(saveFile4);
			}

			if (!img5.equals("") && img5 != null) {
				File saveFile5 = new File(itemdir + img5);
				saveFile5 = new fileRename().rename(saveFile5);
				item.setImg5(saveFile5.getName());
				item.getImgFile5().transferTo(saveFile5);
			}

			itemService.registerItem(item);
			model.addAttribute("content", dir + "registerok");
		} catch (Exception e) {
			System.out.println(e);
			model.addAttribute("content", dir + "registerfail");
		}

		return "main";
	}

	@RequestMapping("/itemdetail")
	public String detail(int itemKey, Model model, HttpSession session) {

		ItemDTO item = null;
		item = itemService.get(itemKey);

		model.addAttribute("item", item);
		model.addAttribute("content", dir + "itemdetail");
		return "main";
	}

	@RequestMapping("/update")
	public String update(ItemDTO item, Model model, HttpSession session) {
		// view에서 받아온 item의 img의 이름들을 저장
		String img1 = "";
		String img2 = "";
		String img3 = "";
		String img4 = "";
		String img5 = "";
		if(item.getImgFile1()==null) {
			img1=item.getImg1();
		}else {
			img1 = item.getImgFile1().getOriginalFilename();
		}
		if(item.getImgFile2()==null) {
			img2=item.getImg2();
		}else {
			img2 = item.getImgFile2().getOriginalFilename();
		}
		if(item.getImgFile3()==null) {
			img3=item.getImg3();
		}else {
			img3 = item.getImgFile3().getOriginalFilename();
		}
		if(item.getImgFile4()==null) {
			img4=item.getImg4();
		}else {
			img4 = item.getImgFile4().getOriginalFilename();
		}
		if(item.getImgFile5()==null) {
			img5=item.getImg5();
		}else {
			img5 = item.getImgFile5().getOriginalFilename();
		}

		try {
			// 이름이 없으면 파일을 첨부하지 않았으니 실행 안함
			if (!img1.equals("") && img1 != null&&item.getImgFile1()!=null) {
				// File 객체를 생성하여 path와 파일명을 설정
				File saveFile1 = new File(itemdir + img1);
				// 그 곳에 같은 이름이 있으면 fileRename객체 호출하여 이름 다시 작성 (com.admin.frame)
				saveFile1 = new fileRename().rename(saveFile1);
				// item객체의 img의 이름을 설정하여 나중에 불러올 수 있게 설정
				item.setImg1(saveFile1.getName());
				// 실제 파일 저장
				item.getImgFile1().transferTo(saveFile1);
			}
			if (!img2.equals("") && img2 != null&&item.getImgFile2()!=null) {
				File saveFile2 = new File(itemdir + img2);
				saveFile2 = new fileRename().rename(saveFile2);
				item.setImg2(saveFile2.getName());
				item.getImgFile2().transferTo(saveFile2);
			}

			if (!img3.equals("") && img3 != null&&item.getImgFile3()!=null) {
				File saveFile3 = new File(itemdir + img3);
				saveFile3 = new fileRename().rename(saveFile3);
				item.setImg3(saveFile3.getName());
				item.getImgFile3().transferTo(saveFile3);
			}

			if (!img4.equals("") && img4 != null&&item.getImgFile4()!=null) {
				File saveFile4 = new File(itemdir + img4);
				saveFile4 = new fileRename().rename(saveFile4);
				item.setImg4(saveFile4.getName());
				item.getImgFile4().transferTo(saveFile4);
			}

			if (!img5.equals("") && img5 != null&&item.getImgFile5()!=null) {
				File saveFile5 = new File(itemdir + img5);
				saveFile5 = new fileRename().rename(saveFile5);
				item.setImg5(saveFile5.getName());
				item.getImgFile5().transferTo(saveFile5);
			}

			itemService.modify(item);
			model.addAttribute("content", dir + "registerok");
		} catch (Exception e) {
			System.out.println(e);
			model.addAttribute("content", dir + "registerfail");
		}

		return "main";
	}

	@RequestMapping("/delete")
	public String delete(int itemKey, Model model, HttpSession session) {
		itemService.deleted(itemKey);
		return "redirect:/item/list";
	}
}
