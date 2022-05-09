package com.projecttypea.typea.ws;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import com.projecttypea.typea.bean.Manifestation;
import com.projecttypea.typea.service.ManifestationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/manifestationapi")
@RestController
public class ManifestationWS {

    @Autowired
    ManifestationService manifestationService;

    @PutMapping("/user/updatemanif/{id}")
    public int updateManifestation(@PathVariable Long id, @RequestBody Manifestation manifestation) {
        return manifestationService.updateManifestation(id, manifestation);
    }

    @Transactional
    @DeleteMapping("/deletemanif/{id}")
    public void deleteById(Long id) {
        manifestationService.deleteById(id);
    }

    @GetMapping("/admin/manifestations")
    public List<Manifestation> findAll() {
        return manifestationService.findAll();
    }

    @PostMapping("/user/addmanifestation")
    public int addManifestation(@RequestBody Manifestation manifestation, HttpSession session) {
        if (session != null) {
            return manifestationService.addManifestation(manifestation);
        } else {
            return -2;
        }
    }

}
