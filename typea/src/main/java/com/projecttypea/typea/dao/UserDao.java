package com.projecttypea.typea.dao;

import com.projecttypea.typea.bean.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
    User findByEmail(String email);

    int deleteByEmail(String email);

    User findByEmailAndPassword(String email, String password);
}
