package com.metropolitan.it355pz.repository;

import com.metropolitan.it355pz.entity.PurchaseHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PurchaseHistoryRepository extends JpaRepository<PurchaseHistory, Integer> {
    List<PurchaseHistory> findAllByUserId(Integer userId);
}
