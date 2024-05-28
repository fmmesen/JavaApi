package com.DemoITSMAPI.ITSMAPI.controllers;


import com.DemoITSMAPI.ITSMAPI.models.UserModel;
import com.DemoITSMAPI.ITSMAPI.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ArrayList<UserModel> getUsers() {
        return this.userService.getUsers();
    }

    @PostMapping
    public UserModel postUser(@RequestBody UserModel user) {
        return this.userService.postUser(user);
    }

    @GetMapping(path = "/{id}")
    public Optional<UserModel> getUserById(@PathVariable String id) {
        return this.userService.getUserById(id);
    }

    @PutMapping(path = "/{id}")
    public UserModel updateUserById(@PathVariable String id, @RequestBody UserModel newUser) {
        return this.userService.updateById(newUser, id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteUserById(@PathVariable String id) {
        boolean ok = this.userService.deleteById(id);

        if (ok){
            return "User with the id " + id + " deleted successfully";
        }else{
            return "User could not be deleted";
        }
    }

}
