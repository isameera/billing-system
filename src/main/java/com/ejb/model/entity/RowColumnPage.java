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
@Table(name = "row_column_page")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RowColumnPage.findAll", query = "SELECT r FROM RowColumnPage r")
    , @NamedQuery(name = "RowColumnPage.findById", query = "SELECT r FROM RowColumnPage r WHERE r.id = :id")
    , @NamedQuery(name = "RowColumnPage.findByNoOfRows", query = "SELECT r FROM RowColumnPage r WHERE r.noOfRows = :noOfRows")
    , @NamedQuery(name = "RowColumnPage.findByNoOfColumns", query = "SELECT r FROM RowColumnPage r WHERE r.noOfColumns = :noOfColumns")})
public class RowColumnPage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "no_of_rows")
    private Integer noOfRows;
    @Column(name = "no_of_columns")
    private Integer noOfColumns;
    @JoinColumn(name = "column_from", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Columns columnFrom;
    @JoinColumn(name = "page_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Page pageId;
    @JoinColumn(name = "column_to", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Columns columnTo;
    @JoinColumn(name = "post_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Post postId;

    public RowColumnPage() {
    }

    public RowColumnPage(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNoOfRows() {
        return noOfRows;
    }

    public void setNoOfRows(Integer noOfRows) {
        this.noOfRows = noOfRows;
    }

    public Integer getNoOfColumns() {
        return noOfColumns;
    }

    public void setNoOfColumns(Integer noOfColumns) {
        this.noOfColumns = noOfColumns;
    }

    public Columns getColumnFrom() {
        return columnFrom;
    }

    public void setColumnFrom(Columns columnFrom) {
        this.columnFrom = columnFrom;
    }

    public Page getPageId() {
        return pageId;
    }

    public void setPageId(Page pageId) {
        this.pageId = pageId;
    }

    public Columns getColumnTo() {
        return columnTo;
    }

    public void setColumnTo(Columns columnTo) {
        this.columnTo = columnTo;
    }

    public Post getPostId() {
        return postId;
    }

    public void setPostId(Post postId) {
        this.postId = postId;
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
        if (!(object instanceof RowColumnPage)) {
            return false;
        }
        RowColumnPage other = (RowColumnPage) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.RowColumnPage[ id=" + id + " ]";
    }
    
}
