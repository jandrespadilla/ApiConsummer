package com.consumer.controller;

import com.consumer.models.User;
import com.consumer.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserControlller {
    @Autowired
    private UserService userService;

    @GetMapping(value="/", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<User>> getAllUser(){
        try {
            List<User> users = userService.getAllUser();
            return ResponseEntity.ok(users);
        }catch (IllegalArgumentException e){
            return ResponseEntity.notFound().build();
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping(value="/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<User>  getUserById(@PathVariable String id){
        try {
             User user = userService.getUserById(id);
            return ResponseEntity.ok(user);
        }catch (IllegalArgumentException e){
            return ResponseEntity.notFound().build();
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping(value="/", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<User>  adduser(@RequestBody User user){
        try {
            User createdUser = userService.addUser(user);
            return ResponseEntity.ok(createdUser);
        }catch (IllegalArgumentException e){
            return ResponseEntity.notFound().build();
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping(value = "/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<User> updateUser(@PathVariable String id, @RequestBody User user){
        try {
            user.setId(id);
            User updateUser = userService.updateUser(user);
            return ResponseEntity.ok(updateUser);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
        try {
            userService.deleteUser(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }


}
