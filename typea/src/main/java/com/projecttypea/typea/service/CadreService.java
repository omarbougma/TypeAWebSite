package com.projecttypea.typea.service;

import java.util.List;

import com.projecttypea.typea.bean.Cadre;
import com.projecttypea.typea.dao.CadreDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadreService {
    @Autowired
    CadreDao cadreDao;

    public void deleteById(Long id) {
        cadreDao.deleteById(id);
    }

    public List<Cadre> findAll() {
        return cadreDao.findAll();
    }

    public int addMissionStage(Cadre cadre) {
        if (cadreDao.findById(cadre.getId()) != null) {
            return -1;
        } else {
            cadreDao.save(cadre);
            return 1;
        }
    }

    public int updateCadre(Long id, Cadre cadre) {
        Cadre currentCadre = cadreDao.getById(id);
        if (currentCadre == null) {
            return -1;
        } else {
            currentCadre.setTitreCadre(cadre.getTitreCadre());
            currentCadre.setTitreprojet(cadre.getTitreprojet());
            currentCadre.setRespoMarDuProjet(cadre.getRespoMarDuProjet());
            currentCadre.setPartenaireEtranger(cadre.getPartenaireEtranger());
            cadreDao.save(currentCadre);
            return 1;
        }
    }

}