package com.example.FitnessCetnar.service;

import com.example.FitnessCetnar.entity.Prijava;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PrijavaService {

    Prijava save(Prijava prijava);
    List<Prijava> findByKorisnik_Id(Long id);
    void deleteById(Long id);
    public Prijava findOne(Long id);
}
