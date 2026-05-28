package edu.RL.carrental.service;

import edu.RL.carrental.entity.UserEntity;

import java.util.List;

public interface UserService {
     UserEntity saveUser(UserEntity user);

     UserEntity loginUser(String email, String password);

     List<UserEntity> getAllUsers();
}
