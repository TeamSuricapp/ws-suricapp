/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Morgan
 */
@Entity
@Table(name = "d_follower")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DFollower.findAll", query = "SELECT d FROM DFollower d"),
    @NamedQuery(name = "DFollower.findByFollowersIdFollowers", query = "SELECT d FROM DFollower d WHERE d.followersIdFollowers = :followersIdFollowers")})
public class DFollower implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "followers_id_followers")
    private Integer followersIdFollowers;
    @JoinColumn(name = "followers_id_user_fk", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private DUser followersIdUserFk;

    public DFollower() {
    }

    public DFollower(Integer followersIdFollowers) {
        this.followersIdFollowers = followersIdFollowers;
    }

    public Integer getFollowersIdFollowers() {
        return followersIdFollowers;
    }

    public void setFollowersIdFollowers(Integer followersIdFollowers) {
        this.followersIdFollowers = followersIdFollowers;
    }

    public DUser getFollowersIdUserFk() {
        return followersIdUserFk;
    }

    public void setFollowersIdUserFk(DUser followersIdUserFk) {
        this.followersIdUserFk = followersIdUserFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (followersIdFollowers != null ? followersIdFollowers.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DFollower)) {
            return false;
        }
        DFollower other = (DFollower) object;
        if ((this.followersIdFollowers == null && other.followersIdFollowers != null) || (this.followersIdFollowers != null && !this.followersIdFollowers.equals(other.followersIdFollowers))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ws.model.DFollower[ followersIdFollowers=" + followersIdFollowers + " ]";
    }
    
}
