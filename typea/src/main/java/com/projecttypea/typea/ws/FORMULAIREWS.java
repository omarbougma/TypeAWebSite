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

    @GetMapping("/admin/raportlettremission/{id}")
    public String exportLettremission(@PathVariable long id) throws FileNotFoundException, JRException {
        return formulairee.exportLettremission(id);
    }

    @GetMapping("/user/raportmission/{id}")
    public String exportReportMission(@PathVariable long id) throws FileNotFoundException, JRException {
        return formulairee.exportReportMission(id);
    }

    @GetMapping("/admin/raportlettremanif/{id}")
    public String exportLettremanif(@PathVariable long id) throws FileNotFoundException, JRException {
        return formulairee.exportLettremanif(id);
    }
    @GetMapping("/admin/raportNVmontantmanif/{id}")
    public String exportNvmontantmanif(long id) throws FileNotFoundException, JRException {
        return formulairee.exportNvmontantmanif(id);
    }
    @GetMapping("/admin/raportNvmontantmis/{id}")
    public String exportNvmontantmission(long id) throws FileNotFoundException, JRException {
        return formulairee.exportNvmontantmission(id);
    }

    @Autowired
    private formulaire formulairee;

}
