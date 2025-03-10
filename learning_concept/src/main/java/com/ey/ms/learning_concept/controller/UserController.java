package com.ey.ms.learning_concept.controller;

import com.ey.ms.learning_concept.data.User;
import com.ey.ms.learning_concept.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getUser/{id}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable Long id){
        Optional<User> user= userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatusCode.valueOf(user.isPresent() ? HttpStatus.OK.value() : HttpStatus.FORBIDDEN.value()));

    }

    @PostMapping("/createUser")
    public ResponseEntity<User> addUser(@RequestBody User user){
        int statusCode;
        User userToBeAdded=userService.addUser(user);
        if(userToBeAdded!=null){statusCode=HttpStatus.CREATED.value();}else{statusCode=HttpStatus.FORBIDDEN.value();}
        return new ResponseEntity<>(userToBeAdded, HttpStatusCode.valueOf(statusCode));
    }

    @DeleteMapping("/deleteUser/{id}")
    public void deleteUser(User user){
        userService.deleteUser(user);
    }

    @PutMapping("/updateUser/{id}")
    public User updateUser(@PathVariable Long id,@RequestBody User user){
        return userService.updateUser(id,user);
    }

}
