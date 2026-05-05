package edu.RL.carrental.controller;

import edu.RL.carrental.entity.UserEntity;
import edu.RL.carrental.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public UserEntity registerUser(@RequestBody UserEntity user) {
        return userService.saveUser(user);
    }
}
