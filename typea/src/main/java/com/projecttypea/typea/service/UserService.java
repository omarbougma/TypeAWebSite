package com.projecttypea.typea.service;

import java.util.List;

import com.projecttypea.typea.bean.User;
import com.projecttypea.typea.dao.UserDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public User findByEmail(String email) {
        return userDao.findByEmail(email);
    }

    public int deleteByEmail(String email) {
        return userDao.deleteByEmail(email);
    }

    public List<User> findAll() {
        return userDao.findAll();
    }

    public int addUser(User utilisateur) {
        if (userDao.findByEmail(utilisateur.getEmail()) != null) {
            return -1;
        } else {
            userDao.save(utilisateur);
            return 1;
        }
    }

    public int updateUser(Long id, User user) {
        User currentUser = userDao.getById(id);
        if (currentUser == null) {
            return -1;
        } else {
            currentUser.setNom(user.getNom());
            currentUser.setEmail(user.getEmail());
            currentUser.setPrenom(user.getPrenom());
            currentUser.setPassword(user.getPassword());
            currentUser.setTelephone(user.getTelephone());
            userDao.save(currentUser);
            return 1;
        }
    }
}
