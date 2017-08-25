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
@Table(name = "gurantor_loan_manager")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GurantorLoanManager.findAll", query = "SELECT g FROM GurantorLoanManager g")
    , @NamedQuery(name = "GurantorLoanManager.findById", query = "SELECT g FROM GurantorLoanManager g WHERE g.id = :id")})
public class GurantorLoanManager implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gurantorLoanManagerId")
    private Collection<LoanGuarantorChequeDetails> loanGuarantorChequeDetailsCollection;
    @JoinColumn(name = "loan_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private LoanMaster loanId;
    @JoinColumn(name = "loan_guarantor_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private LoanGuarantor loanGuarantorId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gurantorLoanManagerId")
    private Collection<LoanGuarantorLandDetails> loanGuarantorLandDetailsCollection;

    public GurantorLoanManager() {
    }

    public GurantorLoanManager(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @XmlTransient
    public Collection<LoanGuarantorChequeDetails> getLoanGuarantorChequeDetailsCollection() {
        return loanGuarantorChequeDetailsCollection;
    }

    public void setLoanGuarantorChequeDetailsCollection(Collection<LoanGuarantorChequeDetails> loanGuarantorChequeDetailsCollection) {
        this.loanGuarantorChequeDetailsCollection = loanGuarantorChequeDetailsCollection;
    }

    public LoanMaster getLoanId() {
        return loanId;
    }

    public void setLoanId(LoanMaster loanId) {
        this.loanId = loanId;
    }

    public LoanGuarantor getLoanGuarantorId() {
        return loanGuarantorId;
    }

    public void setLoanGuarantorId(LoanGuarantor loanGuarantorId) {
        this.loanGuarantorId = loanGuarantorId;
    }

    @XmlTransient
    public Collection<LoanGuarantorLandDetails> getLoanGuarantorLandDetailsCollection() {
        return loanGuarantorLandDetailsCollection;
    }

    public void setLoanGuarantorLandDetailsCollection(Collection<LoanGuarantorLandDetails> loanGuarantorLandDetailsCollection) {
        this.loanGuarantorLandDetailsCollection = loanGuarantorLandDetailsCollection;
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
        if (!(object instanceof GurantorLoanManager)) {
            return false;
        }
        GurantorLoanManager other = (GurantorLoanManager) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.GurantorLoanManager[ id=" + id + " ]";
    }
    
}
