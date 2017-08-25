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
@Table(name = "sub_chart_of_account_level_manager")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SubChartOfAccountLevelManager.findAll", query = "SELECT s FROM SubChartOfAccountLevelManager s")
    , @NamedQuery(name = "SubChartOfAccountLevelManager.findById", query = "SELECT s FROM SubChartOfAccountLevelManager s WHERE s.id = :id")})
public class SubChartOfAccountLevelManager implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "sub_chart_of_account_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SubChartOfAccount subChartOfAccountId;
    @JoinColumn(name = "sub_chart_of_account_id1", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SubChartOfAccount subChartOfAccountId1;

    public SubChartOfAccountLevelManager() {
    }

    public SubChartOfAccountLevelManager(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public SubChartOfAccount getSubChartOfAccountId() {
        return subChartOfAccountId;
    }

    public void setSubChartOfAccountId(SubChartOfAccount subChartOfAccountId) {
        this.subChartOfAccountId = subChartOfAccountId;
    }

    public SubChartOfAccount getSubChartOfAccountId1() {
        return subChartOfAccountId1;
    }

    public void setSubChartOfAccountId1(SubChartOfAccount subChartOfAccountId1) {
        this.subChartOfAccountId1 = subChartOfAccountId1;
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
        if (!(object instanceof SubChartOfAccountLevelManager)) {
            return false;
        }
        SubChartOfAccountLevelManager other = (SubChartOfAccountLevelManager) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.SubChartOfAccountLevelManager[ id=" + id + " ]";
    }
    
}
