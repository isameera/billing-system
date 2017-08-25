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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "help_ticket")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HelpTicket.findAll", query = "SELECT h FROM HelpTicket h")
    , @NamedQuery(name = "HelpTicket.findById", query = "SELECT h FROM HelpTicket h WHERE h.id = :id")
    , @NamedQuery(name = "HelpTicket.findByDate", query = "SELECT h FROM HelpTicket h WHERE h.date = :date")
    , @NamedQuery(name = "HelpTicket.findBySubject", query = "SELECT h FROM HelpTicket h WHERE h.subject = :subject")
    , @NamedQuery(name = "HelpTicket.findByDoc", query = "SELECT h FROM HelpTicket h WHERE h.doc = :doc")
    , @NamedQuery(name = "HelpTicket.findByPhone", query = "SELECT h FROM HelpTicket h WHERE h.phone = :phone")
    , @NamedQuery(name = "HelpTicket.findByEmail", query = "SELECT h FROM HelpTicket h WHERE h.email = :email")
    , @NamedQuery(name = "HelpTicket.findByIsViewed", query = "SELECT h FROM HelpTicket h WHERE h.isViewed = :isViewed")})
public class HelpTicket implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Size(max = 845)
    @Column(name = "subject")
    private String subject;
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    @Size(max = 245)
    @Column(name = "doc")
    private String doc;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 45)
    @Column(name = "phone")
    private String phone;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 45)
    @Column(name = "email")
    private String email;
    @Column(name = "is_viewed")
    private Boolean isViewed;
    @JoinColumn(name = "general_organization_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralOrganizationProfile generalOrganizationProfileId;
    @JoinColumn(name = "general_user_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralUserProfile generalUserProfileId;
    @JoinColumn(name = "help_ticket_status_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private HelpTicketStatus helpTicketStatusId;
    @JoinColumn(name = "help_ticket_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private HelpTicketType helpTicketTypeId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "helpTicketId")
    private Collection<HelpTicketReply> helpTicketReplyCollection;

    public HelpTicket() {
    }

    public HelpTicket(Integer id) {
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

    public String getDoc() {
        return doc;
    }

    public void setDoc(String doc) {
        this.doc = doc;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getIsViewed() {
        return isViewed;
    }

    public void setIsViewed(Boolean isViewed) {
        this.isViewed = isViewed;
    }

    public GeneralOrganizationProfile getGeneralOrganizationProfileId() {
        return generalOrganizationProfileId;
    }

    public void setGeneralOrganizationProfileId(GeneralOrganizationProfile generalOrganizationProfileId) {
        this.generalOrganizationProfileId = generalOrganizationProfileId;
    }

    public GeneralUserProfile getGeneralUserProfileId() {
        return generalUserProfileId;
    }

    public void setGeneralUserProfileId(GeneralUserProfile generalUserProfileId) {
        this.generalUserProfileId = generalUserProfileId;
    }

    public HelpTicketStatus getHelpTicketStatusId() {
        return helpTicketStatusId;
    }

    public void setHelpTicketStatusId(HelpTicketStatus helpTicketStatusId) {
        this.helpTicketStatusId = helpTicketStatusId;
    }

    public HelpTicketType getHelpTicketTypeId() {
        return helpTicketTypeId;
    }

    public void setHelpTicketTypeId(HelpTicketType helpTicketTypeId) {
        this.helpTicketTypeId = helpTicketTypeId;
    }

    @XmlTransient
    public Collection<HelpTicketReply> getHelpTicketReplyCollection() {
        return helpTicketReplyCollection;
    }

    public void setHelpTicketReplyCollection(Collection<HelpTicketReply> helpTicketReplyCollection) {
        this.helpTicketReplyCollection = helpTicketReplyCollection;
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
        if (!(object instanceof HelpTicket)) {
            return false;
        }
        HelpTicket other = (HelpTicket) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.HelpTicket[ id=" + id + " ]";
    }
    
}
