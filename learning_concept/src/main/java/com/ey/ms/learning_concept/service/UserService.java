package com.ey.ms.learning_concept.service;

import com.ey.ms.learning_concept.data.User;

import java.util.Optional;

public interface UserService {

    Optional<User> getUserById(Long id);

    User addUser(User user);

    void deleteUser(User id);

    User updateUser(Long id, User user);
}
