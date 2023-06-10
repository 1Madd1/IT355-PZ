package com.metropolitan.it355pz.service;



import com.metropolitan.it355pz.entity.PurchaseHistory;

import java.util.List;
import java.util.Optional;

public interface PurchaseHistoryService {
    List<PurchaseHistory> findAll();

    List<PurchaseHistory> findAllByUserId(Integer id);

//    Optional<Author> findByAuthorName(String authorName);
//    List<Author> findByAuthorNameContainingIgnoreCase(String str);
//    Integer countByAuthorNameEndingWith(String name);

    Optional<PurchaseHistory> findById(Integer id);

    PurchaseHistory save(PurchaseHistory purchaseHistory);

    PurchaseHistory update(PurchaseHistory purchaseHistory);

    void deleteById(Integer id);
}
