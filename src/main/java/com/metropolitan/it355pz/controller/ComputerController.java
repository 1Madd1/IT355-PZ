package com.metropolitan.it355pz.controller;


import com.metropolitan.it355pz.entity.Component;
import com.metropolitan.it355pz.entity.Computer;
import com.metropolitan.it355pz.entity.User;
import com.metropolitan.it355pz.service.ComputerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/computer")
@RequiredArgsConstructor
public class ComputerController {

    private final ComputerService computerService;

    @GetMapping
    public ResponseEntity<List<Computer>> getAll(){
        return ResponseEntity.ok(computerService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Computer> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(computerService.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Computer not found!"))
        );
    }

    @GetMapping("/findAllNonEmpty")
    public ResponseEntity<List<Computer>> getAllByQuantityGreaterThan() {
        return ResponseEntity.ok(computerService.findAllByQuantityGreaterThan0());
    }

    @PostMapping
    public ResponseEntity<Computer> save(@RequestBody Computer computer){
        return ResponseEntity.ok(computerService.save(computer));
    }

    @PutMapping
    public ResponseEntity<Computer> update(@RequestBody Computer computer){
        return ResponseEntity.ok(computerService.update(computer));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Computer> deleteById(@PathVariable Integer id){
        computerService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
