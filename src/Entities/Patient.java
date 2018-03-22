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
@Table(name = "patient")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Patient.findAll", query = "SELECT p FROM Patient p"),
    @NamedQuery(name = "Patient.findById", query = "SELECT p FROM Patient p WHERE p.id = :id"),
    @NamedQuery(name = "Patient.findByNumP", query = "SELECT p FROM Patient p WHERE p.numP = :numP"),
    @NamedQuery(name = "Patient.findByNom", query = "SELECT p FROM Patient p WHERE p.nom = :nom"),
    @NamedQuery(name = "Patient.findByPrenom", query = "SELECT p FROM Patient p WHERE p.prenom = :prenom"),
    @NamedQuery(name = "Patient.findByAge", query = "SELECT p FROM Patient p WHERE p.age = :age"),
    @NamedQuery(name = "Patient.findByTel", query = "SELECT p FROM Patient p WHERE p.tel = :tel"),
    @NamedQuery(name = "Patient.findByEmail", query = "SELECT p FROM Patient p WHERE p.email = :email"),
    @NamedQuery(name = "Patient.findByVille", query = "SELECT p FROM Patient p WHERE p.ville = :ville"),
    @NamedQuery(name = "Patient.findByNomParent", query = "SELECT p FROM Patient p WHERE p.nomParent = :nomParent"),
    @NamedQuery(name = "Patient.findByTelParent", query = "SELECT p FROM Patient p WHERE p.telParent = :telParent")})
public class Patient implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "numP")
    private String numP;
    @Basic(optional = false)
    @Column(name = "nom")
    private String nom;
    @Basic(optional = false)
    @Column(name = "prenom")
    private String prenom;
    @Basic(optional = false)
    @Column(name = "age")
    private int age;
    @Column(name = "Tel")
    private String tel;
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "ville")
    private String ville;
    @Column(name = "NomParent")
    private String nomParent;
    @Column(name = "telParent")
    private String telParent;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patient")
    private List<Dossier> dossierList;

    public Patient() {
    }

    public Patient(Integer id) {
        this.id = id;
    }

    public Patient(Integer id, String numP, String nom, String prenom, int age, String ville) {
        this.id = id;
        this.numP = numP;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.ville = ville;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumP() {
        return numP;
    }

    public void setNumP(String numP) {
        this.numP = numP;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getNomParent() {
        return nomParent;
    }

    public void setNomParent(String nomParent) {
        this.nomParent = nomParent;
    }

    public String getTelParent() {
        return telParent;
    }

    public void setTelParent(String telParent) {
        this.telParent = telParent;
    }

    @XmlTransient
    public List<Dossier> getDossierList() {
        return dossierList;
    }

    public void setDossierList(List<Dossier> dossierList) {
        this.dossierList = dossierList;
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
        if (!(object instanceof Patient)) {
            return false;
        }
        Patient other = (Patient) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Patient[ id=" + id + " ]";
    }
    
}
