package com.ey.ms.learning_concept.service.impl;

import com.ey.ms.learning_concept.data.User;
import com.ey.ms.learning_concept.respository.UserRepository;
import com.ey.ms.learning_concept.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User addUser(User user) {
         return userRepository.save(user);
    }

    @Override
    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    @Override
    public User updateUser(Long id, User user) {
       Optional<User> existingUser=userRepository.findById(id);
        if(existingUser.isPresent()){
            User userToBeUpdated=existingUser.get();
            userToBeUpdated.setName(user.getName());
            userToBeUpdated.setRole(user.getRole());
            userToBeUpdated.setUsername(user.getUsername());
            return userToBeUpdated;
        }else return null;
    }
}
