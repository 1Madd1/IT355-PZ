package com.metropolitan.it355pz.service;


import com.metropolitan.it355pz.entity.CreditCard;
import java.util.List;
import java.util.Optional;

public interface CreditCardService {
    List<CreditCard> findAll();

//    Optional<Author> findByAuthorName(String authorName);
//    List<Author> findByAuthorNameContainingIgnoreCase(String str);
//    Integer countByAuthorNameEndingWith(String name);

    Optional<CreditCard> findById(Integer id);

    Optional<CreditCard> findByCardNumber(String cardNumber);

    CreditCard save(CreditCard creditCard);

    CreditCard update(CreditCard creditCard);

    void deleteById(Integer id);
}
