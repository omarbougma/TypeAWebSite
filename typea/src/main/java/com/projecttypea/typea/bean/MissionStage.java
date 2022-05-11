package com.projecttypea.typea.bean;

import java.util.Calendar;
import java.util.List;

//import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
//import javax.persistence.OneToMany;
//import javax.persistence.OneToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import org.springframework.beans.factory.annotation.Value;

@Entity
public class MissionStage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotEmpty(message = "Objetmission peut pas etre vide")
    private String objetMission;

    @NotEmpty(message = "Objetmission peut pas etre vide")
    private String pays;

    @NotEmpty(message = "Objetmission peut pas etre vide")
    private String ville;

    @NotEmpty(message = "Objetmission peut pas etre vide")
    private Calendar dateDebut;

    @NotEmpty(message = "Objetmission peut pas etre vide")
    private Calendar dateFin;

    @NotEmpty(message = "Objetmission peut pas etre vide")
    private Calendar dateDepart;

    @NotEmpty(message = "Objetmission peut pas etre vide")
    private Calendar dateRetour;

    @NotEmpty(message = "Objetmission peut pas etre vide")
    private Calendar dateCreation;

    @NotEmpty(message = "Objetmission peut pas etre vide")
    private String state;

    @Value("MissionStage")
    private String demandeType;

    @JsonBackReference(value = "missionStage")
    @ManyToOne
    private User user;

    @OneToOne(mappedBy = "missionstage")
    private Soutien soutien;

    @OneToOne(mappedBy = "missionstage")
    private Cadre cadre;

    @JsonManagedReference(value = "Sdocuments")
    @OneToMany(mappedBy = "missionstage")
    private List<Documents> documents;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getObjetMission() {
        return objetMission;
    }

    public void setObjetMission(String objetMission) {
        this.objetMission = objetMission;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
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

    public Cadre getCadre() {
        return cadre;
    }

    public void setCadre(Cadre cadre) {
        this.cadre = cadre;
    }

    public List<Documents> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Documents> documents) {
        this.documents = documents;
    }

    public Calendar getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Calendar dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public MissionStage() {
    }
}
