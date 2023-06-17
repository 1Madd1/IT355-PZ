package com.metropolitan.it355pz.repository;

import com.metropolitan.it355pz.entity.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CreditCardRepository extends JpaRepository<CreditCard, Integer> {
    Optional<CreditCard> findByCardNumber(String cardNumber);

    Optional<CreditCard> findByUserId(Integer id);

}
