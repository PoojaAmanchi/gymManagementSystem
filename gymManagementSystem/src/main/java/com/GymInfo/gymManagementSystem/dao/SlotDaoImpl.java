package com.GymInfo.gymManagementSystem.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import com.GymInfo.gymManagementSystem.bean.Slot;

@Repository
@Service
public class SlotDaoImpl implements SlotDao{

	@Autowired
	private SlotRepository repository;
	@Override
	public void saveNewSlot(Slot slot) {
		repository.save(slot);	
	}
	@Override
	public List<Slot> displayAllSlots() {
		return repository.findAll();
	}

	@Override
	public Slot findSlotById(Long id) {
		return repository.findById(id).get();
	}
	@Override
	public Long generateSlotId() {
		// TODO Auto-generated method stub
		Long val=repository.findLastSlotId();
		if(val==null)
			val=1L;
		else
			val=val+1;
		return val;
	}
}