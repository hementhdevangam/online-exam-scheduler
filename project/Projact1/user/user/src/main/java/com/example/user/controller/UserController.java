package com.example.user.controller;

import com.example.user.model.User;
import com.example.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins="*")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }
    @GetMapping("/{id}")
    public User findUserById(@PathVariable("id") Long userId){
        return userService.findUserById(userId);
    }
    @PutMapping("/{id}")
    public User updateUserById(@PathVariable("id") Long userId,@RequestBody User user){
        Optional<User> userData = Optional.ofNullable(userService.findUserById(userId));
        if(userData.isPresent()){
            User _user = userData.get();
            _user.setEmail(user.getEmail());
            _user.setPassword(user.getPassword());
            return userService.saveUser(_user);
        }
        return userService(HttpStatus.NOT_FOUND);
    }
    private User userService(HttpStatus notFound) {
        return userService(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable("id") Long userId){
        userService.deleteUserById(userId);
    }
    @GetMapping("/")
    public List<User> getAllUsers(){

            List<User> users = new ArrayList<User>();
            return userService.getAllUsers();

    }
    @PostMapping("/signin")
    public String validateUserOne(@RequestBody User user) {
        try {
            User userData = userService.findUserByEmail(user.getEmail());
            if (user.getEmail().equals(userData.getEmail()) && user.getPassword().equals(userData.getPassword())) {

                return "Valid User";
            } else {
                return "Invalid User";
            }

        } catch (Exception ex) {
            return "Invalid User";
        }
    }

}
