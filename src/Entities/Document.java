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
import javax.persistence.Lob;
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
@Table(name = "document")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Document.findAll", query = "SELECT d FROM Document d"),
    @NamedQuery(name = "Document.findById", query = "SELECT d FROM Document d WHERE d.id = :id"),
    @NamedQuery(name = "Document.findByTypedoc", query = "SELECT d FROM Document d WHERE d.typedoc = :typedoc"),
    @NamedQuery(name = "Document.findByLibelle", query = "SELECT d FROM Document d WHERE d.libelle = :libelle"),
    @NamedQuery(name = "Document.findByFile", query = "SELECT d FROM Document d WHERE d.file = :file")})
public class Document implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "typedoc")
    private String typedoc;
    @Basic(optional = false)
    @Column(name = "libelle")
    private String libelle;
    @Basic(optional = false)
    @Lob
    @Column(name = "stockage")
    private byte[] stockage;
    @Basic(optional = false)
    @Column(name = "file")
    private String file;
    @JoinColumn(name = "dossier", referencedColumnName = "numD")
    @ManyToOne(optional = false)
    private Dossier dossier;

    public Document() {
    }

    public Document(Integer id) {
        this.id = id;
    }

    public Document(Integer id, String typedoc, String libelle, byte[] stockage, String file) {
        this.id = id;
        this.typedoc = typedoc;
        this.libelle = libelle;
        this.stockage = stockage;
        this.file = file;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypedoc() {
        return typedoc;
    }

    public void setTypedoc(String typedoc) {
        this.typedoc = typedoc;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public byte[] getStockage() {
        return stockage;
    }

    public void setStockage(byte[] stockage) {
        this.stockage = stockage;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
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
        if (!(object instanceof Document)) {
            return false;
        }
        Document other = (Document) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Document[ id=" + id + " ]";
    }
    
}
