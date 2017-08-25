/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb.model.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "magazene_subscriber")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MagazeneSubscriber.findAll", query = "SELECT m FROM MagazeneSubscriber m")
    , @NamedQuery(name = "MagazeneSubscriber.findById", query = "SELECT m FROM MagazeneSubscriber m WHERE m.id = :id")
    , @NamedQuery(name = "MagazeneSubscriber.findBySubscribedDate", query = "SELECT m FROM MagazeneSubscriber m WHERE m.subscribedDate = :subscribedDate")
    , @NamedQuery(name = "MagazeneSubscriber.findByIsPaid", query = "SELECT m FROM MagazeneSubscriber m WHERE m.isPaid = :isPaid")})
public class MagazeneSubscriber implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "subscribed_date")
    @Temporal(TemporalType.DATE)
    private Date subscribedDate;
    @Column(name = "is_paid")
    private Integer isPaid;
    @JoinColumn(name = "general_user_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralUserProfile generalUserProfileId;
    @JoinColumn(name = "magazine_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Magazine magazineId;

    public MagazeneSubscriber() {
    }

    public MagazeneSubscriber(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getSubscribedDate() {
        return subscribedDate;
    }

    public void setSubscribedDate(Date subscribedDate) {
        this.subscribedDate = subscribedDate;
    }

    public Integer getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(Integer isPaid) {
        this.isPaid = isPaid;
    }

    public GeneralUserProfile getGeneralUserProfileId() {
        return generalUserProfileId;
    }

    public void setGeneralUserProfileId(GeneralUserProfile generalUserProfileId) {
        this.generalUserProfileId = generalUserProfileId;
    }

    public Magazine getMagazineId() {
        return magazineId;
    }

    public void setMagazineId(Magazine magazineId) {
        this.magazineId = magazineId;
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
        if (!(object instanceof MagazeneSubscriber)) {
            return false;
        }
        MagazeneSubscriber other = (MagazeneSubscriber) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.MagazeneSubscriber[ id=" + id + " ]";
    }
    
}
