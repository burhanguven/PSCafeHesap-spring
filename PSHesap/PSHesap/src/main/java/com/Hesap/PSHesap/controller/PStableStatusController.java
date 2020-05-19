package com.Hesap.PSHesap.controller;

import java.text.ParseException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Hesap.PSHesap.model.TableStatus;
import com.Hesap.PSHesap.service.PStableStatusService;

@RestController
@RequestMapping("/tableStatus")
public class PStableStatusController {
	
	@Autowired
	PStableStatusService psTableStatusService;
	
	@PostMapping
	public TableStatus createTableStatus(@Valid @RequestBody TableStatus tableStatus)
	{
		return psTableStatusService.saveTableStatus(tableStatus);
	}
	
	@GetMapping
	public List<TableStatus> getAllTableStatus()
	{
		return psTableStatusService.getTableStatus();
	}
	@GetMapping("/saatHesap/{id}")
	public TableStatus getSaatHesap(@PathVariable("id") Integer id, TableStatus tableStatus) throws ParseException
	{
		return psTableStatusService.getSaatHesap(id, tableStatus);
	}
}
