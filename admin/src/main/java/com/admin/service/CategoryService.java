package com.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.dto.CategoryDTO;
import com.admin.frame.MyService;
import com.admin.mapper.CategoryMapper;

@Service
public class CategoryService implements MyService<Integer, CategoryDTO>{

	@Autowired
	CategoryMapper mapper;


	@Override
	public void register(CategoryDTO v) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(Integer k) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void modify(CategoryDTO v) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public CategoryDTO get(Integer k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CategoryDTO> get() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}



}
