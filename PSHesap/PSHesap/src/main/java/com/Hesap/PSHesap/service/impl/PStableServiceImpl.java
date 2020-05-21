package com.Hesap.PSHesap.service.impl;

import java.awt.print.Book;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Hesap.PSHesap.model.PStable;
import com.Hesap.PSHesap.repository.PStableRepository;
import com.Hesap.PSHesap.service.PStableService;

@Service
public class PStableServiceImpl implements PStableService{
	
	@Autowired
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

	@Override
	public PStable deleteTable(Integer id) {		
		
		PStable psTableDelete=psTableRepository.findFirstById(id);
		psTableRepository.delete(psTableDelete);
		return psTableDelete;
	}

	@Override
	public PStable updateTable(Integer id, PStable psTable) throws ParseException {
		
		PStable psTableUpdate=psTableRepository.findFirstById(id);
		
		Date date=new Date();
		SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String strDate=formatter.format(date);
		Date endDate=formatter.parse(strDate);
		
		if(psTableUpdate==null)
		{
			return psTableRepository.findFirstById(id);
		}
		psTable.setId(psTableUpdate.getId());
		//güncelleme işlemlerinde enddate ve startdate i null atmaması için tekrardan set ediyorum 
		psTable.setEndDate(endDate);
		psTable.setStartDate(psTableUpdate.getStartDate());
		
		return psTableRepository.save(psTable);
	}

}
