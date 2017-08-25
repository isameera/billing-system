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
@Table(name = "coa_account_category")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CoaAccountCategory.findAll", query = "SELECT c FROM CoaAccountCategory c")
    , @NamedQuery(name = "CoaAccountCategory.findById", query = "SELECT c FROM CoaAccountCategory c WHERE c.id = :id")})
public class CoaAccountCategory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "account_category_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private AccountCategory accountCategoryId;
    @JoinColumn(name = "chart_of_account_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ChartOfAccount chartOfAccountId;

    public CoaAccountCategory() {
    }

    public CoaAccountCategory(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AccountCategory getAccountCategoryId() {
        return accountCategoryId;
    }

    public void setAccountCategoryId(AccountCategory accountCategoryId) {
        this.accountCategoryId = accountCategoryId;
    }

    public ChartOfAccount getChartOfAccountId() {
        return chartOfAccountId;
    }

    public void setChartOfAccountId(ChartOfAccount chartOfAccountId) {
        this.chartOfAccountId = chartOfAccountId;
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
        if (!(object instanceof CoaAccountCategory)) {
            return false;
        }
        CoaAccountCategory other = (CoaAccountCategory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.CoaAccountCategory[ id=" + id + " ]";
    }
    
}
