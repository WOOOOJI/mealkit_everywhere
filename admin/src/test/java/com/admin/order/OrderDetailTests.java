package com.admin.order;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.admin.dto.Criteria;
import com.admin.dto.CustomerDTO;
import com.admin.dto.ItemDTO;
import com.admin.dto.OrderDTO;
import com.admin.service.OrderService;

@SpringBootTest
class OrderDetailTests {

	@Autowired
	OrderService os;
	
	@Test
	void contextLoads() {
		System.out.println("-------- 주문 상세 정보 가져오기 테스트 시작 ---------");
		
		
		System.out.println("조회할 주문 번호: "+4634);
		
		
		CustomerDTO cdto = os.getCustInfo(4634);
		System.out.println("회원정보: "+cdto);
		
		List<ItemDTO> itemList = os.getOrderDetail(4634);
		System.out.println("구매한 아이템들: "+itemList);
		
		OrderDTO odto = os.getToWho(4634);
		System.out.println("주문상세 정보: "+odto);
		
		
		
		
		
		System.out.println("-------- 주문 상세 정보 가져오기 테스트 끝 ---------");
	}

}
