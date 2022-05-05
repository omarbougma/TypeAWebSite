package com.projecttypea.typea.bean;

import java.util.List;

public class Demande {

    private List<Manifestation> maniL;
    private List<MissionStage> stageL;

    public List<Manifestation> getManiL() {
        return maniL;
    }

    public void setManiL(List<Manifestation> maniL) {
        this.maniL = maniL;
    }

    public List<MissionStage> getStageL() {
        return stageL;
    }

    public void setStageL(List<MissionStage> stageL) {
        this.stageL = stageL;
    }

    public Demande() {
    }

    public Demande(List<Manifestation> maniL, List<MissionStage> stageL) {
        this.maniL = maniL;
        this.stageL = stageL;
    }

}
