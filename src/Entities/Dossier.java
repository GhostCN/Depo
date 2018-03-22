/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.List;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ghost CN
 */
@Entity
@Table(name = "dossier")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dossier.findAll", query = "SELECT d FROM Dossier d"),
    @NamedQuery(name = "Dossier.findById", query = "SELECT d FROM Dossier d WHERE d.id = :id"),
    @NamedQuery(name = "Dossier.findByNumD", query = "SELECT d FROM Dossier d WHERE d.numD = :numD")})
public class Dossier implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "numD")
    private String numD;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dossier")
    private List<Document> documentList;
    @JoinColumn(name = "user", referencedColumnName = "numUser")
    @ManyToOne(optional = false)
    private Utilisateur user;
    @JoinColumn(name = "patient", referencedColumnName = "numP")
    @ManyToOne(optional = false)
    private Patient patient;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dossier")
    private List<Consultation> consultationList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dossier")
    private List<RendezVous> rendezVousList;

    public Dossier() {
    }

    public Dossier(Integer id) {
        this.id = id;
    }

    public Dossier(Integer id, String numD) {
        this.id = id;
        this.numD = numD;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumD() {
        return numD;
    }

    public void setNumD(String numD) {
        this.numD = numD;
    }

    @XmlTransient
    public List<Document> getDocumentList() {
        return documentList;
    }

    public void setDocumentList(List<Document> documentList) {
        this.documentList = documentList;
    }

    public Utilisateur getUser() {
        return user;
    }

    public void setUser(Utilisateur user) {
        this.user = user;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @XmlTransient
    public List<Consultation> getConsultationList() {
        return consultationList;
    }

    public void setConsultationList(List<Consultation> consultationList) {
        this.consultationList = consultationList;
    }

    @XmlTransient
    public List<RendezVous> getRendezVousList() {
        return rendezVousList;
    }

    public void setRendezVousList(List<RendezVous> rendezVousList) {
        this.rendezVousList = rendezVousList;
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
        if (!(object instanceof Dossier)) {
            return false;
        }
        Dossier other = (Dossier) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Dossier[ id=" + id + " ]";
    }
    
}
