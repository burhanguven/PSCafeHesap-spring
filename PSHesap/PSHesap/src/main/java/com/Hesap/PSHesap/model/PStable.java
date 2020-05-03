package com.Hesap.PSHesap.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import com.Hesap.PSHesap.model.base.BaseModelAudit;

@Entity
@Table(name="psTable")
public class PStable extends BaseModelAudit {

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	private Integer id;
	private String tableName;
}
