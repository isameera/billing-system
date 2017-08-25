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
@Table(name = "use_case_has_system_interface")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UseCaseHasSystemInterface.findAll", query = "SELECT u FROM UseCaseHasSystemInterface u")
    , @NamedQuery(name = "UseCaseHasSystemInterface.findById", query = "SELECT u FROM UseCaseHasSystemInterface u WHERE u.id = :id")})
public class UseCaseHasSystemInterface implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "useCaseHasSystemInterfaceId")
    private Collection<AccessLevelManager> accessLevelManagerCollection;
    @JoinColumn(name = "system_interface_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SystemInterface systemInterfaceId;
    @JoinColumn(name = "use_case_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UseCase useCaseId;

    public UseCaseHasSystemInterface() {
    }

    public UseCaseHasSystemInterface(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @XmlTransient
    public Collection<AccessLevelManager> getAccessLevelManagerCollection() {
        return accessLevelManagerCollection;
    }

    public void setAccessLevelManagerCollection(Collection<AccessLevelManager> accessLevelManagerCollection) {
        this.accessLevelManagerCollection = accessLevelManagerCollection;
    }

    public SystemInterface getSystemInterfaceId() {
        return systemInterfaceId;
    }

    public void setSystemInterfaceId(SystemInterface systemInterfaceId) {
        this.systemInterfaceId = systemInterfaceId;
    }

    public UseCase getUseCaseId() {
        return useCaseId;
    }

    public void setUseCaseId(UseCase useCaseId) {
        this.useCaseId = useCaseId;
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
        if (!(object instanceof UseCaseHasSystemInterface)) {
            return false;
        }
        UseCaseHasSystemInterface other = (UseCaseHasSystemInterface) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.UseCaseHasSystemInterface[ id=" + id + " ]";
    }
    
}
