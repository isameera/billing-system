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
@Table(name = "notification_controller_voucher")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NotificationControllerVoucher.findAll", query = "SELECT n FROM NotificationControllerVoucher n")
    , @NamedQuery(name = "NotificationControllerVoucher.findById", query = "SELECT n FROM NotificationControllerVoucher n WHERE n.id = :id")
    , @NamedQuery(name = "NotificationControllerVoucher.findByIsCompleted", query = "SELECT n FROM NotificationControllerVoucher n WHERE n.isCompleted = :isCompleted")})
public class NotificationControllerVoucher implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "is_completed")
    private Integer isCompleted;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "notificationControllerVoucherId")
    private Collection<NotificationControllerVoucherItem> notificationControllerVoucherItemCollection;
    @JoinColumn(name = "notification_controller_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private NotificationController notificationControllerId;
    @JoinColumn(name = "voucher_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Voucher voucherId;

    public NotificationControllerVoucher() {
    }

    public NotificationControllerVoucher(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public NotificationController getNotificationControllerId() {
        return notificationControllerId;
    }

    public void setNotificationControllerId(NotificationController notificationControllerId) {
        this.notificationControllerId = notificationControllerId;
    }

    public Voucher getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(Voucher voucherId) {
        this.voucherId = voucherId;
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
        if (!(object instanceof NotificationControllerVoucher)) {
            return false;
        }
        NotificationControllerVoucher other = (NotificationControllerVoucher) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.NotificationControllerVoucher[ id=" + id + " ]";
    }
    
}
