package com.thales.controller;


import com.thales.dao.UserDao;
import com.thales.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    @Autowired
    private UserDao userDao;

    @GetMapping({"/", ""})
    public List<User> getAll(){
        return this.userDao.findAll();
    }


    @GetMapping({"{id}/", "{id}"})
    public User findOne(@PathVariable int id) {
        return this.userDao.findById(id).get();
    }

    @PostMapping({"/", ""})
    public void addUser(@RequestBody User user) {
        this.userDao.save(user);
    }

    @DeleteMapping({"{id}/", "{id}"})
    public void deleteUser(@PathVariable int id) {
        this.userDao.deleteById(id);
    }

    @PostMapping({"connect/", "connect"}) //modif Pat il a mis Get au lieu de Post
    public User tryConnect(@RequestBody User user) {

        User tryToConnect = this.userDao.findByLogin(user.getLogin());

        if (tryToConnect != null && !tryToConnect.getPassword().equals(user.getPassword()) ){
            tryToConnect = null;
        }
        return tryToConnect;
    }


}