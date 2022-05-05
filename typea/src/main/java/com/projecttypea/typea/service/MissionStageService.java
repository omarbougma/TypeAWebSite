package com.projecttypea.typea.service;

import java.util.List;

import com.projecttypea.typea.bean.MissionStage;
import com.projecttypea.typea.dao.MissionStageDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MissionStageService {
    @Autowired
    MissionStageDao missionStageDao;

    public void deleteById(Long id) {
        missionStageDao.deleteById(id);
    }

    public List<MissionStage> findAll() {
        return missionStageDao.findAll();
    }

    public int addMissionStage(MissionStage mission) {
        if (missionStageDao.findById(mission.getId()) != null) {
            return -1;
        } else {
            missionStageDao.save(mission);
            return 1;
        }
    }

    public int updateMissionStage(Long id, MissionStage missionStage) {
        MissionStage currentMouStage = missionStageDao.getById(id);
        if (currentMouStage == null) {
            return -1;
        } else {
            currentMouStage.setCadre(missionStage.getCadre());
            currentMouStage.setDateCreation(missionStage.getDateCreation());
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
}
