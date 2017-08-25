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
@Table(name = "social_media_events_controller")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SocialMediaEventsController.findAll", query = "SELECT s FROM SocialMediaEventsController s")
    , @NamedQuery(name = "SocialMediaEventsController.findById", query = "SELECT s FROM SocialMediaEventsController s WHERE s.id = :id")})
public class SocialMediaEventsController implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "social_media_events_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SocialMediaEvents socialMediaEventsId;
    @JoinColumn(name = "social_media_univarsal_post_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SocialMediaUnivarsalPost socialMediaUnivarsalPostId;

    public SocialMediaEventsController() {
    }

    public SocialMediaEventsController(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public SocialMediaEvents getSocialMediaEventsId() {
        return socialMediaEventsId;
    }

    public void setSocialMediaEventsId(SocialMediaEvents socialMediaEventsId) {
        this.socialMediaEventsId = socialMediaEventsId;
    }

    public SocialMediaUnivarsalPost getSocialMediaUnivarsalPostId() {
        return socialMediaUnivarsalPostId;
    }

    public void setSocialMediaUnivarsalPostId(SocialMediaUnivarsalPost socialMediaUnivarsalPostId) {
        this.socialMediaUnivarsalPostId = socialMediaUnivarsalPostId;
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
        if (!(object instanceof SocialMediaEventsController)) {
            return false;
        }
        SocialMediaEventsController other = (SocialMediaEventsController) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.SocialMediaEventsController[ id=" + id + " ]";
    }
    
}
