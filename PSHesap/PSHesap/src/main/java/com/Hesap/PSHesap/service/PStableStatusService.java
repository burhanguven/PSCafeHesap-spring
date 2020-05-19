package com.Hesap.PSHesap.service;

import java.text.ParseException;
import java.util.List;

import com.Hesap.PSHesap.model.TableStatus;

public interface PStableStatusService {
	
	TableStatus saveTableStatus(TableStatus tableStatus);
	List<TableStatus> getTableStatus();
	TableStatus getSaatHesap(Integer id, TableStatus tableStatus) throws ParseException;
	
}
