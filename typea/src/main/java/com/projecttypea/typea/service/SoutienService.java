package com.projecttypea.typea.service;

import java.util.List;

import com.projecttypea.typea.bean.Manifestation;
import com.projecttypea.typea.bean.MissionStage;
import com.projecttypea.typea.bean.Soutien;
import com.projecttypea.typea.dao.ManifestationDao;
import com.projecttypea.typea.dao.MissionStageDao;
import com.projecttypea.typea.dao.SoutienDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SoutienService {
    @Autowired
    SoutienDao soutienDao;

    @Autowired
    MissionStageDao missionStageDao;

    @Autowired
    ManifestationDao manifestationDao;

    public List<Soutien> findAll() {
        return soutienDao.findAll();
    }

    public int addSoutienMission(Long missionId, Soutien soutien) {
        MissionStage currentMission = missionStageDao.getById(missionId);
        if (currentMission.getSoutien() != null) {
            return -1;
        } else {
            soutien.setMissionstage(currentMission);
            soutienDao.save(soutien);
            return 1;
        }
    }

    public int addSoutienManifestation(Long manifId, Soutien soutien) {
        Manifestation curentManifestation = manifestationDao.getById(manifId);
        if (curentManifestation.getSoutien() != null) {
            return -1;
        } else {
            soutien.setManifestation(curentManifestation);
            soutienDao.save(soutien);
            return 1;
        }
    }

    public int updateSoutien(Long id, Soutien soutien) {
        Soutien currentSoutien = soutienDao.getById(id);
        if (currentSoutien == null) {
            return -1;
        } else {
            currentSoutien.setIsBenfTypeA(soutien.getIsBenfTypeA());
            currentSoutien.setMontant(soutien.getMontant());
            currentSoutien.setNature(soutien.isNature());
            currentSoutien.setmAutre(soutien.getmAutre());
            currentSoutien.setmFraisInscription(soutien.getmFraisInscription());
            currentSoutien.setmHebergement(soutien.getmHebergement());
            currentSoutien.setmTitreTransport(soutien.getmTitreTransport());
            soutienDao.save(currentSoutien);
            return 1;
        }
    }

    public void deleteById(Long id) {
        soutienDao.deleteById(id);
    }

}