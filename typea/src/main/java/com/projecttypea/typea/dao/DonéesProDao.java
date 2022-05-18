package com.projecttypea.typea.dao;

import com.projecttypea.typea.bean.DonéesPro;

import com.projecttypea.typea.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonéesProDao extends JpaRepository<DonéesPro, Long> {
    DonéesPro findByUser(User user);

}
