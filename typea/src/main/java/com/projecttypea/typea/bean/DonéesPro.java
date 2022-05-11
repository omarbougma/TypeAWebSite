package com.projecttypea.typea.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class DonéesPro {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotEmpty(message = "Niveau peut pas etre vide")
    private String niveau;

    @NotEmpty(message = "Grade peut pas etre vide")
    private String grade;

    @NotEmpty(message = "CED peut pas etre vide")
    private String ced;

    @NotEmpty(message = "Etablissement peut pas etre vide")
    private String etablissement;

    @NotEmpty(message = "Entite de recherche peut pas etre vide")
    private String entiteRecherche;

    private String respoEntite;

    @OneToOne
    private Manifestation manifestation;

    @OneToOne
    private MissionStage missionStage;

    @JsonBackReference(value = "donne")
    @JoinColumn(name = "user_id")
    @OneToOne
    private User user;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getCed() {
        return ced;
    }

    public void setCed(String ced) {
        this.ced = ced;
    }

    public String getEtablissement() {
        return etablissement;
    }

    public void setEtablissement(String etablissement) {
        this.etablissement = etablissement;
    }

    public String getEntiteRecherche() {
        return entiteRecherche;
    }

    public void setEntiteRecherche(String entiteRecherche) {
        this.entiteRecherche = entiteRecherche;
    }

    public String getRespoEntite() {
        return respoEntite;
    }

    public void setRespoEntite(String respoEntite) {
        this.respoEntite = respoEntite;
    }

    public DonéesPro() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}