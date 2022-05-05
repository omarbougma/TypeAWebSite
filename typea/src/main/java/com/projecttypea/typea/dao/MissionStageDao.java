package com.projecttypea.typea.dao;

import com.projecttypea.typea.bean.MissionStage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MissionStageDao extends JpaRepository<MissionStage, Long> {

}
