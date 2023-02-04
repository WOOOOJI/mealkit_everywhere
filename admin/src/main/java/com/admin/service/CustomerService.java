package com.admin.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.dto.Criteria;
import com.admin.dto.CustomerDTO;
import com.admin.dto.PageDTO;
import com.admin.dto.response.PageResponseDTO;
import com.admin.frame.MyService;
import com.admin.mapper.CustomerMapper;

@Service
public class CustomerService implements MyService<Integer, CustomerDTO> {

	@Autowired
	CustomerMapper customerMapper;

	@Override
	public void register(CustomerDTO v) throws Exception {
		customerMapper.insert(v);
	}

	@Override
	public void remove(Integer k) throws Exception {
		customerMapper.delete(k);
	}

	@Override
	public void modify(CustomerDTO v) throws Exception {
		customerMapper.update(v);
	}

	@Override
	public CustomerDTO get(Integer k) {
		try {
			return customerMapper.select(k);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<CustomerDTO> get() {
		try {
			return customerMapper.selectall();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	//회원 리스트 뽑기
	public List<CustomerDTO> getCustList(Criteria cri){
		try {
			return customerMapper.getCustList(cri);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	//모든 회원 수 세기
	public int countCust(Criteria cri){
		try {
			return customerMapper.countCust(cri);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	//모든 상품 페이지 메이커
	public PageResponseDTO getPageMaker(Criteria cri) {
		PageDTO pageMaker = null;
		List<Integer> pageNumList = new ArrayList<>();

		try {
			pageMaker = new PageDTO(cri, customerMapper.countCust(cri));

			for(int i=pageMaker.getPageStart(); i<=pageMaker.getPageEnd(); i++) {
				pageNumList.add(i);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}


		PageResponseDTO pageResponseDTO = PageResponseDTO.builder()
					.pageMaker(pageMaker)
					.pageNumList(pageNumList)
					.build();


		return pageResponseDTO;
	}



	//회원 차단 설정
	public void changeLocked(CustomerDTO customerDTO) {
		try {
			customerMapper.changeLocked(customerDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//회원 주민 앞6자리에 19, 20 작업
	public String custJumin(int custKey) {

		CustomerDTO customerDTO = new CustomerDTO();
		String juminStr = "";
		try {
			customerDTO = customerMapper.custJumin(custKey);
			juminStr = customerDTO.getJumin();
			if(juminStr.substring(0,1)=="9") {
				juminStr = "19"+juminStr;
			}else {
				juminStr = "20"+juminStr;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return juminStr;
	}

}






