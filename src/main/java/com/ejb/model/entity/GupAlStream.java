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
@Table(name = "gup_al_stream")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GupAlStream.findAll", query = "SELECT g FROM GupAlStream g")
    , @NamedQuery(name = "GupAlStream.findById", query = "SELECT g FROM GupAlStream g WHERE g.id = :id")
    , @NamedQuery(name = "GupAlStream.findByIsAlDone", query = "SELECT g FROM GupAlStream g WHERE g.isAlDone = :isAlDone")})
public class GupAlStream implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "is_al_done")
    private Boolean isAlDone;
    @JoinColumn(name = "al_stream_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private AlStream alStreamId;
    @JoinColumn(name = "al_year_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private AlYear alYearId;
    @JoinColumn(name = "edu_class_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private EduClass eduClassId;
    @JoinColumn(name = "general_user_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralUserProfile generalUserProfileId;

    public GupAlStream() {
    }

    public GupAlStream(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getIsAlDone() {
        return isAlDone;
    }

    public void setIsAlDone(Boolean isAlDone) {
        this.isAlDone = isAlDone;
    }

    public AlStream getAlStreamId() {
        return alStreamId;
    }

    public void setAlStreamId(AlStream alStreamId) {
        this.alStreamId = alStreamId;
    }

    public AlYear getAlYearId() {
        return alYearId;
    }

    public void setAlYearId(AlYear alYearId) {
        this.alYearId = alYearId;
    }

    public EduClass getEduClassId() {
        return eduClassId;
    }

    public void setEduClassId(EduClass eduClassId) {
        this.eduClassId = eduClassId;
    }

    public GeneralUserProfile getGeneralUserProfileId() {
        return generalUserProfileId;
    }

    public void setGeneralUserProfileId(GeneralUserProfile generalUserProfileId) {
        this.generalUserProfileId = generalUserProfileId;
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
        if (!(object instanceof GupAlStream)) {
            return false;
        }
        GupAlStream other = (GupAlStream) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.GupAlStream[ id=" + id + " ]";
    }
    
}
