package com.DemoITSMAPI.ITSMAPI.services;

import com.DemoITSMAPI.ITSMAPI.models.UserModel;
import com.DemoITSMAPI.ITSMAPI.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public ArrayList<UserModel> getUsers(){
        return (ArrayList<UserModel>) userRepository.findAll();
    }

    public UserModel postUser(UserModel user){
        return userRepository.save(user);
    }

    public Optional<UserModel> getUserById(Long id){
        return userRepository.findById(id);
    }

    public UserModel updateById(UserModel newUser, Long id){
        UserModel user = userRepository.findById(id).get();

        user.setUsername(newUser.getUsername());
        user.setFirstName(newUser.getFirstName());
        user.setLastName(newUser.getLastName());
        user.setEmail(newUser.getEmail());
        user.setActive(newUser.isActive());
        user.setTitle(newUser.getTitle());
        user.setDepartment(newUser.getDepartment());

        return user;
    }

    public boolean deleteById(Long id){
        try{
            userRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
