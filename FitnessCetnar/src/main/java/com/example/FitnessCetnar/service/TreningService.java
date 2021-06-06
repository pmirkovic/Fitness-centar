package com.example.FitnessCetnar.service;

import com.example.FitnessCetnar.entity.Korisnik;
import com.example.FitnessCetnar.entity.TerminskaLista;
import com.example.FitnessCetnar.entity.Trening;
import com.example.FitnessCetnar.entity.dto.TreningDTO;
import com.example.FitnessCetnar.repository.TreningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


public interface TreningService {

    Trening findOne(Long id);

    List<Trening> findAll();


    Trening create(Trening trening) throws Exception;

    Trening update(Trening trening) throws Exception;

    void delete(Long id);

}
