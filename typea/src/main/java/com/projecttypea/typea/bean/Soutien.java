package com.projecttypea.typea.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Soutien {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String isBenfTypeA;

    /* @NotEmpty(message = "Montant peut pas etre vide") */
    private int montant;

    private String nature;

    /* @NotEmpty(message = "Montant titre transport peut pas etre vide") */
    private int mTitreTransport;

    /* @NotEmpty(message = "Montant frais inscription peut pas etre vide") */
    private int mFraisInscription;

    /* @NotEmpty(message = "Montant hebergement peut pas etre vide") */
    private int mHebergement;

    /* @NotEmpty(message = "Montant autre peut pas etre vide") */
    private int mAutre;
    private String devise;

    public String getDevise() {
        return devise;
    }

    public void setDevise(String devise) {
        this.devise = devise;
    }

    @JsonBackReference("soutienM")
    @OneToOne
    private Manifestation manifestation;

    @JsonBackReference("soutienMS")
    @OneToOne
    private MissionStage missionstage;

    public long getId() {
        return id;
    }

    public String getIsBenfTypeA() {
        return isBenfTypeA;
    }

    public void setIsBenfTypeA(String isBenfTypeA) {
        this.isBenfTypeA = isBenfTypeA;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getMontant() {
        return montant = mAutre + mFraisInscription + mHebergement + mTitreTransport;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public float getmTitreTransport() {
        return mTitreTransport;
    }

    public void setmTitreTransport(int mTitreTransport) {
        this.mTitreTransport = mTitreTransport;
    }

    public float getmFraisInscription() {
        return mFraisInscription;
    }

    public void setmFraisInscription(int mFraisInscription) {
        this.mFraisInscription = mFraisInscription;
    }

    public float getmHebergement() {
        return mHebergement;
    }

    public void setmHebergement(int mHebergement) {
        this.mHebergement = mHebergement;
    }

    public float getmAutre() {
        return mAutre;
    }

    public void setmAutre(int mAutre) {
        this.mAutre = mAutre;
    }

    public Manifestation getManifestation() {
        return manifestation;
    }

    public void setManifestation(Manifestation manifestation) {
        this.manifestation = manifestation;
    }

    public MissionStage getMissionstage() {
        return missionstage;
    }

    public void setMissionstage(MissionStage missionstage) {
        this.missionstage = missionstage;
    }

    public Soutien() {
    }
}
