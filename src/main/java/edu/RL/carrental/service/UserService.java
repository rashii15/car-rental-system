package edu.RL.carrental.service;

import edu.RL.carrental.entity.UserEntity;

public interface UserService {
     UserEntity saveUser(UserEntity user);

     UserEntity loginUser(String email, String password);
}
