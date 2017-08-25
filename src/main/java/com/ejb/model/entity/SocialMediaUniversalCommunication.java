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
@Table(name = "social_media_universal_communication")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SocialMediaUniversalCommunication.findAll", query = "SELECT s FROM SocialMediaUniversalCommunication s")
    , @NamedQuery(name = "SocialMediaUniversalCommunication.findById", query = "SELECT s FROM SocialMediaUniversalCommunication s WHERE s.id = :id")
    , @NamedQuery(name = "SocialMediaUniversalCommunication.findByStartDate", query = "SELECT s FROM SocialMediaUniversalCommunication s WHERE s.startDate = :startDate")
    , @NamedQuery(name = "SocialMediaUniversalCommunication.findByStartTime", query = "SELECT s FROM SocialMediaUniversalCommunication s WHERE s.startTime = :startTime")
    , @NamedQuery(name = "SocialMediaUniversalCommunication.findByEndDate", query = "SELECT s FROM SocialMediaUniversalCommunication s WHERE s.endDate = :endDate")
    , @NamedQuery(name = "SocialMediaUniversalCommunication.findByEndTime", query = "SELECT s FROM SocialMediaUniversalCommunication s WHERE s.endTime = :endTime")})
public class SocialMediaUniversalCommunication implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Column(name = "start_time")
    @Temporal(TemporalType.TIME)
    private Date startTime;
    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @Column(name = "end_time")
    @Temporal(TemporalType.TIME)
    private Date endTime;
    @JoinColumn(name = "social_media_universal_communication_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SocialMediaUniversalCommunicationType socialMediaUniversalCommunicationTypeId;
    @JoinColumn(name = "communicate_from", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SocialMediaProfilePage communicateFrom;
    @JoinColumn(name = "communicate_to", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SocialMediaProfilePage communicateTo;

    public SocialMediaUniversalCommunication() {
    }

    public SocialMediaUniversalCommunication(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public SocialMediaUniversalCommunicationType getSocialMediaUniversalCommunicationTypeId() {
        return socialMediaUniversalCommunicationTypeId;
    }

    public void setSocialMediaUniversalCommunicationTypeId(SocialMediaUniversalCommunicationType socialMediaUniversalCommunicationTypeId) {
        this.socialMediaUniversalCommunicationTypeId = socialMediaUniversalCommunicationTypeId;
    }

    public SocialMediaProfilePage getCommunicateFrom() {
        return communicateFrom;
    }

    public void setCommunicateFrom(SocialMediaProfilePage communicateFrom) {
        this.communicateFrom = communicateFrom;
    }

    public SocialMediaProfilePage getCommunicateTo() {
        return communicateTo;
    }

    public void setCommunicateTo(SocialMediaProfilePage communicateTo) {
        this.communicateTo = communicateTo;
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
        if (!(object instanceof SocialMediaUniversalCommunication)) {
            return false;
        }
        SocialMediaUniversalCommunication other = (SocialMediaUniversalCommunication) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.SocialMediaUniversalCommunication[ id=" + id + " ]";
    }
    
}
