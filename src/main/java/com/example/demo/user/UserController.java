package com.example.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
//@RequestMapping("/users")
//@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")

public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }



    @GetMapping("/users")
    public List<User> index() {
        return userService.index();
    }

//    @GetMapping("/users")
//    public List<User> getUsers() {
//        return userService.findAll();
//    }


    @GetMapping("/users/{userid}")
    public ResponseEntity<User> show(@PathVariable Long userid) {
        return new ResponseEntity<>(userService.show(userid), HttpStatus.OK);
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public ResponseEntity<User> create(@RequestBody User user) {
        return new ResponseEntity<>(userService.create(user), HttpStatus.CREATED);
    }


    @RequestMapping(value = "/users/{userid}", method = RequestMethod.PUT)
    public ResponseEntity<User> update(@PathVariable Long userid, @RequestBody User user) {
        return new ResponseEntity<>(userService.update(userid, user), HttpStatus.OK);
    }


    @RequestMapping(value = "/users/{userid}", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> delete(@PathVariable Long userid) {
        return new ResponseEntity<>(userService.delete(userid), HttpStatus.OK);
    }


}
