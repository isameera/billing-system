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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "account_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AccountType.findAll", query = "SELECT a FROM AccountType a")
    , @NamedQuery(name = "AccountType.findById", query = "SELECT a FROM AccountType a WHERE a.id = :id")
    , @NamedQuery(name = "AccountType.findByName", query = "SELECT a FROM AccountType a WHERE a.name = :name")})
public class AccountType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountTypeId")
    private Collection<MainChartOfAccount> mainChartOfAccountCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountTypeId")
    private Collection<OrgAccountType> orgAccountTypeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountTypeId")
    private Collection<DualEntryRecord> dualEntryRecordCollection;

    public AccountType() {
    }

    public AccountType(Integer id) {
        this.id = id;
    }

    public AccountType(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Collection<MainChartOfAccount> getMainChartOfAccountCollection() {
        return mainChartOfAccountCollection;
    }

    public void setMainChartOfAccountCollection(Collection<MainChartOfAccount> mainChartOfAccountCollection) {
        this.mainChartOfAccountCollection = mainChartOfAccountCollection;
    }

    @XmlTransient
    public Collection<OrgAccountType> getOrgAccountTypeCollection() {
        return orgAccountTypeCollection;
    }

    public void setOrgAccountTypeCollection(Collection<OrgAccountType> orgAccountTypeCollection) {
        this.orgAccountTypeCollection = orgAccountTypeCollection;
    }

    @XmlTransient
    public Collection<DualEntryRecord> getDualEntryRecordCollection() {
        return dualEntryRecordCollection;
    }

    public void setDualEntryRecordCollection(Collection<DualEntryRecord> dualEntryRecordCollection) {
        this.dualEntryRecordCollection = dualEntryRecordCollection;
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
        if (!(object instanceof AccountType)) {
            return false;
        }
        AccountType other = (AccountType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.AccountType[ id=" + id + " ]";
    }
    
}
