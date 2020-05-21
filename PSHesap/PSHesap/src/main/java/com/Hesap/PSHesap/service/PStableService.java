package com.Hesap.PSHesap.service;

import java.text.ParseException;
import java.util.List;

import com.Hesap.PSHesap.model.PStable;

public interface PStableService {
	
	//save islemi icin
	PStable saveTable(PStable table);
	//get islemi icin
	//List kullanılmasını sebebi birden fazla data dönmesinden dolayı
	List<PStable> getAllPScafe();
	PStable deleteTable(Integer id);
	PStable updateTable(Integer id, PStable psTable) throws ParseException;

}
