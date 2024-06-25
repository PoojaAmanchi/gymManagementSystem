package com.GymInfo.gymManagementSystem.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import com.GymInfo.gymManagementSystem.bean.GymItem;

@Repository
@Service
public class GymItemDaoImpl implements GymItemDao {

	@Autowired
	private GymItemRepository repository;
	@Override
	public void saveNewItem(GymItem gymItem) {
		repository.save(gymItem);	
	}
	@Override
	public List<GymItem> displayAllItems() {
		return repository.findAll();
	}
	@Override
	public GymItem findItemById(Long id) {
		return repository.findById(id).get();
	}
	@Override
	public Long generateItemId() {
		Long val=repository.findLastItemId();
		if(val==null)
			val=1L;
		else
			val=val+1;
		return val;
	}
}