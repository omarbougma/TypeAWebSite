package com.projecttypea.typea.service;

import java.util.List;
import java.util.Optional;

import com.projecttypea.typea.bean.Manifestation;
import com.projecttypea.typea.dao.ManifestationDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManifestationService {

    @Autowired
    ManifestationDao manifestationDao;

    public Optional<Manifestation> findById(Long id) {
        return manifestationDao.findById(id);
    }

    public List<Manifestation> findAll() {
        return manifestationDao.findAll();
    }

    public int addManifestation(Manifestation manifestation) {
        if (manifestationDao.findById(manifestation.getId()) != null) {
            return -1;
        } else {
            manifestationDao.save(manifestation);
            return 1;
        }
    }

    public int updateManifestation(Long id, Manifestation manifestation) {
        Manifestation currentManif = manifestationDao.getById(id);
        if (currentManif == null) {
            return -1;
        } else {
            currentManif.setDateCreation(manifestation.getDateCreation());
            currentManif.setDateDebut(manifestation.getDateDebut());
            currentManif.setDateDepart(manifestation.getDateDepart());
            currentManif.setDateFin(manifestation.getDateFin());
            currentManif.setDateRetour(manifestation.getDateRetour());
            currentManif.setNatureParticiaton(manifestation.getNatureParticiaton());
            currentManif.setPays(manifestation.getPays());
            currentManif.setSoutien(manifestation.getSoutien());
            currentManif.setTitreManifestation(manifestation.getTitreManifestation());
            currentManif.setTitreParticipation(manifestation.getTitreParticipation());
            currentManif.setVille(manifestation.getVille());
            currentManif.setDocuments(manifestation.getDocuments());
            manifestationDao.save(currentManif);
            return 1;
        }
    }

    public void deleteById(Long id) {
        manifestationDao.deleteById(id);
    }
}