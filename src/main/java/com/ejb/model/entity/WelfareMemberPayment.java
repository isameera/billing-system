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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "welfare_member_payment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WelfareMemberPayment.findAll", query = "SELECT w FROM WelfareMemberPayment w")
    , @NamedQuery(name = "WelfareMemberPayment.findById", query = "SELECT w FROM WelfareMemberPayment w WHERE w.id = :id")
    , @NamedQuery(name = "WelfareMemberPayment.findByWelfarePaymentsId", query = "SELECT w FROM WelfareMemberPayment w WHERE w.welfarePaymentsId = :welfarePaymentsId")})
public class WelfareMemberPayment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "welfare_payments_id")
    private int welfarePaymentsId;

    public WelfareMemberPayment() {
    }

    public WelfareMemberPayment(Integer id) {
        this.id = id;
    }

    public WelfareMemberPayment(Integer id, int welfarePaymentsId) {
        this.id = id;
        this.welfarePaymentsId = welfarePaymentsId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getWelfarePaymentsId() {
        return welfarePaymentsId;
    }

    public void setWelfarePaymentsId(int welfarePaymentsId) {
        this.welfarePaymentsId = welfarePaymentsId;
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
        if (!(object instanceof WelfareMemberPayment)) {
            return false;
        }
        WelfareMemberPayment other = (WelfareMemberPayment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.WelfareMemberPayment[ id=" + id + " ]";
    }
    
}
