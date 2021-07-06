package com.example.FitnessCetnar.service.impl;

import com.example.FitnessCetnar.entity.TerminskaLista;
import com.example.FitnessCetnar.repository.TerminskaListaRepository;
import com.example.FitnessCetnar.service.TerminskaListaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TerminskaListaServiceImpl implements TerminskaListaService {
    @Autowired
    TerminskaListaRepository terminskaListaRepository;


    @Override
    public TerminskaLista save(TerminskaLista terminskaLista) {
        return terminskaListaRepository.save(terminskaLista);
    }

    @Override
    public TerminskaLista getOne(Long id) {
        return terminskaListaRepository.getOne(id);
    }
}
