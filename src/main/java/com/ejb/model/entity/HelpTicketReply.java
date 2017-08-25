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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "help_ticket_reply")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HelpTicketReply.findAll", query = "SELECT h FROM HelpTicketReply h")
    , @NamedQuery(name = "HelpTicketReply.findById", query = "SELECT h FROM HelpTicketReply h WHERE h.id = :id")
    , @NamedQuery(name = "HelpTicketReply.findByDate", query = "SELECT h FROM HelpTicketReply h WHERE h.date = :date")
    , @NamedQuery(name = "HelpTicketReply.findBySubject", query = "SELECT h FROM HelpTicketReply h WHERE h.subject = :subject")
    , @NamedQuery(name = "HelpTicketReply.findByDoc", query = "SELECT h FROM HelpTicketReply h WHERE h.doc = :doc")
    , @NamedQuery(name = "HelpTicketReply.findByRatings", query = "SELECT h FROM HelpTicketReply h WHERE h.ratings = :ratings")
    , @NamedQuery(name = "HelpTicketReply.findByIsViewed", query = "SELECT h FROM HelpTicketReply h WHERE h.isViewed = :isViewed")})
public class HelpTicketReply implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Size(max = 945)
    @Column(name = "subject")
    private String subject;
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    @Lob
    @Size(max = 65535)
    @Column(name = "comment")
    private String comment;
    @Size(max = 245)
    @Column(name = "doc")
    private String doc;
    @Column(name = "ratings")
    private Integer ratings;
    @Column(name = "is_viewed")
    private Boolean isViewed;
    @JoinColumn(name = "general_user_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralUserProfile generalUserProfileId;
    @JoinColumn(name = "help_ticket_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private HelpTicket helpTicketId;

    public HelpTicketReply() {
    }

    public HelpTicketReply(Integer id) {
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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDoc() {
        return doc;
    }

    public void setDoc(String doc) {
        this.doc = doc;
    }

    public Integer getRatings() {
        return ratings;
    }

    public void setRatings(Integer ratings) {
        this.ratings = ratings;
    }

    public Boolean getIsViewed() {
        return isViewed;
    }

    public void setIsViewed(Boolean isViewed) {
        this.isViewed = isViewed;
    }

    public GeneralUserProfile getGeneralUserProfileId() {
        return generalUserProfileId;
    }

    public void setGeneralUserProfileId(GeneralUserProfile generalUserProfileId) {
        this.generalUserProfileId = generalUserProfileId;
    }

    public HelpTicket getHelpTicketId() {
        return helpTicketId;
    }

    public void setHelpTicketId(HelpTicket helpTicketId) {
        this.helpTicketId = helpTicketId;
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
        if (!(object instanceof HelpTicketReply)) {
            return false;
        }
        HelpTicketReply other = (HelpTicketReply) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.HelpTicketReply[ id=" + id + " ]";
    }
    
}
