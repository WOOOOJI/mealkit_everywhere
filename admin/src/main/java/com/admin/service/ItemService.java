package com.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.dto.ItemDTO;
import com.admin.frame.MyService;
import com.admin.mapper.ItemMapper;

@Service
public class ItemService implements MyService<Integer, ItemDTO>{

	@Autowired
	ItemMapper itemMapper;
	
	
	@Override
	public void register(ItemDTO itemDto) throws Exception {
		itemMapper.insert(itemDto);
	}

	@Override
	public void remove(Integer itemKey) throws Exception {
		itemMapper.delete(itemKey);
	}

	@Override
	public void modify(ItemDTO itemDto) throws Exception {
		itemMapper.update(itemDto);
	}

	@Override
	public ItemDTO get(Integer itemKey) throws Exception {
		return itemMapper.select(itemKey);
	}

	@Override
	public List<ItemDTO> get() throws Exception {
		return itemMapper.selectall();
	}
	
	


}
