package com.metropolitan.it355pz.service;

import com.metropolitan.it355pz.entity.Component;
import java.util.List;
import java.util.Optional;

public interface ComponentService {
    List<Component> findAll();

//    Optional<Author> findByAuthorName(String authorName);
//    List<Author> findByAuthorNameContainingIgnoreCase(String str);
//    Integer countByAuthorNameEndingWith(String name);

    Optional<Component> findById(Integer id);

    Component save(Component component);

    Component update(Component component);

    void deleteById(Integer id);
}
