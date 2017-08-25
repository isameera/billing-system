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
@Table(name = "privilage_manager")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrivilageManager.findAll", query = "SELECT p FROM PrivilageManager p")
    , @NamedQuery(name = "PrivilageManager.findById", query = "SELECT p FROM PrivilageManager p WHERE p.id = :id")
    , @NamedQuery(name = "PrivilageManager.findByPrivilageManagercol", query = "SELECT p FROM PrivilageManager p WHERE p.privilageManagercol = :privilageManagercol")})
public class PrivilageManager implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "privilage_managercol")
    private String privilageManagercol;
    @JoinColumn(name = "system_interface_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SystemInterface systemInterfaceId;
    @JoinColumn(name = "user_login_group_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UserLoginGroup userLoginGroupId;

    public PrivilageManager() {
    }

    public PrivilageManager(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPrivilageManagercol() {
        return privilageManagercol;
    }

    public void setPrivilageManagercol(String privilageManagercol) {
        this.privilageManagercol = privilageManagercol;
    }

    public SystemInterface getSystemInterfaceId() {
        return systemInterfaceId;
    }

    public void setSystemInterfaceId(SystemInterface systemInterfaceId) {
        this.systemInterfaceId = systemInterfaceId;
    }

    public UserLoginGroup getUserLoginGroupId() {
        return userLoginGroupId;
    }

    public void setUserLoginGroupId(UserLoginGroup userLoginGroupId) {
        this.userLoginGroupId = userLoginGroupId;
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
        if (!(object instanceof PrivilageManager)) {
            return false;
        }
        PrivilageManager other = (PrivilageManager) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.PrivilageManager[ id=" + id + " ]";
    }
    
}
