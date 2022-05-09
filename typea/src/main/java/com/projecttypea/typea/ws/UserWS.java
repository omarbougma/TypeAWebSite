package com.projecttypea.typea.ws;

import java.util.List;

//import javax.transaction.Transactional;

import com.projecttypea.typea.bean.User;
import com.projecttypea.typea.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*", methods = { RequestMethod.POST, RequestMethod.GET,
        RequestMethod.OPTIONS })
@RequestMapping("/userapi")
@RestController

public class UserWS {

    @Autowired
    UserService userService;

    @PostMapping("/allusers/login")
    public int loginUser(@RequestBody User user, HttpSession session) {

        if (userService.loginUser(user) == 1) {
            session.setAttribute("session", user.getPassword());
            return 1;
        } else {
            return -1;
        }
    }

    @PutMapping("/user/updateuser/{id}")
    public int updateUser(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @GetMapping("/email/{email}")
    public User findByEmail(@PathVariable String email) {
        return userService.findByEmail(email);
    }

    /*
     * @Transactional
     * 
     * @DeleteMapping("/deletebymail/{email}")
     * public int deleteByEmail(@PathVariable String email) {
     * return userService.deleteByEmail(email);
     * }
     */

    @GetMapping("/admin/Users")
    public List<User> findAll() {
        return userService.findAll();
    }

    @PostMapping("/allusers/register")
    public int addUser(@RequestBody User utilisateur) {
        return userService.addUser(utilisateur);
    }

}
