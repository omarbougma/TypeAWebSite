package com.projecttypea.typea.ws;

import java.util.Map;

import com.projecttypea.typea.classes.Demande;
import com.projecttypea.typea.service.DemandeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*", methods = { RequestMethod.POST, RequestMethod.GET,
        RequestMethod.OPTIONS },allowCredentials = "true")
@RestController
public class DemandeWS {

    @Autowired
    DemandeService demandeService;

    @PostMapping("/admin/refusedemande/{id}")
    public int userRefused(@PathVariable Long id, @RequestBody Boolean isManif) {
        return demandeService.userRefused(id, isManif);
    }

    @PostMapping("/admin/refusedemande/{id}/{isManif}")
    public int userAccepted(@PathVariable Long id, @PathVariable Boolean isManif,
            @RequestBody Map<String, String> json) {
        return demandeService.userAccepted(id, isManif, json.get("toMail"), json.get("body"), json.get("subject"));
    }

    @GetMapping("/admin/addemail")
    public void sendSimpleMail(@RequestBody Map<String, String> json) {
        demandeService.sendSimpleMail(json.get("toMail"), json.get("body"), json.get("subject"));
    }

    @GetMapping("/admin/demandeslist")
    public Demande findAll() {
        return demandeService.findAll();
    }
}
