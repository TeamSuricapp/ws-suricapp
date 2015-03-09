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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Morgan
 */
@Entity
@Table(name = "d_point")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DPoint.findAll", query = "SELECT d FROM DPoint d"),
    @NamedQuery(name = "DPoint.findByPointId", query = "SELECT d FROM DPoint d WHERE d.pointId = :pointId"),
    @NamedQuery(name = "DPoint.findByPointLatitude", query = "SELECT d FROM DPoint d WHERE d.pointLatitude = :pointLatitude"),
    @NamedQuery(name = "DPoint.findByPointLongitude", query = "SELECT d FROM DPoint d WHERE d.pointLongitude = :pointLongitude")})
public class DPoint implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "point_id")
    private Integer pointId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "point_latitude")
    private double pointLatitude;
    @Basic(optional = false)
    @NotNull
    @Column(name = "point_longitude")
    private double pointLongitude;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "messageIdPointFk")
    private Collection<DMessage> dMessageCollection;

    public DPoint() {
    }

    public DPoint(Integer pointId) {
        this.pointId = pointId;
    }

    public DPoint(Integer pointId, double pointLatitude, double pointLongitude) {
        this.pointId = pointId;
        this.pointLatitude = pointLatitude;
        this.pointLongitude = pointLongitude;
    }

    public Integer getPointId() {
        return pointId;
    }

    public void setPointId(Integer pointId) {
        this.pointId = pointId;
    }

    public double getPointLatitude() {
        return pointLatitude;
    }

    public void setPointLatitude(double pointLatitude) {
        this.pointLatitude = pointLatitude;
    }

    public double getPointLongitude() {
        return pointLongitude;
    }

    public void setPointLongitude(double pointLongitude) {
        this.pointLongitude = pointLongitude;
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
        hash += (pointId != null ? pointId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DPoint)) {
            return false;
        }
        DPoint other = (DPoint) object;
        if ((this.pointId == null && other.pointId != null) || (this.pointId != null && !this.pointId.equals(other.pointId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ws.model.DPoint[ pointId=" + pointId + " ]";
    }
    
}
