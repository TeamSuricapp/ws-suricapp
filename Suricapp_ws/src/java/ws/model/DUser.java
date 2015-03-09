/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.model;

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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Morgan
 */
@Entity
@Table(name = "d_user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DUser.findAll", query = "SELECT d FROM DUser d"),
    @NamedQuery(name = "DUser.findByUserId", query = "SELECT d FROM DUser d WHERE d.userId = :userId"),
    @NamedQuery(name = "DUser.findByUserPseudo", query = "SELECT d FROM DUser d WHERE d.userPseudo = :userPseudo"),
    @NamedQuery(name = "DUser.findByUserPassword", query = "SELECT d FROM DUser d WHERE d.userPassword = :userPassword"),
    @NamedQuery(name = "DUser.findByUserName", query = "SELECT d FROM DUser d WHERE d.userName = :userName"),
    @NamedQuery(name = "DUser.findByUserFirstName", query = "SELECT d FROM DUser d WHERE d.userFirstName = :userFirstName"),
    @NamedQuery(name = "DUser.findByUserDateCreation", query = "SELECT d FROM DUser d WHERE d.userDateCreation = :userDateCreation"),
    @NamedQuery(name = "DUser.findByUserBirthday", query = "SELECT d FROM DUser d WHERE d.userBirthday = :userBirthday"),
    @NamedQuery(name = "DUser.findByUserSituationFrFr", query = "SELECT d FROM DUser d WHERE d.userSituationFrFr = :userSituationFrFr"),
    @NamedQuery(name = "DUser.findByUserCity", query = "SELECT d FROM DUser d WHERE d.userCity = :userCity"),
    @NamedQuery(name = "DUser.findByUserPicture", query = "SELECT d FROM DUser d WHERE d.userPicture = :userPicture"),
    @NamedQuery(name = "DUser.findByUserPhone", query = "SELECT d FROM DUser d WHERE d.userPhone = :userPhone"),
    @NamedQuery(name = "DUser.findByUserEmail", query = "SELECT d FROM DUser d WHERE d.userEmail = :userEmail"),
    @NamedQuery(name = "DUser.findByUserIsPremium", query = "SELECT d FROM DUser d WHERE d.userIsPremium = :userIsPremium")})
public class DUser implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "user_id")
    private Integer userId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "user_pseudo")
    private String userPseudo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "user_password")
    private String userPassword;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "user_name")
    private String userName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "user_first_name")
    private String userFirstName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "user_date_creation")
    @Temporal(TemporalType.DATE)
    private Date userDateCreation;
    @Column(name = "user_birthday")
    @Temporal(TemporalType.DATE)
    private Date userBirthday;
    @Size(max = 60)
    @Column(name = "user_situation_fr_fr")
    private String userSituationFrFr;
    @Size(max = 60)
    @Column(name = "user_city")
    private String userCity;
    @Size(max = 60)
    @Column(name = "user_picture")
    private String userPicture;
    @Size(max = 20)
    @Column(name = "user_phone")
    private String userPhone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "user_email")
    private String userEmail;
    @Basic(optional = false)
    @NotNull
    @Column(name = "user_is_premium")
    private boolean userIsPremium;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "commentUserIdFk")
    private Collection<DComment> dCommentCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "messageIdUserFk")
    private Collection<DMessage> dMessageCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "followersIdUserFk")
    private Collection<DFollower> dFollowerCollection;

    public DUser() {
    }

    public DUser(Integer userId) {
        this.userId = userId;
    }

    public DUser(Integer userId, String userPseudo, String userPassword, String userName, String userFirstName, Date userDateCreation, String userEmail, boolean userIsPremium) {
        this.userId = userId;
        this.userPseudo = userPseudo;
        this.userPassword = userPassword;
        this.userName = userName;
        this.userFirstName = userFirstName;
        this.userDateCreation = userDateCreation;
        this.userEmail = userEmail;
        this.userIsPremium = userIsPremium;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserPseudo() {
        return userPseudo;
    }

    public void setUserPseudo(String userPseudo) {
        this.userPseudo = userPseudo;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public Date getUserDateCreation() {
        return userDateCreation;
    }

    public void setUserDateCreation(Date userDateCreation) {
        this.userDateCreation = userDateCreation;
    }

    public Date getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }

    public String getUserSituationFrFr() {
        return userSituationFrFr;
    }

    public void setUserSituationFrFr(String userSituationFrFr) {
        this.userSituationFrFr = userSituationFrFr;
    }

    public String getUserCity() {
        return userCity;
    }

    public void setUserCity(String userCity) {
        this.userCity = userCity;
    }

    public String getUserPicture() {
        return userPicture;
    }

    public void setUserPicture(String userPicture) {
        this.userPicture = userPicture;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public boolean getUserIsPremium() {
        return userIsPremium;
    }

    public void setUserIsPremium(boolean userIsPremium) {
        this.userIsPremium = userIsPremium;
    }

    @XmlTransient
    public Collection<DComment> getDCommentCollection() {
        return dCommentCollection;
    }

    public void setDCommentCollection(Collection<DComment> dCommentCollection) {
        this.dCommentCollection = dCommentCollection;
    }

    @XmlTransient
    public Collection<DMessage> getDMessageCollection() {
        return dMessageCollection;
    }

    public void setDMessageCollection(Collection<DMessage> dMessageCollection) {
        this.dMessageCollection = dMessageCollection;
    }

    @XmlTransient
    public Collection<DFollower> getDFollowerCollection() {
        return dFollowerCollection;
    }

    public void setDFollowerCollection(Collection<DFollower> dFollowerCollection) {
        this.dFollowerCollection = dFollowerCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DUser)) {
            return false;
        }
        DUser other = (DUser) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ws.model.DUser[ userId=" + userId + " ]";
    }
    
}
