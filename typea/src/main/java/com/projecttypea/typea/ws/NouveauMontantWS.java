package com.projecttypea.typea.ws;

import com.projecttypea.typea.bean.NouveauMontant;
import com.projecttypea.typea.service.NouveauMontantService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NouveauMontantWS {
    @Autowired
    NouveauMontantService nouveauMontantService;

    @PostMapping("/admin/addnewmontantMS/{mStageId}")
    public int addMontantsMS(@PathVariable Long mStageId, @RequestBody NouveauMontant nvMontant) {
        return nouveauMontantService.addMontantsMS(mStageId, nvMontant);
    }

    @PostMapping("/admin/addnewmontant/{manifId}")
    public int addMontantsM(@PathVariable Long manifId, @RequestBody NouveauMontant nvMontant) {
        return nouveauMontantService.addMontantsM(manifId, nvMontant);
    }

}
