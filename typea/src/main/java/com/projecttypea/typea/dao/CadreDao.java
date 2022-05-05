package com.projecttypea.typea.dao;

import com.projecttypea.typea.bean.Cadre;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CadreDao extends JpaRepository<Cadre, Long> {

}
