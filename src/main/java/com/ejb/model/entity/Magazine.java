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
@Table(name = "magazine")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Magazine.findAll", query = "SELECT m FROM Magazine m")
    , @NamedQuery(name = "Magazine.findById", query = "SELECT m FROM Magazine m WHERE m.id = :id")
    , @NamedQuery(name = "Magazine.findByName", query = "SELECT m FROM Magazine m WHERE m.name = :name")
    , @NamedQuery(name = "Magazine.findByStartDate", query = "SELECT m FROM Magazine m WHERE m.startDate = :startDate")})
public class Magazine implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 105)
    @Column(name = "name")
    private String name;
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "magazineId")
    private Collection<VoucherMagazine> voucherMagazineCollection;
    @JoinColumn(name = "general_organization_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralOrganizationProfile generalOrganizationProfileId;
    @JoinColumn(name = "magazine_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private MagazineType magazineTypeId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "magazineId")
    private Collection<MagazeneSubscriber> magazeneSubscriberCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "magazineId")
    private Collection<Episode> episodeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "magazineId")
    private Collection<Story> storyCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "magazineId")
    private Collection<StoryReader> storyReaderCollection;

    public Magazine() {
    }

    public Magazine(Integer id) {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @XmlTransient
    public Collection<VoucherMagazine> getVoucherMagazineCollection() {
        return voucherMagazineCollection;
    }

    public void setVoucherMagazineCollection(Collection<VoucherMagazine> voucherMagazineCollection) {
        this.voucherMagazineCollection = voucherMagazineCollection;
    }

    public GeneralOrganizationProfile getGeneralOrganizationProfileId() {
        return generalOrganizationProfileId;
    }

    public void setGeneralOrganizationProfileId(GeneralOrganizationProfile generalOrganizationProfileId) {
        this.generalOrganizationProfileId = generalOrganizationProfileId;
    }

    public MagazineType getMagazineTypeId() {
        return magazineTypeId;
    }

    public void setMagazineTypeId(MagazineType magazineTypeId) {
        this.magazineTypeId = magazineTypeId;
    }

    @XmlTransient
    public Collection<MagazeneSubscriber> getMagazeneSubscriberCollection() {
        return magazeneSubscriberCollection;
    }

    public void setMagazeneSubscriberCollection(Collection<MagazeneSubscriber> magazeneSubscriberCollection) {
        this.magazeneSubscriberCollection = magazeneSubscriberCollection;
    }

    @XmlTransient
    public Collection<Episode> getEpisodeCollection() {
        return episodeCollection;
    }

    public void setEpisodeCollection(Collection<Episode> episodeCollection) {
        this.episodeCollection = episodeCollection;
    }

    @XmlTransient
    public Collection<Story> getStoryCollection() {
        return storyCollection;
    }

    public void setStoryCollection(Collection<Story> storyCollection) {
        this.storyCollection = storyCollection;
    }

    @XmlTransient
    public Collection<StoryReader> getStoryReaderCollection() {
        return storyReaderCollection;
    }

    public void setStoryReaderCollection(Collection<StoryReader> storyReaderCollection) {
        this.storyReaderCollection = storyReaderCollection;
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
        if (!(object instanceof Magazine)) {
            return false;
        }
        Magazine other = (Magazine) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.Magazine[ id=" + id + " ]";
    }
    
}
