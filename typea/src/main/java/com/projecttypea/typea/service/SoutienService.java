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
    public Soutien getById(Long aLong) {
        return soutienDao.getById(aLong);
    }

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
        System.out.println(soutien);
        soutien.setMissionstage(currentMission);
        System.out.println("hna");
        soutienDao.save(soutien);
        System.out.println("hna");
        return 1;
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

    public void deleteById(Long id) {
        soutienDao.deleteById(id);
    }

}