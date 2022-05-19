package com.projecttypea.typea.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.projecttypea.typea.bean.DonéesPro;
import com.projecttypea.typea.bean.User;
import com.projecttypea.typea.dao.DonéesProDao;
import com.projecttypea.typea.dao.UserDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DonéesProService {

    @Autowired
    UserDao userDao;

    public DonéesPro findByUser(User user) {
        return donéesProDao.findByUser(user);
    }

    @Autowired
    DonéesProDao donéesProDao;

    public List<DonéesPro> findAll() {
        return donéesProDao.findAll();
    }

    public int addDonesPro(DonéesPro donne, HttpSession session) {
        User currentUser = userDao.findByEmail((String) session.getAttribute("session"));
        System.out.println(session.getAttribute("session"));
        try {
            if (currentUser.getDonne() != null) {
                currentUser.setDonne(donne);
                donéesProDao.save(donne);
                return -1;

            } else if (currentUser.getDonne() == null) {
                donne.setUser(currentUser);
                donéesProDao.save(donne);
                return 1;
            } else {
                return -3;
            }
        } catch (Exception e) {
            return -2;
        }
    }

    /*
     * public int updateDonesPro(Long id, DonéesPro donnePro) {
     * DonéesPro currentDonnes = donéesProDao.getById(id);
     * if (currentDonnes == null) {
     * return -1;
     * } else {
     * currentDonnes.setCed(donnePro.getCed());
     * currentDonnes.setEntiteRecherche(donnePro.getEntiteRecherche());
     * currentDonnes.setEtablissement(donnePro.getEtablissement());
     * currentDonnes.setGrade(donnePro.getGrade());
     * currentDonnes.setNiveau(donnePro.getNiveau());
     * currentDonnes.setRespoEntite(donnePro.getRespoEntite());
     * donéesProDao.save(currentDonnes);
     * return 1;
     * }
     * }
     */
    public void deleteById(Long id) {
        donéesProDao.deleteById(id);
    }

}