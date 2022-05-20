package com.projecttypea.typea.service;

import com.projecttypea.typea.bean.Manifestation;
import com.projecttypea.typea.bean.MissionStage;
import com.projecttypea.typea.bean.NouveauMontant;
import com.projecttypea.typea.dao.ManifestationDao;
import com.projecttypea.typea.dao.MissionStageDao;
import com.projecttypea.typea.dao.NouveauMontantDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NouveauMontantService {

    @Autowired
    NouveauMontantDao nouveauMontantDao;

    @Autowired
    MissionStageDao missionStageDao;

    public NouveauMontant findByMissionstageId(Long id) {
        return nouveauMontantDao.findByMissionstageId(id);
    }

    public NouveauMontant findByManifestationId(Long id) {
        return nouveauMontantDao.findByManifestationId(id);
    }

    @Autowired
    ManifestationDao manifDao;

    public int addMontantsMS(Long mStageId, NouveauMontant nvMontant) {
        MissionStage currentMS = missionStageDao.getById(mStageId);
        nvMontant.setmStage(currentMS);
        nouveauMontantDao.save(nvMontant);
        return 1;
    }

    public int addMontantsM(Long manifId, NouveauMontant nvMontant) {
        Manifestation currentM = manifDao.getById(manifId);
        nvMontant.setManifestation(currentM);
        nouveauMontantDao.save(nvMontant);
        return 1;
    }
}
