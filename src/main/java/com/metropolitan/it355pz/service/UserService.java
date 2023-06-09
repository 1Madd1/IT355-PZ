package com.metropolitan.it355pz.service;

import com.metropolitan.it355pz.entity.User;
import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAll();

    User findByUsername(String username);

    User findByEmail(String email);

    Optional<User> findById(Integer id);

    User save(User user);

    User update(User user);

    void deleteById(Integer id);
}
