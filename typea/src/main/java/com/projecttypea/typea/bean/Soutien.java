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

    private Boolean isBenfTypeA;

    @NotEmpty(message = "Montant peut pas etre vide")
    private float montant;

    private boolean nature;

    @NotEmpty(message = "Montant titre transport peut pas etre vide")
    private float mTitreTransport;

    @NotEmpty(message = "Montant frais inscription peut pas etre vide")
    private float mFraisInscription;

    @NotEmpty(message = "Montant hebergement peut pas etre vide")
    private float mHebergement;

    @NotEmpty(message = "Montant autre peut pas etre vide")
    private float mAutre;

    @JsonBackReference("soutienM")
    @OneToOne
    private Manifestation manifestation;

    @JsonBackReference("soutienMS")
    @OneToOne
    private MissionStage missionstage;

    public long getId() {
        return id;
    }

    public Boolean getIsBenfTypeA() {
        return isBenfTypeA;
    }

    public void setIsBenfTypeA(Boolean isBenfTypeA) {
        this.isBenfTypeA = isBenfTypeA;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getMontant() {
        return montant;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }

    public boolean isNature() {
        return nature;
    }

    public void setNature(boolean nature) {
        this.nature = nature;
    }

    public float getmTitreTransport() {
        return mTitreTransport;
    }

    public void setmTitreTransport(float mTitreTransport) {
        this.mTitreTransport = mTitreTransport;
    }

    public float getmFraisInscription() {
        return mFraisInscription;
    }

    public void setmFraisInscription(float mFraisInscription) {
        this.mFraisInscription = mFraisInscription;
    }

    public float getmHebergement() {
        return mHebergement;
    }

    public void setmHebergement(float mHebergement) {
        this.mHebergement = mHebergement;
    }

    public float getmAutre() {
        return mAutre;
    }

    public void setmAutre(float mAutre) {
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
