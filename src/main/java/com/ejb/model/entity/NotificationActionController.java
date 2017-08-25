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
@Table(name = "notification_action_controller")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NotificationActionController.findAll", query = "SELECT n FROM NotificationActionController n")
    , @NamedQuery(name = "NotificationActionController.findById", query = "SELECT n FROM NotificationActionController n WHERE n.id = :id")})
public class NotificationActionController implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "general_user_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralUserProfile generalUserProfileId;
    @JoinColumn(name = "notification_action_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private NotificationAction notificationActionId;
    @JoinColumn(name = "notification_controller_voucher_item_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private NotificationControllerVoucherItem notificationControllerVoucherItemId;

    public NotificationActionController() {
    }

    public NotificationActionController(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public GeneralUserProfile getGeneralUserProfileId() {
        return generalUserProfileId;
    }

    public void setGeneralUserProfileId(GeneralUserProfile generalUserProfileId) {
        this.generalUserProfileId = generalUserProfileId;
    }

    public NotificationAction getNotificationActionId() {
        return notificationActionId;
    }

    public void setNotificationActionId(NotificationAction notificationActionId) {
        this.notificationActionId = notificationActionId;
    }

    public NotificationControllerVoucherItem getNotificationControllerVoucherItemId() {
        return notificationControllerVoucherItemId;
    }

    public void setNotificationControllerVoucherItemId(NotificationControllerVoucherItem notificationControllerVoucherItemId) {
        this.notificationControllerVoucherItemId = notificationControllerVoucherItemId;
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
        if (!(object instanceof NotificationActionController)) {
            return false;
        }
        NotificationActionController other = (NotificationActionController) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.NotificationActionController[ id=" + id + " ]";
    }
    
}
