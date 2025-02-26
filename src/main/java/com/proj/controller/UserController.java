package com.proj.controller;


import com.proj.entity.User;
import com.proj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/get")
    public List<User> getAllUsers() {
        return userService.getAllUser();
    }

    @GetMapping("/{id}")
    public User getUserByid(int id){
        return userService.getUserById(id);
    }

    @PostMapping("/add")
    public boolean addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @PutMapping("/{update}")
    public boolean updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("/{id}")
    public boolean deleteUser(@PathVariable("id") Long id) {
        return userService.deleteUser(id);
    }

}
