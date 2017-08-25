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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "system_cange_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SystemCangeType.findAll", query = "SELECT s FROM SystemCangeType s")
    , @NamedQuery(name = "SystemCangeType.findById", query = "SELECT s FROM SystemCangeType s WHERE s.id = :id")})
public class SystemCangeType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "systemCangeTypeId")
    private Collection<SecurityActivityLog> securityActivityLogCollection;

    public SystemCangeType() {
    }

    public SystemCangeType(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @XmlTransient
    public Collection<SecurityActivityLog> getSecurityActivityLogCollection() {
        return securityActivityLogCollection;
    }

    public void setSecurityActivityLogCollection(Collection<SecurityActivityLog> securityActivityLogCollection) {
        this.securityActivityLogCollection = securityActivityLogCollection;
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
        if (!(object instanceof SystemCangeType)) {
            return false;
        }
        SystemCangeType other = (SystemCangeType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.SystemCangeType[ id=" + id + " ]";
    }
    
}
