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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "d_message")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DMessage.findAll", query = "SELECT d FROM DMessage d"),
    @NamedQuery(name = "DMessage.findByMessageId", query = "SELECT d FROM DMessage d WHERE d.messageId = :messageId"),
    @NamedQuery(name = "DMessage.findByMessageTitleFrFr", query = "SELECT d FROM DMessage d WHERE d.messageTitleFrFr = :messageTitleFrFr"),
    @NamedQuery(name = "DMessage.findByMessageContentFrFr", query = "SELECT d FROM DMessage d WHERE d.messageContentFrFr = :messageContentFrFr"),
    @NamedQuery(name = "DMessage.findByMessageNbLike", query = "SELECT d FROM DMessage d WHERE d.messageNbLike = :messageNbLike"),
    @NamedQuery(name = "DMessage.findByMessageNbUnlike", query = "SELECT d FROM DMessage d WHERE d.messageNbUnlike = :messageNbUnlike"),
    @NamedQuery(name = "DMessage.findByMessageNbView", query = "SELECT d FROM DMessage d WHERE d.messageNbView = :messageNbView"),
    @NamedQuery(name = "DMessage.findByMessageNbReport", query = "SELECT d FROM DMessage d WHERE d.messageNbReport = :messageNbReport"),
    @NamedQuery(name = "DMessage.findByMessageStatusFrFr", query = "SELECT d FROM DMessage d WHERE d.messageStatusFrFr = :messageStatusFrFr"),
    @NamedQuery(name = "DMessage.findByMessageDate", query = "SELECT d FROM DMessage d WHERE d.messageDate = :messageDate")})
public class DMessage implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "message_id")
    private Integer messageId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "message_title_fr_fr")
    private String messageTitleFrFr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "message_content_fr_fr")
    private String messageContentFrFr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "message_nb_like")
    private int messageNbLike;
    @Basic(optional = false)
    @NotNull
    @Column(name = "message_nb_unlike")
    private int messageNbUnlike;
    @Basic(optional = false)
    @NotNull
    @Column(name = "message_nb_view")
    private int messageNbView;
    @Basic(optional = false)
    @NotNull
    @Column(name = "message_nb_report")
    private int messageNbReport;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "message_status_fr_fr")
    private String messageStatusFrFr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "message_date")
    @Temporal(TemporalType.DATE)
    private Date messageDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "commentMessageIdFk")
    private Collection<DComment> dCommentCollection;
    @JoinColumn(name = "message_id_categorie_fk", referencedColumnName = "category_id")
    @ManyToOne(optional = false)
    private DCategory messageIdCategorieFk;
    @JoinColumn(name = "message_id_user_fk", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private DUser messageIdUserFk;
    @JoinColumn(name = "message_id_point_fk", referencedColumnName = "point_id")
    @ManyToOne(optional = false)
    private DPoint messageIdPointFk;

    public DMessage() {
    }

    public DMessage(Integer messageId) {
        this.messageId = messageId;
    }

    public DMessage(Integer messageId, String messageTitleFrFr, String messageContentFrFr, int messageNbLike, int messageNbUnlike, int messageNbView, int messageNbReport, String messageStatusFrFr, Date messageDate) {
        this.messageId = messageId;
        this.messageTitleFrFr = messageTitleFrFr;
        this.messageContentFrFr = messageContentFrFr;
        this.messageNbLike = messageNbLike;
        this.messageNbUnlike = messageNbUnlike;
        this.messageNbView = messageNbView;
        this.messageNbReport = messageNbReport;
        this.messageStatusFrFr = messageStatusFrFr;
        this.messageDate = messageDate;
    }

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public String getMessageTitleFrFr() {
        return messageTitleFrFr;
    }

    public void setMessageTitleFrFr(String messageTitleFrFr) {
        this.messageTitleFrFr = messageTitleFrFr;
    }

    public String getMessageContentFrFr() {
        return messageContentFrFr;
    }

    public void setMessageContentFrFr(String messageContentFrFr) {
        this.messageContentFrFr = messageContentFrFr;
    }

    public int getMessageNbLike() {
        return messageNbLike;
    }

    public void setMessageNbLike(int messageNbLike) {
        this.messageNbLike = messageNbLike;
    }

    public int getMessageNbUnlike() {
        return messageNbUnlike;
    }

    public void setMessageNbUnlike(int messageNbUnlike) {
        this.messageNbUnlike = messageNbUnlike;
    }

    public int getMessageNbView() {
        return messageNbView;
    }

    public void setMessageNbView(int messageNbView) {
        this.messageNbView = messageNbView;
    }

    public int getMessageNbReport() {
        return messageNbReport;
    }

    public void setMessageNbReport(int messageNbReport) {
        this.messageNbReport = messageNbReport;
    }

    public String getMessageStatusFrFr() {
        return messageStatusFrFr;
    }

    public void setMessageStatusFrFr(String messageStatusFrFr) {
        this.messageStatusFrFr = messageStatusFrFr;
    }

    public Date getMessageDate() {
        return messageDate;
    }

    public void setMessageDate(Date messageDate) {
        this.messageDate = messageDate;
    }

    @XmlTransient
    public Collection<DComment> getDCommentCollection() {
        return dCommentCollection;
    }

    public void setDCommentCollection(Collection<DComment> dCommentCollection) {
        this.dCommentCollection = dCommentCollection;
    }

    public DCategory getMessageIdCategorieFk() {
        return messageIdCategorieFk;
    }

    public void setMessageIdCategorieFk(DCategory messageIdCategorieFk) {
        this.messageIdCategorieFk = messageIdCategorieFk;
    }

    public DUser getMessageIdUserFk() {
        return messageIdUserFk;
    }

    public void setMessageIdUserFk(DUser messageIdUserFk) {
        this.messageIdUserFk = messageIdUserFk;
    }

    public DPoint getMessageIdPointFk() {
        return messageIdPointFk;
    }

    public void setMessageIdPointFk(DPoint messageIdPointFk) {
        this.messageIdPointFk = messageIdPointFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (messageId != null ? messageId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DMessage)) {
            return false;
        }
        DMessage other = (DMessage) object;
        if ((this.messageId == null && other.messageId != null) || (this.messageId != null && !this.messageId.equals(other.messageId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ws.model.DMessage[ messageId=" + messageId + " ]";
    }
    
}
