package com.metropolitan.it355pz.service;


import com.metropolitan.it355pz.entity.CreditCard;

import java.util.List;
import java.util.Optional;

public interface CreditCardService {
    List<CreditCard> findAll();

//    Optional<Author> findByAuthorName(String authorName);
//    List<Author> findByAuthorNameContainingIgnoreCase(String str);
//    Integer countByAuthorNameEndingWith(String name);

    CreditCard findById(Integer id);

    CreditCard findByCardNumber(String cardNumber);

    CreditCard findByUserId(Integer id);

    CreditCard save(CreditCard creditCard);

    CreditCard update(CreditCard creditCard);

    void deleteById(Integer id);
}
