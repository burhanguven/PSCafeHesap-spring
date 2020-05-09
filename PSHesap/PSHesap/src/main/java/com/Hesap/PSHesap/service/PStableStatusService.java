package com.Hesap.PSHesap.service;

import java.util.List;

import com.Hesap.PSHesap.model.TableStatus;

public interface PStableStatusService {
	
	TableStatus saveTableStatus(TableStatus tableStatus);
	List<TableStatus> getTableStatus();
	
}
