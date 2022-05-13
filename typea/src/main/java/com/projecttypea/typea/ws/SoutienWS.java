package com.projecttypea.typea.ws;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import com.projecttypea.typea.bean.Soutien;
import com.projecttypea.typea.service.SoutienService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*", methods = { RequestMethod.POST, RequestMethod.GET,
        RequestMethod.OPTIONS })
@RestController
public class SoutienWS {

    @Autowired
    SoutienService soutienService;

    @PostMapping("/user/addsoutienmission/{missionId}")
    public int addSoutienMission(@Valid @PathVariable Long missionId, @RequestBody Soutien soutien) {
        return soutienService.addSoutienMission(missionId, soutien);
    }

    @PostMapping("/user/addsoutienmanif/{manifId}")
    public int addSoutienManifestation(@Valid @PathVariable Long manifId, @RequestBody Soutien soutien) {
        return soutienService.addSoutienManifestation(manifId, soutien);
    }

    @GetMapping("/soutiens")
    public List<Soutien> findAll() {
        return soutienService.findAll();
    }

    @PutMapping("/updatesoutien/{id}")
    public int updateCadre(@PathVariable Long id, @RequestBody Soutien soutien) {
        return soutienService.updateSoutien(id, soutien);
    }

    @Transactional
    @DeleteMapping("/deletesoutien/{id}")
    public void deleteById(@PathVariable Long id) {
        soutienService.deleteById(id);
    }
}