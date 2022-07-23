package com.example.springmongodb.controller;

import com.example.springmongodb.entity.User;
import com.example.springmongodb.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author "Husniddin Ulachov"
 * @created 5:06 PM on 7/23/2022
 * @project spring-mongodb
 */

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserRepository userRepository;
    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User user){
        User insert = userRepository.insert(user);
        return ResponseEntity.ok().body(insert);
    }
    @GetMapping
    public ResponseEntity<?> getAll(){
          return ResponseEntity.ok(userRepository.findAll());
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> edit(@RequestBody User user,@PathVariable  String id){
        User user1 = userRepository.findById(id).get();
        user1.setFullName(user.getFullName());
        return ResponseEntity.ok(userRepository.save(user1));
    }
    @GetMapping("/{fullName}")
    public ResponseEntity<?> findByFullName(@PathVariable String fullName){
        User user = userRepository.findByFullNameContainingIgnoreCase(fullName);
        return ResponseEntity.ok(user);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(String id){
        userRepository.deleteById(id);
        return ResponseEntity.ok("Remove Successfully");
    }



}
