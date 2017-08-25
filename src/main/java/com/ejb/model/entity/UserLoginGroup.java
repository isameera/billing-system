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
@Table(name = "user_login_group")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserLoginGroup.findAll", query = "SELECT u FROM UserLoginGroup u")
    , @NamedQuery(name = "UserLoginGroup.findById", query = "SELECT u FROM UserLoginGroup u WHERE u.id = :id")
    , @NamedQuery(name = "UserLoginGroup.findByIsActive", query = "SELECT u FROM UserLoginGroup u WHERE u.isActive = :isActive")
    , @NamedQuery(name = "UserLoginGroup.findByMaxLoginAttempt", query = "SELECT u FROM UserLoginGroup u WHERE u.maxLoginAttempt = :maxLoginAttempt")
    , @NamedQuery(name = "UserLoginGroup.findByIsFirstTime", query = "SELECT u FROM UserLoginGroup u WHERE u.isFirstTime = :isFirstTime")
    , @NamedQuery(name = "UserLoginGroup.findByCountAttempt", query = "SELECT u FROM UserLoginGroup u WHERE u.countAttempt = :countAttempt")})
public class UserLoginGroup implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "is_active")
    private Integer isActive;
    @Column(name = "max_login_attempt")
    private Integer maxLoginAttempt;
    @Column(name = "is_first_time")
    private Boolean isFirstTime;
    @Column(name = "count_attempt")
    private Integer countAttempt;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userLoginGroupId")
    private Collection<LoginSession> loginSessionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userLoginGroupId")
    private Collection<PrivilageManager> privilageManagerCollection;
    @JoinColumn(name = "general_organization_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralOrganizationProfile generalOrganizationProfileId;
    @JoinColumn(name = "user_login_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UserLogin userLoginId;
    @JoinColumn(name = "user_role_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UserRole userRoleId;

    public UserLoginGroup() {
    }

    public UserLoginGroup(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    public Integer getMaxLoginAttempt() {
        return maxLoginAttempt;
    }

    public void setMaxLoginAttempt(Integer maxLoginAttempt) {
        this.maxLoginAttempt = maxLoginAttempt;
    }

    public Boolean getIsFirstTime() {
        return isFirstTime;
    }

    public void setIsFirstTime(Boolean isFirstTime) {
        this.isFirstTime = isFirstTime;
    }

    public Integer getCountAttempt() {
        return countAttempt;
    }

    public void setCountAttempt(Integer countAttempt) {
        this.countAttempt = countAttempt;
    }

    @XmlTransient
    public Collection<LoginSession> getLoginSessionCollection() {
        return loginSessionCollection;
    }

    public void setLoginSessionCollection(Collection<LoginSession> loginSessionCollection) {
        this.loginSessionCollection = loginSessionCollection;
    }

    @XmlTransient
    public Collection<PrivilageManager> getPrivilageManagerCollection() {
        return privilageManagerCollection;
    }

    public void setPrivilageManagerCollection(Collection<PrivilageManager> privilageManagerCollection) {
        this.privilageManagerCollection = privilageManagerCollection;
    }

    public GeneralOrganizationProfile getGeneralOrganizationProfileId() {
        return generalOrganizationProfileId;
    }

    public void setGeneralOrganizationProfileId(GeneralOrganizationProfile generalOrganizationProfileId) {
        this.generalOrganizationProfileId = generalOrganizationProfileId;
    }

    public UserLogin getUserLoginId() {
        return userLoginId;
    }

    public void setUserLoginId(UserLogin userLoginId) {
        this.userLoginId = userLoginId;
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
        if (!(object instanceof UserLoginGroup)) {
            return false;
        }
        UserLoginGroup other = (UserLoginGroup) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.UserLoginGroup[ id=" + id + " ]";
    }
    
}
