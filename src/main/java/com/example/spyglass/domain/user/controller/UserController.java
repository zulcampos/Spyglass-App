
//package com.example.spyglass.domain.user.controller;

package com.example.spyglass.domain.user.controller;

import com.example.spyglass.domain.user.exceptions.UserHasBeenDeleted;
import com.example.spyglass.domain.user.exceptions.UserNotFoundException;
import com.example.spyglass.domain.user.models.User;
import com.example.spyglass.domain.user.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;






@RestController
@RequestMapping("/user")
@CrossOrigin("http://localhost:3000")
public class UserController {
    private static Logger logger = LoggerFactory.getLogger(UserController.class);
    private UserService userService;


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;

    }

    @PostMapping("/")
    public ResponseEntity<User> createUserRequest(@RequestBody User user) {
        User savedUser = userService.createUser(user);
        ResponseEntity response = new ResponseEntity<>(savedUser, HttpStatus.CREATED);
        return response;
    }

//    }
//
//    @PostMapping("")
//    public ResponseEntity<User> createUserRequest(@RequestBody User user) {
//        User savedUser = userService.createUser(user);
//        ResponseEntity response = new ResponseEntity<>(savedUser, HttpStatus.CREATED);
//        return response;
//    }
//
////        @GetMapping("")
////    public ResponseEntity<User> getUser(){
////        ResponseEntity<User> users = userService.;
////        Iterable<User> users1 = new Iterable<>(users, HttpStatus.OK);
////        return users1;
////    }
//    @GetMapping("{/id}")
//    public ResponseEntity<?> getProfileById(@PathVariable Integer id) {
//        User user;
//        try {
//            user = userService.findById(1l);
//            ResponseEntity<?> response = new ResponseEntity<>(user, HttpStatus.OK);
//            return response;
//        } catch (UserNotFoundException e) {
//            return ResponseEntity
//                    .status(HttpStatus.NOT_FOUND)
//                    .build();
//        }
//
//            }
//        @PutMapping("/{id}")
//        public ResponseEntity<?> updateProfile(@PathVariable Integer Id,@RequestBody User user){
//            try {
//                User updatedUser = userService.updateUser(user);
//                ResponseEntity response = new ResponseEntity<>(updatedUser, HttpStatus.OK);
//                return response;
//            } catch (UserNotFoundException e) {
//                return ResponseEntity
//                        .status(HttpStatus.NOT_FOUND)
//                        .build();
//            }
//    }
//        @DeleteMapping("/{id}")
//        public ResponseEntity<?> deleteProfile(Integer id){
//            try{
//                userService.deleteUser(Long.valueOf(id));
//                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//            }catch (UserHasBeenDeleted e){
//                return ResponseEntity
//                        .status(HttpStatus.NOT_FOUND)
//                        .build();
//            }
//
//        }

    @GetMapping("")
    public ResponseEntity<List<User>> getUser(){
        List<User> users = userService.getAllUsers();
        ResponseEntity<List<User>> users1 = new ResponseEntity<>(users, HttpStatus.OK);
        return users1;
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getProfileById(@PathVariable Integer id) {
        User user;
        try {
            user = userService.findById(1l);
            ResponseEntity<?> response = new ResponseEntity<>(user, HttpStatus.OK);
            return response;
        } catch (UserNotFoundException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateProfile(@PathVariable Integer Id, @RequestBody User user) {
        try {
            User updatedUser = userService.updateUser(user);
            ResponseEntity response = new ResponseEntity<>(updatedUser, HttpStatus.OK);
            return response;
        } catch (UserNotFoundException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteProfile(Integer id) throws UserHasBeenDeleted {
        userService.deleteUser(Long.valueOf(id));
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

}



//+UserController()
//        -Static: Logger
//        GetMapping
//        -getuser
//        GetMapping
//        -getUserById()
//        PutMapping
//        -updateUser()
//        PostMapping
//        -createUser()
