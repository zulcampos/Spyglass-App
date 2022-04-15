package com.example.spyglass.domain.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@RequestMapping("user")
public class UserController {
    private static Logger logger;
    private final UserController userController;

    @Autowired
    public UserController(UserController userController) {
        this.userController = userController;
    }
}
//    @RequestMapping("")
//    public ResponseEntity<>
//
//}
