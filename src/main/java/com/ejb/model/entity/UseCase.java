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
@Table(name = "use_case")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UseCase.findAll", query = "SELECT u FROM UseCase u")
    , @NamedQuery(name = "UseCase.findById", query = "SELECT u FROM UseCase u WHERE u.id = :id")
    , @NamedQuery(name = "UseCase.findByCaseName", query = "SELECT u FROM UseCase u WHERE u.caseName = :caseName")})
public class UseCase implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "case_name")
    private String caseName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "useCaseId")
    private Collection<UseCaseHasSystemInterface> useCaseHasSystemInterfaceCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "useCaseId")
    private Collection<UseCaseHasUserRole> useCaseHasUserRoleCollection;

    public UseCase() {
    }

    public UseCase(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCaseName() {
        return caseName;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    @XmlTransient
    public Collection<UseCaseHasSystemInterface> getUseCaseHasSystemInterfaceCollection() {
        return useCaseHasSystemInterfaceCollection;
    }

    public void setUseCaseHasSystemInterfaceCollection(Collection<UseCaseHasSystemInterface> useCaseHasSystemInterfaceCollection) {
        this.useCaseHasSystemInterfaceCollection = useCaseHasSystemInterfaceCollection;
    }

    @XmlTransient
    public Collection<UseCaseHasUserRole> getUseCaseHasUserRoleCollection() {
        return useCaseHasUserRoleCollection;
    }

    public void setUseCaseHasUserRoleCollection(Collection<UseCaseHasUserRole> useCaseHasUserRoleCollection) {
        this.useCaseHasUserRoleCollection = useCaseHasUserRoleCollection;
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
        if (!(object instanceof UseCase)) {
            return false;
        }
        UseCase other = (UseCase) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.UseCase[ id=" + id + " ]";
    }
    
}
