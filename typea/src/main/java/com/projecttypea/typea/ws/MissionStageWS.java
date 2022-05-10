package com.projecttypea.typea.ws;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import com.projecttypea.typea.bean.MissionStage;
import com.projecttypea.typea.service.MissionStageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/missionapi")
@RestController

public class MissionStageWS {
    @Autowired
    MissionStageService missionStageService;

    public List<MissionStage> findAllById(Iterable<Long> ids) {
        return missionStageService.findAllById(ids);
    }

    @Transactional
    @DeleteMapping("/deletemission/{id}")
    public void deleteById(Long id) {
        missionStageService.deleteById(id);
    }

    @PutMapping("/user/updatemission/{id}")
    public int updateMissionStage(Long id, MissionStage missionStage) {
        return missionStageService.updateMissionStage(id, missionStage);
    }

    @GetMapping("/admin/missions")
    public List<MissionStage> findAll() {
        return missionStageService.findAll();
    }

    @PostMapping("/user/addmission")
    public int addMissionStage(@RequestBody MissionStage mission, HttpSession session) {
        return missionStageService.addMissionStage(mission);
    }

}