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

    @GetMapping("/soutiens")
    public List<Soutien> findAll() {
        return soutienService.findAll();
    }

    @PostMapping("/addsoutien")
    public int addUser(@RequestBody Soutien soutien) {
        return soutienService.addUser(soutien);
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