package com.Hesap.PSHesap.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.Hesap.PSHesap.model.base.BaseModelAudit;

@Entity
@Table(name="tableStatus")
public class TableStatus extends BaseModelAudit{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private Integer tableId;
	private String deviceType;
	private Integer consoleOfNumber;
	private Integer price;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getTableId() {
		return tableId;
	}
	public void setTableId(Integer tableId) {
		this.tableId = tableId;
	}
	public String getDeviceType() {
		return deviceType;
	}
	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}
	public Integer getConsoleOfNumber() {
		return consoleOfNumber;
	}
	public void setConsoleOfNumber(Integer consoleOfNumber) {
		this.consoleOfNumber = consoleOfNumber;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	
}
