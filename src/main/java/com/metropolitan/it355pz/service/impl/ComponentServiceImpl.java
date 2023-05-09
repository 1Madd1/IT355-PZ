package com.metropolitan.it355pz.service.impl;

import com.metropolitan.it355pz.entity.Component;
import com.metropolitan.it355pz.repository.ComponentRepository;
import com.metropolitan.it355pz.service.ComponentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ComponentServiceImpl implements ComponentService {

    private final ComponentRepository componentRepository;

    @Override
    public List<Component> findAll() {
        return componentRepository.findAll();
    }

    @Override
    public Optional<Component> findById(Integer id) {
        return componentRepository.findById(id);
    }

    @Override
    public Component save(Component component) {
        return componentRepository.save(component);
    }

    @Override
    public Component update(Component component) {
        return componentRepository.save(component);
    }

    @Override
    public void deleteById(Integer id) {
        componentRepository.deleteById(id);
    }
}
