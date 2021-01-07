package com.project.ecommerce;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:8080")

public class UserController {
    UserRepository userRepository;

    public UserController(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    @GetMapping("/user/")
    public Iterable<User> getUser() {
        return userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") Long id) {
        return userRepository.findById(id).get();
    }

    @PostMapping("/users/")
    public HttpStatus addUser(@RequestBody User user){
        userRepository.save(user);

        return HttpStatus.CREATED;
    }
}
