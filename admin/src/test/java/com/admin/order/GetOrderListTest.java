package com.admin.order;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.admin.dto.Criteria;
import com.admin.dto.OrderDTO;
import com.admin.service.OrderService;

@SpringBootTest
class GetOrderListTest {

	@Autowired
	OrderService os;
	
	@Test
	void contextLoads() {
		System.out.println("-------- 주문 리스트 가져오기 테스트 시작 ---------");
		Criteria cri = new Criteria();
		cri.setPageNum(1);
		cri.setKeyword("nothing");
		cri.setOrderBy("DESC");
		System.out.println("페이징을 위한 데이터 객체 : "+cri);
		
		
		List<OrderDTO> orderList = null;
		
		
		orderList = os.getOrderList(cri);
		System.out.println("DB에서 조회한 결과 : " + orderList);
		System.out.println("-------- 주문 리스트 가져오기 테스트 끝 ---------");
	}

}
