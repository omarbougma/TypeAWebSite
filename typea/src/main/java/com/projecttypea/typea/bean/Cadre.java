package com.projecttypea.typea.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Cadre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotEmpty(message = "Titre de cadre peut pas etre vide")
    private String titreCadre;

    /* @NotEmpty(message = "Titre de projet peut pas etre vide") */
    private String titreprojet;

    @NotEmpty(message = "responsable marocain du projet peut pas etre vide")
    private String respoMarDuProjet;

    private String isFinance;

    private String partenaireEtranger;

    @JsonBackReference("cadre")
    @OneToOne
    private MissionStage missionstage;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitreCadre() {
        return titreCadre;
    }

    public void setTitreCadre(String titreCadre) {
        this.titreCadre = titreCadre;
    }

    public String getTitreprojet() {
        return titreprojet;
    }

    public void setTitreprojet(String titreprojet) {
        this.titreprojet = titreprojet;
    }

    public String getRespoMarDuProjet() {
        return respoMarDuProjet;
    }

    public void setRespoMarDuProjet(String respoMarDuProjet) {
        this.respoMarDuProjet = respoMarDuProjet;
    }

    public String getPartenaireEtranger() {
        return partenaireEtranger;
    }

    public void setPartenaireEtranger(String partenaireEtranger) {
        this.partenaireEtranger = partenaireEtranger;
    }

    public MissionStage getMissionstage() {
        return missionstage;
    }

    public void setMissionstage(MissionStage missionstage) {
        this.missionstage = missionstage;
    }

    public String getIsFinance() {
        return isFinance;
    }

    public void setIsFinance(String isFinance) {
        this.isFinance = isFinance;
    }

    public Cadre() {
    }

}
