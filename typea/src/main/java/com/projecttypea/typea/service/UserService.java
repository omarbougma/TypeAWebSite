package com.projecttypea.typea.service;

import java.util.List;

import javax.servlet.http.HttpSession;
import com.projecttypea.typea.bean.User;
import com.projecttypea.typea.dao.UserDao;
import com.projecttypea.typea.security.config.PasswordConfig;
import com.projecttypea.typea.security.enums.UserRoles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    @Autowired
    PasswordConfig encoder;

    public User findByNom(String name) {
        return userDao.findByNom(name);
    }

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
        try {
            if (userDao.findByEmail(utilisateur.getEmail()) != null) {
                return -1;
            } else if (!utilisateur.getEmail().matches("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@uca.ma$")) {
                return -2;
            } else {
                utilisateur.setPassword(encoder.passwordEncoder().encode(utilisateur.getPassword()));
                utilisateur.setUserRole(UserRoles.USER);
                userDao.save(utilisateur);
                return 1;
            }
        } catch (NullPointerException e) {
            return -3;
        }
    }

    public int loginUser(User user, HttpSession session) {
        try {
            String mail = user.getEmail();
            String pass = user.getPassword();
            User dbUser = findByEmail(mail);
            Boolean isUser = encoder.passwordEncoder().matches(pass, dbUser.getPassword());
            if (mail == "" || pass == "") {
                return -1;
            } else if (dbUser == null || !isUser) {
                return -2;
            } else {
                session.setAttribute("session", user.getEmail());
                return 1;
            }
        } catch (NullPointerException e) {
            return -3;
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

    public User getById(Long id) {
        return userDao.getById(id);
    }

    public boolean isAdmin(String mail) {
        User dbUser = findByEmail(mail);
        if (dbUser.getUserRole() == UserRoles.ADMIN) {
            return true;
        } else {
            return false;
        }
    }

}
