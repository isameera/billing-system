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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "user_role")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserRole.findAll", query = "SELECT u FROM UserRole u")
    , @NamedQuery(name = "UserRole.findById", query = "SELECT u FROM UserRole u WHERE u.id = :id")
    , @NamedQuery(name = "UserRole.findByRoleName", query = "SELECT u FROM UserRole u WHERE u.roleName = :roleName")
    , @NamedQuery(name = "UserRole.findByRoleOrder", query = "SELECT u FROM UserRole u WHERE u.roleOrder = :roleOrder")
    , @NamedQuery(name = "UserRole.findByDiscountRate", query = "SELECT u FROM UserRole u WHERE u.discountRate = :discountRate")})
public class UserRole implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "role_name")
    private String roleName;
    @Column(name = "role_order")
    private Integer roleOrder;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "discount_rate")
    private Double discountRate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userRoleId")
    private Collection<AccessLevelManager> accessLevelManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userRoleId")
    private Collection<LeafMatchRateByRoute> leafMatchRateByRouteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userRoleId")
    private Collection<UserRoleHasSystemInterface> userRoleHasSystemInterfaceCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userRoleId")
    private Collection<UserLoginGroup> userLoginGroupCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userRoleId")
    private Collection<UserLogin> userLoginCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userRoleId")
    private Collection<UseCaseHasUserRole> useCaseHasUserRoleCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userRoleId")
    private Collection<NotificationControllerNotifiyTo> notificationControllerNotifiyToCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userRoleId")
    private Collection<LoanTransferForApproval> loanTransferForApprovalCollection;

    public UserRole() {
    }

    public UserRole(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getRoleOrder() {
        return roleOrder;
    }

    public void setRoleOrder(Integer roleOrder) {
        this.roleOrder = roleOrder;
    }

    public Double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(Double discountRate) {
        this.discountRate = discountRate;
    }

    @XmlTransient
    public Collection<AccessLevelManager> getAccessLevelManagerCollection() {
        return accessLevelManagerCollection;
    }

    public void setAccessLevelManagerCollection(Collection<AccessLevelManager> accessLevelManagerCollection) {
        this.accessLevelManagerCollection = accessLevelManagerCollection;
    }

    @XmlTransient
    public Collection<LeafMatchRateByRoute> getLeafMatchRateByRouteCollection() {
        return leafMatchRateByRouteCollection;
    }

    public void setLeafMatchRateByRouteCollection(Collection<LeafMatchRateByRoute> leafMatchRateByRouteCollection) {
        this.leafMatchRateByRouteCollection = leafMatchRateByRouteCollection;
    }

    @XmlTransient
    public Collection<UserRoleHasSystemInterface> getUserRoleHasSystemInterfaceCollection() {
        return userRoleHasSystemInterfaceCollection;
    }

    public void setUserRoleHasSystemInterfaceCollection(Collection<UserRoleHasSystemInterface> userRoleHasSystemInterfaceCollection) {
        this.userRoleHasSystemInterfaceCollection = userRoleHasSystemInterfaceCollection;
    }

    @XmlTransient
    public Collection<UserLoginGroup> getUserLoginGroupCollection() {
        return userLoginGroupCollection;
    }

    public void setUserLoginGroupCollection(Collection<UserLoginGroup> userLoginGroupCollection) {
        this.userLoginGroupCollection = userLoginGroupCollection;
    }

    @XmlTransient
    public Collection<UserLogin> getUserLoginCollection() {
        return userLoginCollection;
    }

    public void setUserLoginCollection(Collection<UserLogin> userLoginCollection) {
        this.userLoginCollection = userLoginCollection;
    }

    @XmlTransient
    public Collection<UseCaseHasUserRole> getUseCaseHasUserRoleCollection() {
        return useCaseHasUserRoleCollection;
    }

    public void setUseCaseHasUserRoleCollection(Collection<UseCaseHasUserRole> useCaseHasUserRoleCollection) {
        this.useCaseHasUserRoleCollection = useCaseHasUserRoleCollection;
    }

    @XmlTransient
    public Collection<NotificationControllerNotifiyTo> getNotificationControllerNotifiyToCollection() {
        return notificationControllerNotifiyToCollection;
    }

    public void setNotificationControllerNotifiyToCollection(Collection<NotificationControllerNotifiyTo> notificationControllerNotifiyToCollection) {
        this.notificationControllerNotifiyToCollection = notificationControllerNotifiyToCollection;
    }

    @XmlTransient
    public Collection<LoanTransferForApproval> getLoanTransferForApprovalCollection() {
        return loanTransferForApprovalCollection;
    }

    public void setLoanTransferForApprovalCollection(Collection<LoanTransferForApproval> loanTransferForApprovalCollection) {
        this.loanTransferForApprovalCollection = loanTransferForApprovalCollection;
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
        if (!(object instanceof UserRole)) {
            return false;
        }
        UserRole other = (UserRole) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.UserRole[ id=" + id + " ]";
    }
    
}
