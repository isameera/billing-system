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
@Table(name = "welfare_member_payments")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WelfareMemberPayments.findAll", query = "SELECT w FROM WelfareMemberPayments w")
    , @NamedQuery(name = "WelfareMemberPayments.findById", query = "SELECT w FROM WelfareMemberPayments w WHERE w.id = :id")})
public class WelfareMemberPayments implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "universal_family_member_details_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UniversalFamilyMemberDetails universalFamilyMemberDetailsId;
    @JoinColumn(name = "welfare_payments_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private WelfarePayments welfarePaymentsId;

    public WelfareMemberPayments() {
    }

    public WelfareMemberPayments(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UniversalFamilyMemberDetails getUniversalFamilyMemberDetailsId() {
        return universalFamilyMemberDetailsId;
    }

    public void setUniversalFamilyMemberDetailsId(UniversalFamilyMemberDetails universalFamilyMemberDetailsId) {
        this.universalFamilyMemberDetailsId = universalFamilyMemberDetailsId;
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
        if (!(object instanceof WelfareMemberPayments)) {
            return false;
        }
        WelfareMemberPayments other = (WelfareMemberPayments) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.WelfareMemberPayments[ id=" + id + " ]";
    }
    
}
