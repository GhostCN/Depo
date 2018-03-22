/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

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
 * @author Ghost CN
 */
@Entity
@Table(name = "consultation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Consultation.findAll", query = "SELECT c FROM Consultation c"),
    @NamedQuery(name = "Consultation.findById", query = "SELECT c FROM Consultation c WHERE c.id = :id"),
    @NamedQuery(name = "Consultation.findByPrescription", query = "SELECT c FROM Consultation c WHERE c.prescription = :prescription"),
    @NamedQuery(name = "Consultation.findByCommentaire", query = "SELECT c FROM Consultation c WHERE c.commentaire = :commentaire")})
public class Consultation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "prescription")
    private String prescription;
    @Basic(optional = false)
    @Column(name = "commentaire")
    private String commentaire;
    @JoinColumn(name = "utilisateur", referencedColumnName = "numUser")
    @ManyToOne(optional = false)
    private Utilisateur utilisateur;
    @JoinColumn(name = "dossier", referencedColumnName = "numD")
    @ManyToOne(optional = false)
    private Dossier dossier;

    public Consultation() {
    }

    public Consultation(Integer id) {
        this.id = id;
    }

    public Consultation(Integer id, String prescription, String commentaire) {
        this.id = id;
        this.prescription = prescription;
        this.commentaire = commentaire;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Dossier getDossier() {
        return dossier;
    }

    public void setDossier(Dossier dossier) {
        this.dossier = dossier;
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
        if (!(object instanceof Consultation)) {
            return false;
        }
        Consultation other = (Consultation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Consultation[ id=" + id + " ]";
    }
    
}
