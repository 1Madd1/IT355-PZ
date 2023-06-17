package com.metropolitan.it355pz.controller;


import com.metropolitan.it355pz.entity.Component;
import com.metropolitan.it355pz.service.ComponentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Controller
@RequestMapping("/component")
@RequiredArgsConstructor
public class ComponentController {

    private final ComponentService componentService;

    @GetMapping
    public ResponseEntity<List<Component>> getAll(){
        return ResponseEntity.ok(componentService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Component> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(componentService.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Computer not found!"))
        );
    }

    @GetMapping("/findAllNonEmpty")
    public ResponseEntity<List<Component>> getAllByQuantityGreaterThan() {
        return ResponseEntity.ok(componentService.findAllByQuantityGreaterThan0());
    }

    @PostMapping
    public ResponseEntity<Component> save(@RequestBody Component component){
        return ResponseEntity.ok(componentService.save(component));
    }

    @PutMapping
    public ResponseEntity<Component> update(@RequestBody Component component){
        return ResponseEntity.ok(componentService.update(component));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Component> deleteById(@PathVariable Integer id){
        componentService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
