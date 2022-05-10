package com.projecttypea.typea.ws;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import com.projecttypea.typea.bean.DonéesPro;
import com.projecttypea.typea.service.DonéesProService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/donneproapi")
@RestController
public class DonéesProWS {

    @Autowired
    DonéesProService donéesProService;

    @PutMapping("/user/updatedonnes/{id}")
    public int updateCadre(@PathVariable Long id, @RequestBody DonéesPro donnePro, HttpSession session) {
        return donéesProService.updateDonesPro(id, donnePro);
    }

    @Transactional
    @DeleteMapping("/deletedonnes/{id}")
    public void deleteById(@PathVariable Long id) {
        donéesProService.deleteById(id);
    }

    @GetMapping("/donnéespro")
    public List<DonéesPro> findAll() {
        return donéesProService.findAll();
    }

    @PostMapping("/user/adddonéespro")
    public int addDonesPro(@RequestBody DonéesPro donne, HttpSession session) {
        if (session != null) {
            return donéesProService.addDonesPro(donne);
        } else {
            return -2;
        }
    }

}