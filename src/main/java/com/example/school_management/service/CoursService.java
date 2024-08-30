package com.example.school_management.service;

import com.example.school_management.model.Cours;
import com.example.school_management.repository.CoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CoursService {

    @Autowired
    private CoursRepository coursRepository;

    public Page<Cours> getAllCours(Pageable pageable) {
        return coursRepository.findAll(pageable);
    }

    public Cours getCoursById(Long id) {
        return coursRepository.findById(id).orElse(null);
    }

    public Cours createOrUpdateCours(Cours cours) {
        return coursRepository.save(cours);
    }

    public void deleteCours(Long id) {
        coursRepository.deleteById(id);
    }
}
