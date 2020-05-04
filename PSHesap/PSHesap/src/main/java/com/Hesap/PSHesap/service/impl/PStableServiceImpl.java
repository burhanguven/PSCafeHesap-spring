package com.Hesap.PSHesap.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Hesap.PSHesap.model.PStable;
import com.Hesap.PSHesap.repository.PStableRepository;
import com.Hesap.PSHesap.service.PStableService;

@Service
public class PStableServiceImpl implements PStableService{

	PStableRepository psTableRepository;
	@Override
	public PStable saveTable(PStable table) {
		//masa eklemek icin
		return psTableRepository.save(table);
	}

	@Override
	public List<PStable> getAllPScafe() {
		//tum masaları listelemek icin 
		return psTableRepository.findAll();
	}

}
