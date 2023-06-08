package com.metropolitan.it355pz.repository;

import com.metropolitan.it355pz.entity.Component;
import com.metropolitan.it355pz.entity.Computer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ComputerRepository extends JpaRepository<Computer, Integer> {
//    Optional<Author> findByAuthorName(String authorName);
//    List<Author> findByAuthorNameContainingIgnoreCase(String str);
//    Integer countByAuthorNameEndingWith(String name);

    @Query("SELECT c FROM Computer c WHERE c.quantity > 0")
    List<Computer> findAllByQuantityGreaterThan0();
}
