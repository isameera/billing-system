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
@Table(name = "access_level_manager")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AccessLevelManager.findAll", query = "SELECT a FROM AccessLevelManager a")
    , @NamedQuery(name = "AccessLevelManager.findById", query = "SELECT a FROM AccessLevelManager a WHERE a.id = :id")})
public class AccessLevelManager implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "access_level_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private AccessLevel accessLevelId;
    @JoinColumn(name = "use_case_has_system_interface_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UseCaseHasSystemInterface useCaseHasSystemInterfaceId;
    @JoinColumn(name = "user_role_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UserRole userRoleId;

    public AccessLevelManager() {
    }

    public AccessLevelManager(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AccessLevel getAccessLevelId() {
        return accessLevelId;
    }

    public void setAccessLevelId(AccessLevel accessLevelId) {
        this.accessLevelId = accessLevelId;
    }

    public UseCaseHasSystemInterface getUseCaseHasSystemInterfaceId() {
        return useCaseHasSystemInterfaceId;
    }

    public void setUseCaseHasSystemInterfaceId(UseCaseHasSystemInterface useCaseHasSystemInterfaceId) {
        this.useCaseHasSystemInterfaceId = useCaseHasSystemInterfaceId;
    }

    public UserRole getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(UserRole userRoleId) {
        this.userRoleId = userRoleId;
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
        if (!(object instanceof AccessLevelManager)) {
            return false;
        }
        AccessLevelManager other = (AccessLevelManager) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.AccessLevelManager[ id=" + id + " ]";
    }
    
}
