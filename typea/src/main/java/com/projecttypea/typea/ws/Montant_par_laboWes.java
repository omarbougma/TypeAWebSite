package com.projecttypea.typea.ws;

import com.projecttypea.typea.bean.Montant_par_labo;
import com.projecttypea.typea.service.Montant_par_laboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Montant_par_laboWes {
    @Autowired
    private Montant_par_laboService montant_par_laboService;
@PostMapping("/admin/savethem")
    public int save(@RequestBody Montant_par_labo entity) {
        return montant_par_laboService.save(entity);
    }
    @GetMapping("/admin/getmontant_par_labo")
    public List<Montant_par_labo> findAll() {
        return montant_par_laboService.findAll();
    }
}
