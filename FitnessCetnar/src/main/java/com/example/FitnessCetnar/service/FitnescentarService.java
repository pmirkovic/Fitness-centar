package com.example.FitnessCetnar.service;

import com.example.FitnessCetnar.entity.FitnessCentar;
import com.example.FitnessCetnar.entity.Korisnik;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FitnescentarService {

    FitnessCentar findOne(Long id);

    List<FitnessCentar> findAll();

    FitnessCentar create(FitnessCentar fc) throws Exception;

    FitnessCentar update(FitnessCentar fc) throws Exception;

    void delete(Long id);

    public FitnessCentar save(FitnessCentar fitnessCentar) throws Exception;
}
