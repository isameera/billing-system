/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb.model.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "file_uploading_form")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FileUploadingForm.findAll", query = "SELECT f FROM FileUploadingForm f")
    , @NamedQuery(name = "FileUploadingForm.findById", query = "SELECT f FROM FileUploadingForm f WHERE f.id = :id")
    , @NamedQuery(name = "FileUploadingForm.findByName", query = "SELECT f FROM FileUploadingForm f WHERE f.name = :name")})
public class FileUploadingForm implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fileUploadingFormId")
    private Collection<UploadedFileManager> uploadedFileManagerCollection;

    public FileUploadingForm() {
    }

    public FileUploadingForm(Integer id) {
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

    @XmlTransient
    public Collection<UploadedFileManager> getUploadedFileManagerCollection() {
        return uploadedFileManagerCollection;
    }

    public void setUploadedFileManagerCollection(Collection<UploadedFileManager> uploadedFileManagerCollection) {
        this.uploadedFileManagerCollection = uploadedFileManagerCollection;
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
        if (!(object instanceof FileUploadingForm)) {
            return false;
        }
        FileUploadingForm other = (FileUploadingForm) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.FileUploadingForm[ id=" + id + " ]";
    }
    
}
