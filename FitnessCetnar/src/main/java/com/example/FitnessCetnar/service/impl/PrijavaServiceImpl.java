package com.example.FitnessCetnar.service.impl;

import com.example.FitnessCetnar.entity.Prijava;
import com.example.FitnessCetnar.repository.PrijavaRepository;
import com.example.FitnessCetnar.service.PrijavaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrijavaServiceImpl implements PrijavaService {
    @Autowired
    PrijavaRepository prijavaRepository;
    @Override
    public Prijava save(Prijava prijava) {
        return prijavaRepository.save(prijava);
    }
}
