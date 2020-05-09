package com.Hesap.PSHesap.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Hesap.PSHesap.model.TableStatus;
import com.Hesap.PSHesap.repository.PStableStatusRepository;
import com.Hesap.PSHesap.service.PStableStatusService;

@Service
public class PStableStatusServiceImpl implements PStableStatusService {

	@Autowired
	PStableStatusRepository psTableStatusRepository;

	@Override
	public TableStatus saveTableStatus(TableStatus tableStatus) {
		
		return psTableStatusRepository.save(tableStatus);
	}

	@Override
	public List<TableStatus> getTableStatus() {
		// TODO Auto-generated method stub
		return psTableStatusRepository.findAll();
	}
	

}
