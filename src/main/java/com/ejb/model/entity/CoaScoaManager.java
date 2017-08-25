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
@Table(name = "coa_scoa_manager")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CoaScoaManager.findAll", query = "SELECT c FROM CoaScoaManager c")
    , @NamedQuery(name = "CoaScoaManager.findById", query = "SELECT c FROM CoaScoaManager c WHERE c.id = :id")})
public class CoaScoaManager implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "chart_of_account_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ChartOfAccount chartOfAccountId;
    @JoinColumn(name = "sub_chart_of_account_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SubChartOfAccount subChartOfAccountId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "coaScoaManagerId")
    private Collection<TransactionManagement> transactionManagementCollection;

    public CoaScoaManager() {
    }

    public CoaScoaManager(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ChartOfAccount getChartOfAccountId() {
        return chartOfAccountId;
    }

    public void setChartOfAccountId(ChartOfAccount chartOfAccountId) {
        this.chartOfAccountId = chartOfAccountId;
    }

    public SubChartOfAccount getSubChartOfAccountId() {
        return subChartOfAccountId;
    }

    public void setSubChartOfAccountId(SubChartOfAccount subChartOfAccountId) {
        this.subChartOfAccountId = subChartOfAccountId;
    }

    @XmlTransient
    public Collection<TransactionManagement> getTransactionManagementCollection() {
        return transactionManagementCollection;
    }

    public void setTransactionManagementCollection(Collection<TransactionManagement> transactionManagementCollection) {
        this.transactionManagementCollection = transactionManagementCollection;
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
        if (!(object instanceof CoaScoaManager)) {
            return false;
        }
        CoaScoaManager other = (CoaScoaManager) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.CoaScoaManager[ id=" + id + " ]";
    }
    
}
