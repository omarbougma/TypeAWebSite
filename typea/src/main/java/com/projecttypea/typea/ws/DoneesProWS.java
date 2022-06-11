package com.projecttypea.typea.ws;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import com.projecttypea.typea.bean.DoneesPro;
import com.projecttypea.typea.service.DoneesProService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

public class DoneesProWS {

    @Autowired
    DoneesProService doneesProService;

    /*
     * @PutMapping("/user/updatedonnes/{id}")
     * public int updateCadre(@PathVariable Long id, @RequestBody DonéesPro
     * donnePro) {
     * return donéesProService.updateDonesPro(id, donnePro);
     * }
     */


    @Transactional
    @DeleteMapping("/deletedonnes/{id}")
    public void deleteById(@PathVariable Long id) {
        doneesProService.deleteById(id);
    }


    @GetMapping("/admin/donnéespro")
    public List<DoneesPro> findAll() {
        return doneesProService.findAll();
    }

    @PostMapping("/user/adddonéespro")
    public int addDonesPro(@RequestBody DoneesPro donne, HttpSession session) {
        return doneesProService.addDonesPro(donne, session);
    }

    @PutMapping("/user/updatedonnepro")
    public int save(@RequestBody DoneesPro donne, HttpSession session) {
        return doneesProService.save(donne, session);
    }




    @GetMapping("/admin/getdonne/{id}")
    public DoneesPro findByUserId(@PathVariable Long id) {
        return doneesProService.findByUserId(id);
    }

}