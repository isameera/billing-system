/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb.model.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "loan_guarantor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LoanGuarantor.findAll", query = "SELECT l FROM LoanGuarantor l")
    , @NamedQuery(name = "LoanGuarantor.findById", query = "SELECT l FROM LoanGuarantor l WHERE l.id = :id")})
public class LoanGuarantor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "loanGuarantorId")
    private Collection<GurantorLoanManager> gurantorLoanManagerCollection;
    @JoinColumn(name = "general_user_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralUserProfile generalUserProfileId;
    @JoinColumn(name = "guarantor_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GuarantorType guarantorTypeId;

    public LoanGuarantor() {
    }

    public LoanGuarantor(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @XmlTransient
    public Collection<GurantorLoanManager> getGurantorLoanManagerCollection() {
        return gurantorLoanManagerCollection;
    }

    public void setGurantorLoanManagerCollection(Collection<GurantorLoanManager> gurantorLoanManagerCollection) {
        this.gurantorLoanManagerCollection = gurantorLoanManagerCollection;
    }

    public GeneralUserProfile getGeneralUserProfileId() {
        return generalUserProfileId;
    }

    public void setGeneralUserProfileId(GeneralUserProfile generalUserProfileId) {
        this.generalUserProfileId = generalUserProfileId;
    }

    public GuarantorType getGuarantorTypeId() {
        return guarantorTypeId;
    }

    public void setGuarantorTypeId(GuarantorType guarantorTypeId) {
        this.guarantorTypeId = guarantorTypeId;
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
        if (!(object instanceof LoanGuarantor)) {
            return false;
        }
        LoanGuarantor other = (LoanGuarantor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.LoanGuarantor[ id=" + id + " ]";
    }
    
}
