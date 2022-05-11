package com.projecttypea.typea.ws;

import java.util.List;

import javax.transaction.Transactional;

import com.projecttypea.typea.bean.Soutien;
import com.projecttypea.typea.service.SoutienService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SoutienWS {

    @Autowired
    SoutienService soutienService;

    @PostMapping("/user/addsoutienmission/{missionId}")
    public int addSoutienMission(@PathVariable Long missionId, @RequestBody Soutien soutien) {
        return soutienService.addSoutienMission(missionId, soutien);
    }

    @PostMapping("/user/addsoutienmanif/{manifId}")
    public int addSoutienManifestation(@PathVariable Long manifId, @RequestBody Soutien soutien) {
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