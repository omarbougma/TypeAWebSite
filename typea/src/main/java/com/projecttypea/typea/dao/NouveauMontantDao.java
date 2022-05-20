package com.projecttypea.typea.dao;

import com.projecttypea.typea.bean.NouveauMontant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NouveauMontantDao extends JpaRepository<NouveauMontant, Long> {

    NouveauMontant findByManifestationId(Long id);
    NouveauMontant findByMissionstageId(Long id);

}
