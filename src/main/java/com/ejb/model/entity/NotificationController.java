/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb.model.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "notification_controller")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NotificationController.findAll", query = "SELECT n FROM NotificationController n")
    , @NamedQuery(name = "NotificationController.findById", query = "SELECT n FROM NotificationController n WHERE n.id = :id")
    , @NamedQuery(name = "NotificationController.findByDate", query = "SELECT n FROM NotificationController n WHERE n.date = :date")
    , @NamedQuery(name = "NotificationController.findByTime", query = "SELECT n FROM NotificationController n WHERE n.time = :time")
    , @NamedQuery(name = "NotificationController.findByIsCompleted", query = "SELECT n FROM NotificationController n WHERE n.isCompleted = :isCompleted")})
public class NotificationController implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "time")
    @Temporal(TemporalType.TIME)
    private Date time;
    @Column(name = "is_completed")
    private Integer isCompleted;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "notificationControllerId")
    private Collection<NotificationControllerVoucherItem> notificationControllerVoucherItemCollection;
    @JoinColumn(name = "notified_by", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralUserProfile notifiedBy;
    @JoinColumn(name = "notification_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private NotificationGeneratedForm notificationTypeId;
    @JoinColumn(name = "general_organization_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralOrganizationProfile generalOrganizationProfileId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "notificationControllerId")
    private Collection<NotificationControllerNotifiyTo> notificationControllerNotifiyToCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "notificationControllerId")
    private Collection<NotificationControllerVoucher> notificationControllerVoucherCollection;

    public NotificationController() {
    }

    public NotificationController(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(Integer isCompleted) {
        this.isCompleted = isCompleted;
    }

    @XmlTransient
    public Collection<NotificationControllerVoucherItem> getNotificationControllerVoucherItemCollection() {
        return notificationControllerVoucherItemCollection;
    }

    public void setNotificationControllerVoucherItemCollection(Collection<NotificationControllerVoucherItem> notificationControllerVoucherItemCollection) {
        this.notificationControllerVoucherItemCollection = notificationControllerVoucherItemCollection;
    }

    public GeneralUserProfile getNotifiedBy() {
        return notifiedBy;
    }

    public void setNotifiedBy(GeneralUserProfile notifiedBy) {
        this.notifiedBy = notifiedBy;
    }

    public NotificationGeneratedForm getNotificationTypeId() {
        return notificationTypeId;
    }

    public void setNotificationTypeId(NotificationGeneratedForm notificationTypeId) {
        this.notificationTypeId = notificationTypeId;
    }

    public GeneralOrganizationProfile getGeneralOrganizationProfileId() {
        return generalOrganizationProfileId;
    }

    public void setGeneralOrganizationProfileId(GeneralOrganizationProfile generalOrganizationProfileId) {
        this.generalOrganizationProfileId = generalOrganizationProfileId;
    }

    @XmlTransient
    public Collection<NotificationControllerNotifiyTo> getNotificationControllerNotifiyToCollection() {
        return notificationControllerNotifiyToCollection;
    }

    public void setNotificationControllerNotifiyToCollection(Collection<NotificationControllerNotifiyTo> notificationControllerNotifiyToCollection) {
        this.notificationControllerNotifiyToCollection = notificationControllerNotifiyToCollection;
    }

    @XmlTransient
    public Collection<NotificationControllerVoucher> getNotificationControllerVoucherCollection() {
        return notificationControllerVoucherCollection;
    }

    public void setNotificationControllerVoucherCollection(Collection<NotificationControllerVoucher> notificationControllerVoucherCollection) {
        this.notificationControllerVoucherCollection = notificationControllerVoucherCollection;
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
        if (!(object instanceof NotificationController)) {
            return false;
        }
        NotificationController other = (NotificationController) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.NotificationController[ id=" + id + " ]";
    }
    
}
