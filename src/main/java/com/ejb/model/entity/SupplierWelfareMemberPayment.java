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
@Table(name = "supplier_welfare_member_payment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SupplierWelfareMemberPayment.findAll", query = "SELECT s FROM SupplierWelfareMemberPayment s")
    , @NamedQuery(name = "SupplierWelfareMemberPayment.findById", query = "SELECT s FROM SupplierWelfareMemberPayment s WHERE s.id = :id")})
public class SupplierWelfareMemberPayment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "family_member_details_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private FamilyMemberDetails familyMemberDetailsId;
    @JoinColumn(name = "welfare_payments_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private WelfarePayments welfarePaymentsId;

    public SupplierWelfareMemberPayment() {
    }

    public SupplierWelfareMemberPayment(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public FamilyMemberDetails getFamilyMemberDetailsId() {
        return familyMemberDetailsId;
    }

    public void setFamilyMemberDetailsId(FamilyMemberDetails familyMemberDetailsId) {
        this.familyMemberDetailsId = familyMemberDetailsId;
    }

    public WelfarePayments getWelfarePaymentsId() {
        return welfarePaymentsId;
    }

    public void setWelfarePaymentsId(WelfarePayments welfarePaymentsId) {
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
        if (!(object instanceof SupplierWelfareMemberPayment)) {
            return false;
        }
        SupplierWelfareMemberPayment other = (SupplierWelfareMemberPayment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.SupplierWelfareMemberPayment[ id=" + id + " ]";
    }
    
}
