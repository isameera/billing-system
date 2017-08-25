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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "universal_status_manager")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UniversalStatusManager.findAll", query = "SELECT u FROM UniversalStatusManager u")
    , @NamedQuery(name = "UniversalStatusManager.findById", query = "SELECT u FROM UniversalStatusManager u WHERE u.id = :id")
    , @NamedQuery(name = "UniversalStatusManager.findByReference", query = "SELECT u FROM UniversalStatusManager u WHERE u.reference = :reference")
    , @NamedQuery(name = "UniversalStatusManager.findByValue", query = "SELECT u FROM UniversalStatusManager u WHERE u.value = :value")})
public class UniversalStatusManager implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "reference")
    private Integer reference;
    @Column(name = "value")
    private Integer value;
    @Lob
    @Size(max = 65535)
    @Column(name = "desccription")
    private String desccription;
    @JoinColumn(name = "table_manager_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TableManager tableManagerId;
    @JoinColumn(name = "universal_status_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UniversalStatus universalStatusId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "universalStatusManagerId")
    private Collection<StatusChangedBy> statusChangedByCollection;

    public UniversalStatusManager() {
    }

    public UniversalStatusManager(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getReference() {
        return reference;
    }

    public void setReference(Integer reference) {
        this.reference = reference;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getDesccription() {
        return desccription;
    }

    public void setDesccription(String desccription) {
        this.desccription = desccription;
    }

    public TableManager getTableManagerId() {
        return tableManagerId;
    }

    public void setTableManagerId(TableManager tableManagerId) {
        this.tableManagerId = tableManagerId;
    }

    public UniversalStatus getUniversalStatusId() {
        return universalStatusId;
    }

    public void setUniversalStatusId(UniversalStatus universalStatusId) {
        this.universalStatusId = universalStatusId;
    }

    @XmlTransient
    public Collection<StatusChangedBy> getStatusChangedByCollection() {
        return statusChangedByCollection;
    }

    public void setStatusChangedByCollection(Collection<StatusChangedBy> statusChangedByCollection) {
        this.statusChangedByCollection = statusChangedByCollection;
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
        if (!(object instanceof UniversalStatusManager)) {
            return false;
        }
        UniversalStatusManager other = (UniversalStatusManager) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.UniversalStatusManager[ id=" + id + " ]";
    }
    
}
