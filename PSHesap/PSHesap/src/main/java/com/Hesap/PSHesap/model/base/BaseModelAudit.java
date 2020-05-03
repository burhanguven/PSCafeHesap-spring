package com.Hesap.PSHesap.model.base;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public class BaseModelAudit extends BaseModel{

    @Column(name = "startDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    
    @Column(name = "endDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    
    private Integer status=1;
    
    public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@PrePersist
    public void prePersist() {
        this.startDate = new Date();
        this.endDate=new Date();
    }

    public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

}
