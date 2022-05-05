package com.projecttypea.typea.bean;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.beans.factory.annotation.Value;

@Entity
public class Manifestation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private Calendar dateCreation;
    private String titreManifestation;
    private String titreParticipation;
    private String Pays;
    private String Ville;
    private Calendar dateDebut;
    private Calendar dateFin;
    private Calendar dateDepart;
    private Calendar dateRetour;
    private String natureParticiaton;
    private String state;

    @Value("Manifestation")
    private String demandeType;

    @ManyToOne
    private User user;

    @OneToOne(mappedBy = "manifestation")
    private Soutien soutien;

    @OneToMany(mappedBy = "manifestation")
    private List<Documents> documents;

    public long getId() {
        return id;
    }

    public String getTitreParticipation() {
        return titreParticipation;
    }

    public void setTitreParticipation(String titreParticipation) {
        this.titreParticipation = titreParticipation;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Calendar getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Calendar dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getTitreManifestation() {
        return titreManifestation;
    }

    public void setTitreManifestation(String titreManifestation) {
        this.titreManifestation = titreManifestation;
    }

    public String getPays() {
        return Pays;
    }

    public void setPays(String pays) {
        Pays = pays;
    }

    public String getVille() {
        return Ville;
    }

    public void setVille(String ville) {
        Ville = ville;
    }

    public Calendar getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Calendar dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Calendar getDateFin() {
        return dateFin;
    }

    public void setDateFin(Calendar dateFin) {
        this.dateFin = dateFin;
    }

    public Calendar getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(Calendar dateDepart) {
        this.dateDepart = dateDepart;
    }

    public Calendar getDateRetour() {
        return dateRetour;
    }

    public void setDateRetour(Calendar dateRetour) {
        this.dateRetour = dateRetour;
    }

    public String getNatureParticiaton() {
        return natureParticiaton;
    }

    public void setNatureParticiaton(String natureParticiaton) {
        this.natureParticiaton = natureParticiaton;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Soutien getSoutien() {
        return soutien;
    }

    public void setSoutien(Soutien soutien) {
        this.soutien = soutien;
    }

    public List<Documents> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Documents> documents) {
        this.documents = documents;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Manifestation() {
    }

}
