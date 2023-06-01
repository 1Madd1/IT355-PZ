package com.metropolitan.it355pz.service.impl;

import com.metropolitan.it355pz.entity.Component;
import com.metropolitan.it355pz.entity.PurchaseHistory;
import com.metropolitan.it355pz.repository.ComponentRepository;
import com.metropolitan.it355pz.repository.PurchaseHistoryRepository;
import com.metropolitan.it355pz.service.ComponentService;
import com.metropolitan.it355pz.service.PurchaseHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PurchaseHistoryImpl implements PurchaseHistoryService {

    private final PurchaseHistoryRepository purchaseHistoryRepository;

    @Override
    public List<PurchaseHistory> findAll() {
        return purchaseHistoryRepository.findAll();
    }

    @Override
    public Optional<PurchaseHistory> findById(Integer id) {
        return purchaseHistoryRepository.findById(id);
    }

    @Override
    public PurchaseHistory save(PurchaseHistory purchaseHistory) {
        return purchaseHistoryRepository.save(purchaseHistory);
    }

    @Override
    public PurchaseHistory update(PurchaseHistory purchaseHistory) {
        return purchaseHistoryRepository.save(purchaseHistory);
    }

    @Override
    public void deleteById(Integer id) {
        purchaseHistoryRepository.deleteById(id);
    }
}
