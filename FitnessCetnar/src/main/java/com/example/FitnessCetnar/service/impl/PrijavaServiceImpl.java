package com.example.FitnessCetnar.service.impl;

import com.example.FitnessCetnar.entity.Prijava;
import com.example.FitnessCetnar.repository.PrijavaRepository;
import com.example.FitnessCetnar.service.PrijavaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrijavaServiceImpl implements PrijavaService {
    @Autowired
    PrijavaRepository prijavaRepository;

    public Prijava save(Prijava prijava) {
        return this.prijavaRepository.save(prijava);
    }

    @Override
    public List<Prijava> findByKorisnik_Id(Long id) {
        return prijavaRepository.findByKorisnik_Id(id);
    }

    @Override
    public void deleteById(Long id) {
        prijavaRepository.deleteById(id);
    }

    public Prijava findOne(Long id) {
        Prijava prijava = this.prijavaRepository.findById(id).get();
        return prijava;
    }
}
