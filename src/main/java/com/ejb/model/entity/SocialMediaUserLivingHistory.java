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
@Table(name = "social_media_user_living_history")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SocialMediaUserLivingHistory.findAll", query = "SELECT s FROM SocialMediaUserLivingHistory s")
    , @NamedQuery(name = "SocialMediaUserLivingHistory.findById", query = "SELECT s FROM SocialMediaUserLivingHistory s WHERE s.id = :id")
    , @NamedQuery(name = "SocialMediaUserLivingHistory.findByDateFrom", query = "SELECT s FROM SocialMediaUserLivingHistory s WHERE s.dateFrom = :dateFrom")
    , @NamedQuery(name = "SocialMediaUserLivingHistory.findByDateTo", query = "SELECT s FROM SocialMediaUserLivingHistory s WHERE s.dateTo = :dateTo")})
public class SocialMediaUserLivingHistory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "date_from")
    @Temporal(TemporalType.DATE)
    private Date dateFrom;
    @Column(name = "date_to")
    @Temporal(TemporalType.DATE)
    private Date dateTo;
    @JoinColumn(name = "city_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private City cityId;
    @JoinColumn(name = "social_media_profile_page_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SocialMediaProfilePage socialMediaProfilePageId;
    @JoinColumn(name = "social_media_user_living_history_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SocialMediaUserLivingHistoryType socialMediaUserLivingHistoryTypeId;

    public SocialMediaUserLivingHistory() {
    }

    public SocialMediaUserLivingHistory(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public City getCityId() {
        return cityId;
    }

    public void setCityId(City cityId) {
        this.cityId = cityId;
    }

    public SocialMediaProfilePage getSocialMediaProfilePageId() {
        return socialMediaProfilePageId;
    }

    public void setSocialMediaProfilePageId(SocialMediaProfilePage socialMediaProfilePageId) {
        this.socialMediaProfilePageId = socialMediaProfilePageId;
    }

    public SocialMediaUserLivingHistoryType getSocialMediaUserLivingHistoryTypeId() {
        return socialMediaUserLivingHistoryTypeId;
    }

    public void setSocialMediaUserLivingHistoryTypeId(SocialMediaUserLivingHistoryType socialMediaUserLivingHistoryTypeId) {
        this.socialMediaUserLivingHistoryTypeId = socialMediaUserLivingHistoryTypeId;
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
        if (!(object instanceof SocialMediaUserLivingHistory)) {
            return false;
        }
        SocialMediaUserLivingHistory other = (SocialMediaUserLivingHistory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.SocialMediaUserLivingHistory[ id=" + id + " ]";
    }
    
}
