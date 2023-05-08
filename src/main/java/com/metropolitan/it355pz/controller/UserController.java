package com.metropolitan.it355pz.controller;


import com.metropolitan.it355pz.entity.User;
import com.metropolitan.it355pz.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAll(){
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(userService.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found!"))
        );
    }

//    @GetMapping("/name")
//    public ResponseEntity<Optional<Author>> findByAuthorName(@RequestParam String name){
//        return ResponseEntity.ok(authorService.findByAuthorName(name));
//    }
//
//    @GetMapping("/name2")
//    public ResponseEntity<List<Author>> findByAuthorNameContainingIgnoreCase(@RequestParam String name){
//        return ResponseEntity.ok(authorService.findByAuthorNameContainingIgnoreCase(name));
//    }
//
//    @GetMapping("/count")
//    public ResponseEntity<Integer> countByAuthorNameEndingWith(@RequestParam String name){
//        return ResponseEntity.ok(authorService.countByAuthorNameEndingWith(name));
//    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody User author){
        return ResponseEntity.ok(userService.save(author));
    }

    @PutMapping
    public ResponseEntity<User> update(@RequestBody User author){
        return ResponseEntity.ok(userService.update(author));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteById(@PathVariable Integer id){
        userService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
