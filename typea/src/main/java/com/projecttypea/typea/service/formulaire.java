package com.projecttypea.typea.service;

import com.projecttypea.typea.bean.*;
import com.projecttypea.typea.dao.ManifestationDao;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class formulaire {


    public int exportReport(long id) throws FileNotFoundException, JRException {
        Manifestation manifestation = getById(id);
        User user = userService.findByNom(manifestation.getUser().getNom());
        DonéesPro donéesPro = donéesProService.findByUser(user);

        Soutien soutien = soutienService.getById(manifestation.getSoutien().getId());
        File file = ResourceUtils.getFile("classpath:formulaire.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(Collections.singleton(manifestation));
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("nom", user.getNom());
        parameters.put("prenom", user.getPrenom());
        parameters.put("telephone", user.getTelephone());
        parameters.put("email", user.getEmail());

        parameters.put("id",manifestation.getId());
        parameters.put("titremanifestation",manifestation.getTitreManifestation());
        parameters.put("titreparticipation",manifestation.getTitreParticipation());
        parameters.put("pays",manifestation.getPays());
        parameters.put("datedebut",manifestation.getDateDebut());
        parameters.put("datefin",manifestation.getDateFin());
        parameters.put("datedepert",manifestation.getDateDepart());
        parameters.put("dateretour",manifestation.getDateRetour());
        parameters.put("ville",manifestation.getVille());


        parameters.put("niveau", donéesPro.getNiveau());
        parameters.put("grade", donéesPro.getGrade());
        parameters.put("ced", donéesPro.getCed());
        parameters.put("etablissement", donéesPro.getEtablissement());
        parameters.put("entitérecherche", donéesPro.getEntiteRecherche());
        parameters.put("respoentité", donéesPro.getRespoEntite());


        parameters.put("nature", soutien.isNature());
        parameters.put("mtitretransport", soutien.getmTitreTransport());
        parameters.put("mhebergement", soutien.getmHebergement());
        parameters.put("mtotal", soutien.getMontant());
        parameters.put("mfraisinscription", soutien.getmFraisInscription());
        parameters.put("montant autre", soutien.getmAutre());

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);


        JasperExportManager.exportReportToPdfFile(jasperPrint, "C:\\Users\\User\\Desktop\\repports\\manif" +"\\"+user.getNom()+manifestation.getId()+".pdf");

        return 1;
    }


    public int exportReportMission(long id) throws FileNotFoundException, JRException {
        MissionStage mission =  missionStageService.getById(id);
        User user = userService.findByNom(mission.getUser().getNom());
        DonéesPro donéesPro = donéesProService.findByUser(user);
        Cadre cadre = cadreService.findByMissionstage(mission);

        Soutien soutien = soutienService.getById(mission.getSoutien().getId());
        File file = ResourceUtils.getFile("classpath:formmission.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(Collections.singleton(mission));
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("nom", user.getNom());
        parameters.put("prenom", user.getPrenom());
        parameters.put("telephone", user.getTelephone());
        parameters.put("email", user.getEmail());

        parameters.put("id",mission.getId());

        parameters.put("titreparticipation",mission.getObjetMission());
        parameters.put("pays",mission.getPays());
        parameters.put("datedebut",mission.getDateDebut());
        parameters.put("datefin",mission.getDateFin());
        parameters.put("datedepert",mission.getDateDepart());
        parameters.put("dateretour",mission.getDateRetour());
        parameters.put("ville",mission.getVille());


        parameters.put("niveau", donéesPro.getNiveau());
        parameters.put("grade", donéesPro.getGrade());
        parameters.put("ced", donéesPro.getCed());
        parameters.put("etablissement", donéesPro.getEtablissement());
        parameters.put("entitérecherche", donéesPro.getEntiteRecherche());
        parameters.put("respoentité", donéesPro.getRespoEntite());


        parameters.put("nature", soutien.isNature());
        parameters.put("mtitretransport", soutien.getmTitreTransport());
        parameters.put("mhebergement", soutien.getmHebergement());
        parameters.put("mtotal", soutien.getMontant());
        parameters.put("mfraisinscription", soutien.getmFraisInscription());
        parameters.put("montant autre", soutien.getmAutre());


        parameters.put("1", cadre.getTitreCadre());
        parameters.put("3", cadre.getRespoMarDuProjet());
        parameters.put("4", cadre.getPartenaireEtranger());
        parameters.put("2", cadre.getTitreProjet());


        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);


        JasperExportManager.exportReportToPdfFile(jasperPrint, "C:\\Users\\User\\Desktop\\repports\\mission" + "\\"+user.getNom()+mission.getId()+".pdf");

        return 1;
    }

    public Manifestation getById(Long aLong) {
        return manifestationDao.getById(aLong);
    }

    @Autowired
    private ManifestationDao manifestationDao;
    @Autowired
    private DonéesProService donéesProService;
    @Autowired
    private UserService userService;
    @Autowired
    private SoutienService soutienService;
    @Autowired
    private  MissionStageService missionStageService;
    @Autowired
    private  CadreService cadreService;
}