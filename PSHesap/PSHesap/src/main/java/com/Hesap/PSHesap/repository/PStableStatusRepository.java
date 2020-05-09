package com.Hesap.PSHesap.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Hesap.PSHesap.model.TableStatus;

public interface PStableStatusRepository extends JpaRepository<TableStatus, Integer> {
	
	
}
