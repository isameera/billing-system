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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "org_main_chart_of_account")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrgMainChartOfAccount.findAll", query = "SELECT o FROM OrgMainChartOfAccount o")
    , @NamedQuery(name = "OrgMainChartOfAccount.findById", query = "SELECT o FROM OrgMainChartOfAccount o WHERE o.id = :id")
    , @NamedQuery(name = "OrgMainChartOfAccount.findByAccountCode", query = "SELECT o FROM OrgMainChartOfAccount o WHERE o.accountCode = :accountCode")})
public class OrgMainChartOfAccount implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "account_code")
    private String accountCode;
    @JoinColumn(name = "general_organization_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralOrganizationProfile generalOrganizationProfileId;
    @JoinColumn(name = "main_chart_of_account_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private MainChartOfAccount mainChartOfAccountId;

    public OrgMainChartOfAccount() {
    }

    public OrgMainChartOfAccount(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    public GeneralOrganizationProfile getGeneralOrganizationProfileId() {
        return generalOrganizationProfileId;
    }

    public void setGeneralOrganizationProfileId(GeneralOrganizationProfile generalOrganizationProfileId) {
        this.generalOrganizationProfileId = generalOrganizationProfileId;
    }

    public MainChartOfAccount getMainChartOfAccountId() {
        return mainChartOfAccountId;
    }

    public void setMainChartOfAccountId(MainChartOfAccount mainChartOfAccountId) {
        this.mainChartOfAccountId = mainChartOfAccountId;
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
        if (!(object instanceof OrgMainChartOfAccount)) {
            return false;
        }
        OrgMainChartOfAccount other = (OrgMainChartOfAccount) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.OrgMainChartOfAccount[ id=" + id + " ]";
    }
    
}
