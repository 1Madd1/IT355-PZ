package com.metropolitan.it355pz.service.impl;

import com.metropolitan.it355pz.entity.CreditCard;
import com.metropolitan.it355pz.repository.CreditCardRepository;
import com.metropolitan.it355pz.service.CreditCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CreditCardServiceImpl implements CreditCardService {

    private final CreditCardRepository creditCardRepository;

    @Override
    public List<CreditCard> findAll() {
        return creditCardRepository.findAll();
    }

    @Override
    public Optional<CreditCard> findById(Integer id) {
        return creditCardRepository.findById(id);
    }

    @Override
    public Optional<CreditCard> findByCardNumber(String cardNumber) {
        return creditCardRepository.findByCardNumber(cardNumber);
    }

    @Override
    public CreditCard save(CreditCard creditCard) {
        return creditCardRepository.save(creditCard);
    }

    @Override
    public CreditCard update(CreditCard creditCard) {
        return creditCardRepository.save(creditCard);
    }

    @Override
    public void deleteById(Integer id) {
        creditCardRepository.deleteById(id);
    }
}
