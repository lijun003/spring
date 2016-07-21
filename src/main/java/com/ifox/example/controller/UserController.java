package com.ifox.example.controller;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ifox.example.domain.User;
import com.ifox.example.repository.UserRepository;

@RestController
@EnableAutoConfiguration
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(method = GET)
    public ResponseEntity<?> findUserByUsername(@RequestParam String username) {
      return new ResponseEntity<>(userRepository.findUserByUsername(username), OK);
    }

    @RequestMapping(method = POST)
    public String create(@RequestBody User user) {
        userRepository.save(user);
        return "success";
    }
}
