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
@Table(name = "interface_menu_gop_manager")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InterfaceMenuGopManager.findAll", query = "SELECT i FROM InterfaceMenuGopManager i")
    , @NamedQuery(name = "InterfaceMenuGopManager.findById", query = "SELECT i FROM InterfaceMenuGopManager i WHERE i.id = :id")})
public class InterfaceMenuGopManager implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "general_organization_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralOrganizationProfile generalOrganizationProfileId;
    @JoinColumn(name = "interface_menu_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private InterfaceMenu interfaceMenuId;

    public InterfaceMenuGopManager() {
    }

    public InterfaceMenuGopManager(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public GeneralOrganizationProfile getGeneralOrganizationProfileId() {
        return generalOrganizationProfileId;
    }

    public void setGeneralOrganizationProfileId(GeneralOrganizationProfile generalOrganizationProfileId) {
        this.generalOrganizationProfileId = generalOrganizationProfileId;
    }

    public InterfaceMenu getInterfaceMenuId() {
        return interfaceMenuId;
    }

    public void setInterfaceMenuId(InterfaceMenu interfaceMenuId) {
        this.interfaceMenuId = interfaceMenuId;
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
        if (!(object instanceof InterfaceMenuGopManager)) {
            return false;
        }
        InterfaceMenuGopManager other = (InterfaceMenuGopManager) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.InterfaceMenuGopManager[ id=" + id + " ]";
    }
    
}
