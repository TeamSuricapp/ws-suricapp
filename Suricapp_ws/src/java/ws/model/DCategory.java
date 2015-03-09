/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Morgan
 */
@Entity
@Table(name = "d_category")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DCategory.findAll", query = "SELECT d FROM DCategory d"),
    @NamedQuery(name = "DCategory.findByCategoryId", query = "SELECT d FROM DCategory d WHERE d.categoryId = :categoryId"),
    @NamedQuery(name = "DCategory.findByCategoryLabel", query = "SELECT d FROM DCategory d WHERE d.categoryLabel = :categoryLabel")})
public class DCategory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "category_id")
    private Integer categoryId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "category_label")
    private String categoryLabel;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "category_description_fr_fr")
    private String categoryDescriptionFrFr;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "messageIdCategorieFk")
    private Collection<DMessage> dMessageCollection;

    public DCategory() {
    }

    public DCategory(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public DCategory(Integer categoryId, String categoryLabel, String categoryDescriptionFrFr) {
        this.categoryId = categoryId;
        this.categoryLabel = categoryLabel;
        this.categoryDescriptionFrFr = categoryDescriptionFrFr;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryLabel() {
        return categoryLabel;
    }

    public void setCategoryLabel(String categoryLabel) {
        this.categoryLabel = categoryLabel;
    }

    public String getCategoryDescriptionFrFr() {
        return categoryDescriptionFrFr;
    }

    public void setCategoryDescriptionFrFr(String categoryDescriptionFrFr) {
        this.categoryDescriptionFrFr = categoryDescriptionFrFr;
    }

    @XmlTransient
    public Collection<DMessage> getDMessageCollection() {
        return dMessageCollection;
    }

    public void setDMessageCollection(Collection<DMessage> dMessageCollection) {
        this.dMessageCollection = dMessageCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (categoryId != null ? categoryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DCategory)) {
            return false;
        }
        DCategory other = (DCategory) object;
        if ((this.categoryId == null && other.categoryId != null) || (this.categoryId != null && !this.categoryId.equals(other.categoryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ws.model.DCategory[ categoryId=" + categoryId + " ]";
    }
    
}
