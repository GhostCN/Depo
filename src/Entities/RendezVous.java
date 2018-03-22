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
@Table(name = "rendez_vous")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RendezVous.findAll", query = "SELECT r FROM RendezVous r"),
    @NamedQuery(name = "RendezVous.findById", query = "SELECT r FROM RendezVous r WHERE r.id = :id"),
    @NamedQuery(name = "RendezVous.findByNumRv", query = "SELECT r FROM RendezVous r WHERE r.numRv = :numRv"),
    @NamedQuery(name = "RendezVous.findByDateRv", query = "SELECT r FROM RendezVous r WHERE r.dateRv = :dateRv")})
public class RendezVous implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "numRv")
    private String numRv;
    @Basic(optional = false)
    @Column(name = "dateRv")
    private String dateRv;
    @JoinColumn(name = "dossier", referencedColumnName = "numD")
    @ManyToOne(optional = false)
    private Dossier dossier;

    public RendezVous() {
    }

    public RendezVous(Integer id) {
        this.id = id;
    }

    public RendezVous(Integer id, String numRv, String dateRv) {
        this.id = id;
        this.numRv = numRv;
        this.dateRv = dateRv;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumRv() {
        return numRv;
    }

    public void setNumRv(String numRv) {
        this.numRv = numRv;
    }

    public String getDateRv() {
        return dateRv;
    }

    public void setDateRv(String dateRv) {
        this.dateRv = dateRv;
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
        if (!(object instanceof RendezVous)) {
            return false;
        }
        RendezVous other = (RendezVous) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.RendezVous[ id=" + id + " ]";
    }
    
}
