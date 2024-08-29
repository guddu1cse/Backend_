package com.backend.backendApp.Controller;

import com.backend.backendApp.Entity.User;
import com.backend.backendApp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<String> login(){
        return new ResponseEntity<>("longed in Successfully" , HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUser(){
        return new ResponseEntity<>( userService.getUsers(), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid @RequestBody User user){
        userService.createUser(user);
        return new ResponseEntity<>("user is created " , HttpStatus.OK);
    }

    @GetMapping("/user/{userName}")
    public ResponseEntity<User> getUserByUserName(@PathVariable String userName){
        return new ResponseEntity<>(userService.getByUserName(userName) , HttpStatus.OK);
    }

//    @PreAuthorize("hasRole('ROLE_USER')")
//    @GetMapping("/normal_user")
//    public ResponseEntity<String> normalUser(){
//        return new ResponseEntity<>("i am normal user !" , HttpStatus.OK);
//    }
//
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
//    @GetMapping("/user_admin")
//    public ResponseEntity<String> adminUser(){
//        return new ResponseEntity<>("i am admin user !" , HttpStatus.OK);
//    }
}
