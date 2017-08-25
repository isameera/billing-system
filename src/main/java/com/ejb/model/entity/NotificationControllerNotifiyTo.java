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
@Table(name = "notification_controller_notifiy_to")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NotificationControllerNotifiyTo.findAll", query = "SELECT n FROM NotificationControllerNotifiyTo n")
    , @NamedQuery(name = "NotificationControllerNotifiyTo.findById", query = "SELECT n FROM NotificationControllerNotifiyTo n WHERE n.id = :id")})
public class NotificationControllerNotifiyTo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "notification_controller_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private NotificationController notificationControllerId;
    @JoinColumn(name = "user_role_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UserRole userRoleId;

    public NotificationControllerNotifiyTo() {
    }

    public NotificationControllerNotifiyTo(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public NotificationController getNotificationControllerId() {
        return notificationControllerId;
    }

    public void setNotificationControllerId(NotificationController notificationControllerId) {
        this.notificationControllerId = notificationControllerId;
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
        if (!(object instanceof NotificationControllerNotifiyTo)) {
            return false;
        }
        NotificationControllerNotifiyTo other = (NotificationControllerNotifiyTo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.NotificationControllerNotifiyTo[ id=" + id + " ]";
    }
    
}
