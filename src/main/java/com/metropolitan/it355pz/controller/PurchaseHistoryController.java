package com.metropolitan.it355pz.controller;


import com.metropolitan.it355pz.entity.Component;
import com.metropolitan.it355pz.entity.PurchaseHistory;
import com.metropolitan.it355pz.service.ComponentService;
import com.metropolitan.it355pz.service.PurchaseHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Controller
@RequestMapping("/purchaseHistory")
@RequiredArgsConstructor
public class PurchaseHistoryController {

    private final PurchaseHistoryService purchaseHistoryService;

    @GetMapping
    public ResponseEntity<List<PurchaseHistory>> getAll(){
        return ResponseEntity.ok(purchaseHistoryService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PurchaseHistory> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(purchaseHistoryService.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Purchase history not found!"))
        );
    }

    @PostMapping
    public ResponseEntity<PurchaseHistory> save(@RequestBody PurchaseHistory purchaseHistory){
        return ResponseEntity.ok(purchaseHistoryService.save(purchaseHistory));
    }

    @PutMapping
    public ResponseEntity<PurchaseHistory> update(@RequestBody PurchaseHistory purchaseHistory){
        return ResponseEntity.ok(purchaseHistoryService.update(purchaseHistory));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PurchaseHistory> deleteById(@PathVariable Integer id){
        purchaseHistoryService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
