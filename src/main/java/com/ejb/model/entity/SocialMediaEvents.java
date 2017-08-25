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
@Table(name = "social_media_events")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SocialMediaEvents.findAll", query = "SELECT s FROM SocialMediaEvents s")
    , @NamedQuery(name = "SocialMediaEvents.findById", query = "SELECT s FROM SocialMediaEvents s WHERE s.id = :id")
    , @NamedQuery(name = "SocialMediaEvents.findByName", query = "SELECT s FROM SocialMediaEvents s WHERE s.name = :name")
    , @NamedQuery(name = "SocialMediaEvents.findByPublishTime", query = "SELECT s FROM SocialMediaEvents s WHERE s.publishTime = :publishTime")
    , @NamedQuery(name = "SocialMediaEvents.findByPublishDate", query = "SELECT s FROM SocialMediaEvents s WHERE s.publishDate = :publishDate")
    , @NamedQuery(name = "SocialMediaEvents.findByDateFrom", query = "SELECT s FROM SocialMediaEvents s WHERE s.dateFrom = :dateFrom")
    , @NamedQuery(name = "SocialMediaEvents.findByDateTo", query = "SELECT s FROM SocialMediaEvents s WHERE s.dateTo = :dateTo")
    , @NamedQuery(name = "SocialMediaEvents.findByTimeFrom", query = "SELECT s FROM SocialMediaEvents s WHERE s.timeFrom = :timeFrom")
    , @NamedQuery(name = "SocialMediaEvents.findByTimeTo", query = "SELECT s FROM SocialMediaEvents s WHERE s.timeTo = :timeTo")
    , @NamedQuery(name = "SocialMediaEvents.findByIsActive", query = "SELECT s FROM SocialMediaEvents s WHERE s.isActive = :isActive")})
public class SocialMediaEvents implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "name")
    private String name;
    @Column(name = "publish_time")
    @Temporal(TemporalType.TIME)
    private Date publishTime;
    @Column(name = "publish_date")
    @Temporal(TemporalType.DATE)
    private Date publishDate;
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    @Column(name = "date_from")
    @Temporal(TemporalType.DATE)
    private Date dateFrom;
    @Column(name = "date_to")
    @Temporal(TemporalType.DATE)
    private Date dateTo;
    @Column(name = "time_from")
    @Temporal(TemporalType.TIME)
    private Date timeFrom;
    @Column(name = "time_to")
    @Temporal(TemporalType.TIME)
    private Date timeTo;
    @Column(name = "is_active")
    private Boolean isActive;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "socialMediaEventsId")
    private Collection<EventParticipateController> eventParticipateControllerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "socialMediaEventsId")
    private Collection<SocialMediaEventsController> socialMediaEventsControllerCollection;
    @JoinColumn(name = "event_entry_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private EventEntranceType eventEntryTypeId;
    @JoinColumn(name = "location", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralOrganizationProfile location;
    @JoinColumn(name = "social_media_group_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SocialMediaGroup socialMediaGroupId;
    @JoinColumn(name = "social_media_profile_page_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SocialMediaProfilePage socialMediaProfilePageId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "socialMediaEventsId")
    private Collection<EventTickets> eventTicketsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "socialMediaEventsId")
    private Collection<SocialMediaEventReactionController> socialMediaEventReactionControllerCollection;

    public SocialMediaEvents() {
    }

    public SocialMediaEvents(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Date getTimeFrom() {
        return timeFrom;
    }

    public void setTimeFrom(Date timeFrom) {
        this.timeFrom = timeFrom;
    }

    public Date getTimeTo() {
        return timeTo;
    }

    public void setTimeTo(Date timeTo) {
        this.timeTo = timeTo;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    @XmlTransient
    public Collection<EventParticipateController> getEventParticipateControllerCollection() {
        return eventParticipateControllerCollection;
    }

    public void setEventParticipateControllerCollection(Collection<EventParticipateController> eventParticipateControllerCollection) {
        this.eventParticipateControllerCollection = eventParticipateControllerCollection;
    }

    @XmlTransient
    public Collection<SocialMediaEventsController> getSocialMediaEventsControllerCollection() {
        return socialMediaEventsControllerCollection;
    }

    public void setSocialMediaEventsControllerCollection(Collection<SocialMediaEventsController> socialMediaEventsControllerCollection) {
        this.socialMediaEventsControllerCollection = socialMediaEventsControllerCollection;
    }

    public EventEntranceType getEventEntryTypeId() {
        return eventEntryTypeId;
    }

    public void setEventEntryTypeId(EventEntranceType eventEntryTypeId) {
        this.eventEntryTypeId = eventEntryTypeId;
    }

    public GeneralOrganizationProfile getLocation() {
        return location;
    }

    public void setLocation(GeneralOrganizationProfile location) {
        this.location = location;
    }

    public SocialMediaGroup getSocialMediaGroupId() {
        return socialMediaGroupId;
    }

    public void setSocialMediaGroupId(SocialMediaGroup socialMediaGroupId) {
        this.socialMediaGroupId = socialMediaGroupId;
    }

    public SocialMediaProfilePage getSocialMediaProfilePageId() {
        return socialMediaProfilePageId;
    }

    public void setSocialMediaProfilePageId(SocialMediaProfilePage socialMediaProfilePageId) {
        this.socialMediaProfilePageId = socialMediaProfilePageId;
    }

    @XmlTransient
    public Collection<EventTickets> getEventTicketsCollection() {
        return eventTicketsCollection;
    }

    public void setEventTicketsCollection(Collection<EventTickets> eventTicketsCollection) {
        this.eventTicketsCollection = eventTicketsCollection;
    }

    @XmlTransient
    public Collection<SocialMediaEventReactionController> getSocialMediaEventReactionControllerCollection() {
        return socialMediaEventReactionControllerCollection;
    }

    public void setSocialMediaEventReactionControllerCollection(Collection<SocialMediaEventReactionController> socialMediaEventReactionControllerCollection) {
        this.socialMediaEventReactionControllerCollection = socialMediaEventReactionControllerCollection;
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
        if (!(object instanceof SocialMediaEvents)) {
            return false;
        }
        SocialMediaEvents other = (SocialMediaEvents) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.SocialMediaEvents[ id=" + id + " ]";
    }
    
}
