package com.projecttypea.typea.bean;

import java.util.List;

//import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
//import javax.persistence.OneToOne;
import javax.persistence.OneToOne;

import com.projecttypea.typea.security.UserRoles;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private String telephone;

    private UserRoles userRole;

    @OneToOne(mappedBy = "user")
    private DonéesPro Donne;

    @OneToMany(mappedBy = "user")
    private List<Manifestation> manifEstation;

    @OneToMany(mappedBy = "user")
    private List<MissionStage> missionStage;

    public DonéesPro getDonne() {
        return Donne;
    }

    public void setDonne(DonéesPro donne) {
        Donne = donne;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Manifestation> getManifEstation() {
        return manifEstation;
    }

    public void setManifEstation(List<Manifestation> manifEstation) {
        this.manifEstation = manifEstation;
    }

    public List<MissionStage> getMissionStage() {
        return missionStage;
    }

    public void setMissionStage(List<MissionStage> missionStage) {
        this.missionStage = missionStage;
    }

    public UserRoles getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRoles userRole) {
        this.userRole = userRole;
    }

    public User() {
    }

}
