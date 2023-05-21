package com.metropolitan.it355pz.controller;


import com.metropolitan.it355pz.entity.CreditCard;
import com.metropolitan.it355pz.entity.User;
import com.metropolitan.it355pz.service.CreditCardService;
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
@RequestMapping("/creditCard")
@RequiredArgsConstructor
public class CreditCardController {

    private final CreditCardService creditCardService;

    @GetMapping
    public ResponseEntity<List<CreditCard>> getAll(){
        return ResponseEntity.ok(creditCardService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CreditCard> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(creditCardService.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Credit card not found!"))
        );
    }

    @GetMapping("/cardNumber")
    public ResponseEntity<Optional<CreditCard>> findByCardNumber(@RequestParam String cardNumber){
        return ResponseEntity.ok(creditCardService.findByCardNumber(cardNumber));
    }

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
    public ResponseEntity<CreditCard> save(@RequestBody CreditCard creditCard){
        return ResponseEntity.ok(creditCardService.save(creditCard));
    }

    @PutMapping
    public ResponseEntity<CreditCard> update(@RequestBody CreditCard creditCard){
        return ResponseEntity.ok(creditCardService.update(creditCard));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CreditCard> deleteById(@PathVariable Integer id){
        creditCardService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
