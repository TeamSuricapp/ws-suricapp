/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Morgan
 */
@Entity
@Table(name = "d_comment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DComment.findAll", query = "SELECT d FROM DComment d"),
    @NamedQuery(name = "DComment.findByCommentId", query = "SELECT d FROM DComment d WHERE d.commentId = :commentId"),
    @NamedQuery(name = "DComment.findByCommentDate", query = "SELECT d FROM DComment d WHERE d.commentDate = :commentDate")})
public class DComment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "comment_id")
    private Integer commentId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "comment_date")
    @Temporal(TemporalType.DATE)
    private Date commentDate;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "comment_content_fr_fr")
    private String commentContentFrFr;
    @JoinColumn(name = "comment_message_id_fk", referencedColumnName = "message_id")
    @ManyToOne(optional = false)
    private DMessage commentMessageIdFk;
    @JoinColumn(name = "comment_user_id_fk", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private DUser commentUserIdFk;

    public DComment() {
    }

    public DComment(Integer commentId) {
        this.commentId = commentId;
    }

    public DComment(Integer commentId, Date commentDate, String commentContentFrFr) {
        this.commentId = commentId;
        this.commentDate = commentDate;
        this.commentContentFrFr = commentContentFrFr;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    public String getCommentContentFrFr() {
        return commentContentFrFr;
    }

    public void setCommentContentFrFr(String commentContentFrFr) {
        this.commentContentFrFr = commentContentFrFr;
    }

    public DMessage getCommentMessageIdFk() {
        return commentMessageIdFk;
    }

    public void setCommentMessageIdFk(DMessage commentMessageIdFk) {
        this.commentMessageIdFk = commentMessageIdFk;
    }

    public DUser getCommentUserIdFk() {
        return commentUserIdFk;
    }

    public void setCommentUserIdFk(DUser commentUserIdFk) {
        this.commentUserIdFk = commentUserIdFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (commentId != null ? commentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DComment)) {
            return false;
        }
        DComment other = (DComment) object;
        if ((this.commentId == null && other.commentId != null) || (this.commentId != null && !this.commentId.equals(other.commentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ws.model.DComment[ commentId=" + commentId + " ]";
    }
    
}
