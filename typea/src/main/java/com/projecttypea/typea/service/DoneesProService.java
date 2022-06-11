package com.projecttypea.typea.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.projecttypea.typea.bean.DoneesPro;
import com.projecttypea.typea.bean.Montant_par_labo;
import com.projecttypea.typea.bean.User;
import com.projecttypea.typea.dao.DoneesProDao;
import com.projecttypea.typea.dao.EtablissementDao;
import com.projecttypea.typea.dao.UserDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoneesProService {

    @Autowired
    UserDao userDao;
    @Autowired
    UserService userService;

    @Autowired
    DoneesProDao doneesProDao;
    @Autowired
    EtablissementService etablissementService;
    @Autowired
    private EtablissementDao etablissementDao;
    @Autowired
    private  NouveauMontantService nouveauMontantService;
    @Autowired
    private  Montant_par_laboService montant_par_laboService;




    public List<DoneesPro> findAll() {
        return doneesProDao.findAll();
    }

    public DoneesPro findByUser(User user) {
        return doneesProDao.findByUser(user);
    }

    public DoneesPro findByUserId(Long id) {
        return doneesProDao.findByUserId(id);
    }

    public int addDonesPro(DoneesPro donne, HttpSession session) {
        User currentUser = userDao.findByEmail((String) session.getAttribute("session"));
        System.out.println(session.getAttribute("session"));

            if (currentUser.getDonne() != null) {

                return 1;

            } else if (currentUser.getDonne() == null) {
                currentUser.setDonne(donne);
                etablissementService.save(donne.getEtablissement());
                donne.setEtablissement(donne.getEtablissement());
                donne.setUser(currentUser);
                doneesProDao.save(donne);
                findlabos();


                return -1;
            } else {
                return -3;
            }
        }


public int savee(DoneesPro doneesPro)
{
    doneesProDao.save(doneesPro);
    return 1;
}


    public int save(DoneesPro donne, HttpSession session) {
        User currentUser = userDao.findByEmail((String) session.getAttribute("session"));
        donne.setUser(currentUser);
       etablissementDao.save(donne.getEtablissement());
       donne.setEtablissement(donne.getEtablissement());
       doneesProDao.save(donne);

        return 1;
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

        doneesProDao.deleteById(id);
    }
    public  void findlabos(){
        Montant_par_labo element = new Montant_par_labo() ;
        findAll().forEach(donne -> {
            element.setLabo(donne.getLabo());
            if(nouveauMontantService.montant_par_labo(donne.getLabo(), LocalDate.now().getYear()) == null){
                element.setMontant(0);
                montant_par_laboService.save(element);
            }else
            {
                element.setMontant(Integer.parseInt(nouveauMontantService.montant_par_labo(donne.getLabo(), LocalDate.now().getYear())));
                montant_par_laboService.save(element);
            }


        });
    }

}