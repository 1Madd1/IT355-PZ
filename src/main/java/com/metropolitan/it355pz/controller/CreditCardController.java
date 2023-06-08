package com.metropolitan.it355pz.controller;



import com.metropolitan.it355pz.entity.CreditCard;
import com.metropolitan.it355pz.dto.CreditCardDTO;
import com.metropolitan.it355pz.entity.User;
import com.metropolitan.it355pz.service.CreditCardService;
import com.metropolitan.it355pz.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/creditCard")
@RequiredArgsConstructor
public class CreditCardController {

    private final CreditCardService creditCardService;
    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<CreditCard>> getAll(){
        return ResponseEntity.ok(creditCardService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CreditCard> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(creditCardService.findById(id));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<CreditCard> getByUserId(@PathVariable String userId) {
        System.out.println(userId);
        return ResponseEntity.ok(creditCardService.findByUserId(Integer.parseInt(userId)));
    }

    @GetMapping("/cardNumber")
    public ResponseEntity<CreditCard> findByCardNumber(@RequestParam String cardNumber){
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

//    @PostMapping
//    public ResponseEntity<CreditCard> save(@RequestBody CreditCard creditCard){
//        return ResponseEntity.ok(creditCardService.save(creditCard));
//    }

    @PostMapping
    public ResponseEntity<CreditCard> save(@RequestBody CreditCardDTO creditCard){
        CreditCard creditCardPom = new CreditCard();
        creditCardPom.setUser(userService.findById(creditCard.getUserId()).get());
        creditCardPom.setCardNumber(creditCard.getNumber());
        creditCardPom.setCardDate(creditCard.getDate());
        creditCardPom.setCvv2(creditCard.getCvv2());
        creditCardPom.setMoney(creditCard.getMoney());
        System.out.println(creditCardPom);
        CreditCard savedCreditCard = creditCardService.save(creditCardPom);
        return ResponseEntity.ok(savedCreditCard);
    }

    @PutMapping
    public ResponseEntity<CreditCard> update(@RequestBody CreditCard creditCard){
        System.out.println(creditCard);
        return ResponseEntity.ok(creditCardService.update(creditCard));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CreditCard> deleteById(@PathVariable Integer id){
        creditCardService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
