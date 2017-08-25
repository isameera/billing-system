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
import javax.persistence.Lob;
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
@Table(name = "gui_componant")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GuiComponant.findAll", query = "SELECT g FROM GuiComponant g")
    , @NamedQuery(name = "GuiComponant.findById", query = "SELECT g FROM GuiComponant g WHERE g.id = :id")
    , @NamedQuery(name = "GuiComponant.findByName", query = "SELECT g FROM GuiComponant g WHERE g.name = :name")})
public class GuiComponant implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 145)
    @Column(name = "name")
    private String name;
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "guiComponantId")
    private Collection<GuiProperties> guiPropertiesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "guiComponantId")
    private Collection<GuiComponantExample> guiComponantExampleCollection;

    public GuiComponant() {
    }

    public GuiComponant(Integer id) {
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

    @XmlTransient
    public Collection<GuiProperties> getGuiPropertiesCollection() {
        return guiPropertiesCollection;
    }

    public void setGuiPropertiesCollection(Collection<GuiProperties> guiPropertiesCollection) {
        this.guiPropertiesCollection = guiPropertiesCollection;
    }

    @XmlTransient
    public Collection<GuiComponantExample> getGuiComponantExampleCollection() {
        return guiComponantExampleCollection;
    }

    public void setGuiComponantExampleCollection(Collection<GuiComponantExample> guiComponantExampleCollection) {
        this.guiComponantExampleCollection = guiComponantExampleCollection;
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
        if (!(object instanceof GuiComponant)) {
            return false;
        }
        GuiComponant other = (GuiComponant) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.GuiComponant[ id=" + id + " ]";
    }
    
}
