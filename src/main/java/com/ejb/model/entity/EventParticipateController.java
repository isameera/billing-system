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
@Table(name = "event_participate_controller")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EventParticipateController.findAll", query = "SELECT e FROM EventParticipateController e")
    , @NamedQuery(name = "EventParticipateController.findById", query = "SELECT e FROM EventParticipateController e WHERE e.id = :id")
    , @NamedQuery(name = "EventParticipateController.findByBankSlip", query = "SELECT e FROM EventParticipateController e WHERE e.bankSlip = :bankSlip")})
public class EventParticipateController implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "bank_slip")
    private String bankSlip;
    @JoinColumn(name = "social_media_events_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SocialMediaEvents socialMediaEventsId;
    @JoinColumn(name = "social_media_profile_page_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SocialMediaProfilePage socialMediaProfilePageId;

    public EventParticipateController() {
    }

    public EventParticipateController(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBankSlip() {
        return bankSlip;
    }

    public void setBankSlip(String bankSlip) {
        this.bankSlip = bankSlip;
    }

    public SocialMediaEvents getSocialMediaEventsId() {
        return socialMediaEventsId;
    }

    public void setSocialMediaEventsId(SocialMediaEvents socialMediaEventsId) {
        this.socialMediaEventsId = socialMediaEventsId;
    }

    public SocialMediaProfilePage getSocialMediaProfilePageId() {
        return socialMediaProfilePageId;
    }

    public void setSocialMediaProfilePageId(SocialMediaProfilePage socialMediaProfilePageId) {
        this.socialMediaProfilePageId = socialMediaProfilePageId;
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
        if (!(object instanceof EventParticipateController)) {
            return false;
        }
        EventParticipateController other = (EventParticipateController) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.EventParticipateController[ id=" + id + " ]";
    }
    
}
