package com.projecttypea.typea.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class DonéesPro {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String niveau;
    private String grade;
    private String ced;
    private String etablissement;
    private String entiteRecherche;
    private String respoEntite;

    @OneToOne
    private Manifestation manifestation;

    @OneToOne
    private MissionStage missionStage;

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
}