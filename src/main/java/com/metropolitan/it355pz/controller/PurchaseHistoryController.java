package com.metropolitan.it355pz.controller;

import com.metropolitan.it355pz.dto.PurchaseHistoryDTO;
import com.metropolitan.it355pz.entity.PurchaseHistory;
import com.metropolitan.it355pz.service.ComponentService;
import com.metropolitan.it355pz.service.ComputerService;
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
    private final ComputerService computerService;
    private final ComponentService componentService;

    @GetMapping
    public ResponseEntity<List<PurchaseHistory>> getAll(){
        //System.out.println(purchaseHistoryService.findAll());
        return ResponseEntity.ok(purchaseHistoryService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PurchaseHistory> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(purchaseHistoryService.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Purchase history not found!"))
        );
    }

    @GetMapping("/userId")
    public ResponseEntity<List<PurchaseHistory>> getByUserId(@RequestParam Integer userId) {
        return ResponseEntity.ok(purchaseHistoryService.findAllByUserId(userId));
    }

    @PostMapping
    public ResponseEntity<PurchaseHistory> save(@RequestBody PurchaseHistoryDTO purchaseHistoryDTO){
        System.out.println(purchaseHistoryDTO);
        PurchaseHistory purchaseHistoryPom = new PurchaseHistory();
        purchaseHistoryPom.setUserId(purchaseHistoryDTO.getUserId());
        if(purchaseHistoryDTO.getComputerId() != null) {
            purchaseHistoryPom.setComputer(computerService.findById(purchaseHistoryDTO.getComputerId()).get());
        }
        if(purchaseHistoryDTO.getComponentId() != null){
            purchaseHistoryPom.setComponent(componentService.findById(purchaseHistoryDTO.getComponentId()).get());
        }
        purchaseHistoryPom.setQuantity(purchaseHistoryDTO.getQuantity());
        purchaseHistoryPom.setPurchaseDate(purchaseHistoryDTO.getPurchaseDate());
        purchaseHistoryPom.setTotalPrice(purchaseHistoryDTO.getTotalPrice());
        System.out.println(purchaseHistoryPom);
        return ResponseEntity.ok(purchaseHistoryService.save(purchaseHistoryPom));
    }

//    @PostMapping
//    public ResponseEntity<PurchaseHistory> save(@RequestBody PurchaseHistory purchaseHistory){
//        System.out.println(purchaseHistory);
//        return ResponseEntity.ok(purchaseHistoryService.save(purchaseHistory));
//    }

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
