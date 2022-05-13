package com.projecttypea.typea.ws;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import com.projecttypea.typea.bean.Cadre;
import com.projecttypea.typea.service.CadreService;

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
public class CadreWS {

    @Autowired
    CadreService cadreService;

    @Transactional
    @DeleteMapping("/deletecadre/{id}")
    public void deleteById(Long id) {
        cadreService.deleteById(id);
    }

    @PutMapping("/updatecadre/{id}")
    public int updateCadre(@PathVariable Long id, @RequestBody Cadre cadre) {
        return cadreService.updateCadre(id, cadre);
    }

    @GetMapping("/cadres")
    public List<Cadre> findAll() {
        return cadreService.findAll();
    }

    @PostMapping("/addcadre/{missionId}")
    public int addMissionStage(@Valid @PathVariable Long missionId, @RequestBody Cadre cadre) {
        return cadreService.addCadreMission(missionId, cadre);
    }
}
