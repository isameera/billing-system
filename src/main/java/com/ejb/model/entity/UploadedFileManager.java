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
@Table(name = "uploaded_file_manager")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UploadedFileManager.findAll", query = "SELECT u FROM UploadedFileManager u")
    , @NamedQuery(name = "UploadedFileManager.findById", query = "SELECT u FROM UploadedFileManager u WHERE u.id = :id")})
public class UploadedFileManager implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "general_organization_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralOrganizationProfile generalOrganizationProfileId;
    @JoinColumn(name = "file_uploading_form_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private FileUploadingForm fileUploadingFormId;
    @JoinColumn(name = "file_uploading_sub_form_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private FileUploadingSubForm fileUploadingSubFormId;
    @JoinColumn(name = "uploaded_files_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UploadedFiles uploadedFilesId;

    public UploadedFileManager() {
    }

    public UploadedFileManager(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public GeneralOrganizationProfile getGeneralOrganizationProfileId() {
        return generalOrganizationProfileId;
    }

    public void setGeneralOrganizationProfileId(GeneralOrganizationProfile generalOrganizationProfileId) {
        this.generalOrganizationProfileId = generalOrganizationProfileId;
    }

    public FileUploadingForm getFileUploadingFormId() {
        return fileUploadingFormId;
    }

    public void setFileUploadingFormId(FileUploadingForm fileUploadingFormId) {
        this.fileUploadingFormId = fileUploadingFormId;
    }

    public FileUploadingSubForm getFileUploadingSubFormId() {
        return fileUploadingSubFormId;
    }

    public void setFileUploadingSubFormId(FileUploadingSubForm fileUploadingSubFormId) {
        this.fileUploadingSubFormId = fileUploadingSubFormId;
    }

    public UploadedFiles getUploadedFilesId() {
        return uploadedFilesId;
    }

    public void setUploadedFilesId(UploadedFiles uploadedFilesId) {
        this.uploadedFilesId = uploadedFilesId;
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
        if (!(object instanceof UploadedFileManager)) {
            return false;
        }
        UploadedFileManager other = (UploadedFileManager) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.UploadedFileManager[ id=" + id + " ]";
    }
    
}
