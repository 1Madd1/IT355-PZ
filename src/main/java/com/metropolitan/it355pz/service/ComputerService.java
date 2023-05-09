package com.metropolitan.it355pz.service;

import com.metropolitan.it355pz.entity.Computer;
import java.util.List;
import java.util.Optional;

public interface ComputerService {
    List<Computer> findAll();

//    Optional<Author> findByAuthorName(String authorName);
//    List<Author> findByAuthorNameContainingIgnoreCase(String str);
//    Integer countByAuthorNameEndingWith(String name);

    Optional<Computer> findById(Integer id);

    Computer save(Computer computer);

    Computer update(Computer computer);

    void deleteById(Integer id);
}
