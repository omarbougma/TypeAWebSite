package com.projecttypea.typea.ws;

import java.util.List;

import javax.transaction.Transactional;

import com.projecttypea.typea.bean.User;
import com.projecttypea.typea.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/userapi")
@RestController

public class UserWS {

    @Autowired
    UserService userService;

    @PutMapping("/updateuser/{id}")
    public int updateUser(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @GetMapping("/email/{email}")
    public User findByEmail(@PathVariable String email) {
        return userService.findByEmail(email);
    }

    @Transactional
    @DeleteMapping("/deletebymail/{email}")
    public int deleteByEmail(@PathVariable String email) {
        return userService.deleteByEmail(email);
    }

    @GetMapping("/Users")
    public List<User> findAll() {
        return userService.findAll();
    }

    @PostMapping("/adduser")
    public int addUser(@RequestBody User utilisateur) {
        return userService.addUser(utilisateur);
    }

}
