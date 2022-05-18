package com.projecttypea.typea.service;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import com.projecttypea.typea.bean.Cadre;
import com.projecttypea.typea.bean.DonéesPro;
import com.projecttypea.typea.bean.MissionStage;
import com.projecttypea.typea.bean.Soutien;
import com.projecttypea.typea.bean.User;
import com.projecttypea.typea.dao.MissionStageDao;
import com.projecttypea.typea.dao.UserDao;
import com.projecttypea.typea.security.enums.DemandesState;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin()
@Service
public class MissionStageService {
    public MissionStage getById(Long aLong) {
        return missionStageDao.getById(aLong);
    }

    @Autowired
    MissionStageDao missionStageDao;

    @Autowired
    DemandeService demandeService;

    @Autowired
    UserDao userDao;

    @Autowired
    SoutienService soutienService;

    @Autowired
    CadreService cadreService;

    public MissionStage getById(Long id) {
        return missionStageDao.getById(id);
    }

    public Long ajoutMissionStage(MissionStage mStage, HttpSession session) {

        addMissionStage(mStage, session);
        Long mStageId = mStage.getId();
        soutienService.addSoutienMission(mStageId, mStage.getSoutien());
        cadreService.addCadreMission(mStageId, mStage.getCadre());
        return mStageId;
    }

    public Optional<MissionStage> findById(Long id) {
        return missionStageDao.findById(id);
    }

    public void deleteById(Long id) {
        missionStageDao.deleteById(id);
    }

    public List<MissionStage> findAll() {
        return missionStageDao.findAll();
    }

    public int addMissionStage(MissionStage mission, HttpSession session) {
        User currentUser = userDao.findByEmail((String) session.getAttribute("session"));
        mission.setState(DemandesState.IDLE);
        mission.setUser(currentUser);
        mission.setDemandeType("MissionStage");
        missionStageDao.save(mission);
        return 1;
    }

    public int updateMissionStage(Long id, MissionStage missionStage) {
        MissionStage currentMouStage = missionStageDao.getById(id);
        if (currentMouStage == null) {
            return -1;
        } else {
            currentMouStage.setCadre(missionStage.getCadre());
            currentMouStage.setDateDebut(missionStage.getDateDebut());
            currentMouStage.setDateDepart(missionStage.getDateDepart());
            currentMouStage.setDateFin(missionStage.getDateFin());
            currentMouStage.setDateRetour(missionStage.getDateRetour());
            currentMouStage.setDocuments(missionStage.getDocuments());
            currentMouStage.setObjetMission(missionStage.getObjetMission());
            currentMouStage.setPays(missionStage.getPays());
            currentMouStage.setSoutien(missionStage.getSoutien());
            currentMouStage.setVille(missionStage.getVille());
            missionStageDao.save(currentMouStage);
            return 1;
        }
    }

    public List<MissionStage> findAllByUserEmail(HttpSession session) {
        String email = (String) session.getAttribute("session");
        return missionStageDao.findAllByUserEmail(email);
    }

    public User getCurrentUser(Long mStageId) {
        MissionStage currentMStage = getById(mStageId);
        User currentUser = currentMStage.getUser();
        return currentUser;
    }

    public DonéesPro getCurrentDonne(Long mStageId) {
        MissionStage currentMStage = getById(mStageId);
        User currentUser = currentMStage.getUser();
        DonéesPro currentDonnePro = currentUser.getDonne();
        return currentDonnePro;
    }

    public int mStageRefused(Long missionId) {
        MissionStage currentMissionStage = missionStageDao.getById(missionId);
        currentMissionStage.setState(DemandesState.REFUSED);
        return 1;
    }

    public int mStageAccepted(Long missionId, String toMail, String body, String subject) {
        MissionStage currentMissionStage = missionStageDao.getById(missionId);
        currentMissionStage.setState(DemandesState.APPROVED);
        demandeService.sendSimpleMail(toMail, body, subject);
        return 1;
    }

}
