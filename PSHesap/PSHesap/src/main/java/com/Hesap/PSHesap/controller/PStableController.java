package com.Hesap.PSHesap.controller;

import com.Hesap.PSHesap.model.PStable;
import com.Hesap.PSHesap.service.PStableService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/psCafe")
public class PStableController {
	
	@Autowired
	PStableService psTableService;

	@PostMapping()
	public PStable createPStable(@Validated @RequestBody PStable psTable)
	{
		return psTableService.saveTable(psTable);
	}
	@GetMapping()
	public List<PStable> getPStable()
	{
		return psTableService.getAllPScafe();
	}
}
