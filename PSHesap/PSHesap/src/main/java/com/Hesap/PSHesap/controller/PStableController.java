package com.Hesap.PSHesap.controller;

import com.Hesap.PSHesap.model.PStable;
import com.Hesap.PSHesap.service.PStableService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class PStableController {
	
	@Autowired
	PStableService psTableService;

	@PostMapping()
	public PStable createPStable(@Validated @RequestBody PStable psTable)
	{
		return psTableService.saveTable(psTable);
	}
	
	public List<PStable> getPStable()
	{
		return psTableService.getAllPScafe();
	}
}
