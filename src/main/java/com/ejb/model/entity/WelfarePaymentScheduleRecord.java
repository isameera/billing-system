/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb.model.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "welfare_payment_schedule_record")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WelfarePaymentScheduleRecord.findAll", query = "SELECT w FROM WelfarePaymentScheduleRecord w")
    , @NamedQuery(name = "WelfarePaymentScheduleRecord.findById", query = "SELECT w FROM WelfarePaymentScheduleRecord w WHERE w.id = :id")
    , @NamedQuery(name = "WelfarePaymentScheduleRecord.findByDuration", query = "SELECT w FROM WelfarePaymentScheduleRecord w WHERE w.duration = :duration")
    , @NamedQuery(name = "WelfarePaymentScheduleRecord.findByAmount", query = "SELECT w FROM WelfarePaymentScheduleRecord w WHERE w.amount = :amount")})
public class WelfarePaymentScheduleRecord implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "duration")
    private Integer duration;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "amount")
    private Double amount;
    @JoinColumn(name = "welfare_payment_schedule_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private WelfarePaymentSchedule welfarePaymentScheduleId;

    public WelfarePaymentScheduleRecord() {
    }

    public WelfarePaymentScheduleRecord(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public WelfarePaymentSchedule getWelfarePaymentScheduleId() {
        return welfarePaymentScheduleId;
    }

    public void setWelfarePaymentScheduleId(WelfarePaymentSchedule welfarePaymentScheduleId) {
        this.welfarePaymentScheduleId = welfarePaymentScheduleId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WelfarePaymentScheduleRecord)) {
            return false;
        }
        WelfarePaymentScheduleRecord other = (WelfarePaymentScheduleRecord) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.WelfarePaymentScheduleRecord[ id=" + id + " ]";
    }
    
}
