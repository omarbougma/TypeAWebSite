package com.projecttypea.typea.ws;

import com.projecttypea.typea.service.formulaire;

import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;

@RestController

public class FORMULAIREWS {

    @GetMapping("/user/raport/{id}")
        public String generateReport(@PathVariable long id) throws FileNotFoundException, JRException {
        return formulairee.exportReport(id);
    }
    @GetMapping("/user/raportmission/{id}")
    public int exportReportMission(@PathVariable long id) throws FileNotFoundException, JRException {
        return formulairee.exportReportMission(id);
    }

    @Autowired
        private formulaire formulairee;

    }
