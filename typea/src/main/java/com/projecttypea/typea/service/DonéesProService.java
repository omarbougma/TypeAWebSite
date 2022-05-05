package com.projecttypea.typea.service;

import java.util.List;

import com.projecttypea.typea.bean.DonéesPro;
import com.projecttypea.typea.dao.DonéesProDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DonéesProService {

    @Autowired
    DonéesProDao donéesProDao;

    public List<DonéesPro> findAll() {
        return donéesProDao.findAll();
    }

    public int addDonesPro(DonéesPro donne) {
        if (donéesProDao.findById(donne.getId()) != null) {
            return -1;
        } else {
            donéesProDao.save(donne);
            return 1;
        }
    }

    public int updateDonesPro(Long id, DonéesPro donnePro) {
        DonéesPro currentDonnes = donéesProDao.getById(id);
        if (currentDonnes == null) {
            return -1;
        } else {
            currentDonnes.setCed(donnePro.getCed());
            currentDonnes.setEntiteRecherche(donnePro.getEntiteRecherche());
            currentDonnes.setEtablissement(donnePro.getEtablissement());
            currentDonnes.setGrade(donnePro.getGrade());
            currentDonnes.setNiveau(donnePro.getNiveau());
            currentDonnes.setRespoEntite(donnePro.getRespoEntite());
            donéesProDao.save(currentDonnes);
            return 1;
        }
    }

    public void deleteById(Long id) {
        donéesProDao.deleteById(id);
    }

}