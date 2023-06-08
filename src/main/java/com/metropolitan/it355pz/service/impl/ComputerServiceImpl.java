package com.metropolitan.it355pz.service.impl;

import com.metropolitan.it355pz.entity.Computer;
import com.metropolitan.it355pz.repository.ComputerRepository;
import com.metropolitan.it355pz.service.ComputerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ComputerServiceImpl implements ComputerService {

    private final ComputerRepository computerRepository;

    @Override
    public List<Computer> findAll() {
        return computerRepository.findAll();
    }

    @Override
    public List<Computer> findAllByQuantityGreaterThan0() {
        return computerRepository.findAllByQuantityGreaterThan0();
    }

    @Override
    public Optional<Computer> findById(Integer id) {
        return computerRepository.findById(id);
    }

    @Override
    public Computer save(Computer computer) {
        return computerRepository.save(computer);
    }

    @Override
    public Computer update(Computer computer) {
        return computerRepository.save(computer);
    }

    @Override
    public void deleteById(Integer id) {
        computerRepository.deleteById(id);
    }
}
