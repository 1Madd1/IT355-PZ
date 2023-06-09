package com.metropolitan.it355pz.repository;

import com.metropolitan.it355pz.entity.Component;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ComponentRepository extends JpaRepository<Component, Integer> {
    @Query("SELECT c FROM Component c WHERE c.quantity > 0")
    List<Component> findAllByQuantityGreaterThan0();
}
