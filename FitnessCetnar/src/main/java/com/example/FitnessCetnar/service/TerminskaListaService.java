package com.example.FitnessCetnar.service;

import com.example.FitnessCetnar.entity.TerminskaLista;

public interface TerminskaListaService {

    TerminskaLista save(TerminskaLista terminskaLista);

    TerminskaLista getOne(Long id);
}
