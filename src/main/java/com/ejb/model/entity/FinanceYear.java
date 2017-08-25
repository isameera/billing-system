/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb.model.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "finance_year")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FinanceYear.findAll", query = "SELECT f FROM FinanceYear f")
    , @NamedQuery(name = "FinanceYear.findById", query = "SELECT f FROM FinanceYear f WHERE f.id = :id")
    , @NamedQuery(name = "FinanceYear.findByName", query = "SELECT f FROM FinanceYear f WHERE f.name = :name")
    , @NamedQuery(name = "FinanceYear.findByStartingDate", query = "SELECT f FROM FinanceYear f WHERE f.startingDate = :startingDate")
    , @NamedQuery(name = "FinanceYear.findByEndDate", query = "SELECT f FROM FinanceYear f WHERE f.endDate = :endDate")
    , @NamedQuery(name = "FinanceYear.findByYear", query = "SELECT f FROM FinanceYear f WHERE f.year = :year")})
public class FinanceYear implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @Column(name = "starting_date")
    @Temporal(TemporalType.DATE)
    private Date startingDate;
    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @Column(name = "year")
    private Integer year;
    @JoinColumn(name = "general_organization_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralOrganizationProfile generalOrganizationProfileId;
    @OneToMany(mappedBy = "accountingYearId")
    private Collection<UncommonVoucherDetails> uncommonVoucherDetailsCollection;

    public FinanceYear() {
    }

    public FinanceYear(Integer id) {
        this.id = id;
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

    public Date getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(Date startingDate) {
        this.startingDate = startingDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public GeneralOrganizationProfile getGeneralOrganizationProfileId() {
        return generalOrganizationProfileId;
    }

    public void setGeneralOrganizationProfileId(GeneralOrganizationProfile generalOrganizationProfileId) {
        this.generalOrganizationProfileId = generalOrganizationProfileId;
    }

    @XmlTransient
    public Collection<UncommonVoucherDetails> getUncommonVoucherDetailsCollection() {
        return uncommonVoucherDetailsCollection;
    }

    public void setUncommonVoucherDetailsCollection(Collection<UncommonVoucherDetails> uncommonVoucherDetailsCollection) {
        this.uncommonVoucherDetailsCollection = uncommonVoucherDetailsCollection;
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
        if (!(object instanceof FinanceYear)) {
            return false;
        }
        FinanceYear other = (FinanceYear) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.FinanceYear[ id=" + id + " ]";
    }
    
}
