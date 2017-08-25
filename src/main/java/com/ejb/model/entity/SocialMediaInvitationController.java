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
@Table(name = "social_media_invitation_controller")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SocialMediaInvitationController.findAll", query = "SELECT s FROM SocialMediaInvitationController s")
    , @NamedQuery(name = "SocialMediaInvitationController.findById", query = "SELECT s FROM SocialMediaInvitationController s WHERE s.id = :id")})
public class SocialMediaInvitationController implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "com_post_controller_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ComPostController comPostControllerId;
    @JoinColumn(name = "social_media_group_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SocialMediaGroup socialMediaGroupId;

    public SocialMediaInvitationController() {
    }

    public SocialMediaInvitationController(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ComPostController getComPostControllerId() {
        return comPostControllerId;
    }

    public void setComPostControllerId(ComPostController comPostControllerId) {
        this.comPostControllerId = comPostControllerId;
    }

    public SocialMediaGroup getSocialMediaGroupId() {
        return socialMediaGroupId;
    }

    public void setSocialMediaGroupId(SocialMediaGroup socialMediaGroupId) {
        this.socialMediaGroupId = socialMediaGroupId;
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
        if (!(object instanceof SocialMediaInvitationController)) {
            return false;
        }
        SocialMediaInvitationController other = (SocialMediaInvitationController) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.SocialMediaInvitationController[ id=" + id + " ]";
    }
    
}
