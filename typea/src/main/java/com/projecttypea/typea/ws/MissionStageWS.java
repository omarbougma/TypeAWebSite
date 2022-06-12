package com.projecttypea.typea.ws;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import javax.validation.Valid;

import com.projecttypea.typea.bean.*;
import com.projecttypea.typea.security.enums.DemandesState;
import com.projecttypea.typea.service.MissionStageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

public class MissionStageWS {
    @Autowired
    MissionStageService missionStageService;

    @PostMapping("/user/missionstageadd")
    public Long ajoutMissionStage(@RequestBody MissionStage mStage, HttpSession session) {
        return missionStageService.ajoutMissionStage(mStage, session);
    }

    @GetMapping("/user/missionstage/{id}")
    public Optional<MissionStage> findById(@PathVariable Long id) {
        return missionStageService.findById(id);
    }

    @Transactional
    @DeleteMapping("/deletemission/{id}")
    public void deleteById(Long id) {
        missionStageService.deleteById(id);
    }

    /*
     * @PutMapping("/user/updatemission/{id}")
     * public int updateMissionStage(Long id, MissionStage missionStage) {
     * return missionStageService.updateMissionStage(id, missionStage);
     * }
     */

    @GetMapping("/admin/missions")
    public List<MissionStage> findAll() {
        return missionStageService.findAll();
    }

    @PostMapping("/user/addmission")
    public int addMissionStage(@Valid @RequestBody MissionStage mission, HttpSession session) {
        return missionStageService.addMissionStage(mission, session);
    }

    @GetMapping("/user/getmStage")
    public List<MissionStage> findAllByUserEmail(HttpSession session) {
        return missionStageService.findAllByUserEmail(session);
    }

    @GetMapping("/admin/getmstage/{id}")
    public MissionStage getById(@PathVariable Long id) {
        return missionStageService.getById(id);
    }

    @GetMapping("/admin/theuser/{mStageId}")
    public User getCurrentUser(@PathVariable Long mStageId) {
        return missionStageService.getCurrentUser(mStageId);
    }

    @GetMapping("/admin/userdonne/{mStageId}")
    public DoneesPro getCurrentDonne(@PathVariable Long mStageId) {
        return missionStageService.getCurrentDonne(mStageId);
    }

    @GetMapping("/admin/refusestage/{missionId}")
    public int mStageRefused(@PathVariable Long missionId) {
        return missionStageService.mStageRefused(missionId);
    }


    @PostMapping("/admin/acceptstage/{missionId}")
    public int mStageAccepted(@PathVariable Long missionId, @RequestBody MailMessages params) {
        return missionStageService.mStageAccepted(missionId, params);
    }

    @GetMapping("/admin/getcadrebystage/{mStageId}")
    public Cadre getCadreByMStage(@PathVariable Long mStageId) {
        return missionStageService.getCadreByMStage(mStageId);
    }

    @GetMapping("/admin/getsoutienbystage/{mStageId}")
    public Soutien getSoutienByMStage(@PathVariable Long mStageId) {
        return missionStageService.getSoutienByMStage(mStageId);
    }

    @GetMapping("/admin/findallmstages/{state}")
    public List<MissionStage> findAllByState(@PathVariable DemandesState state) {
        return missionStageService.findAllByState(state);
    }

}