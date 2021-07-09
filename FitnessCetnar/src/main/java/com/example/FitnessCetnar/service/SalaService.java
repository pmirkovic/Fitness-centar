package com.example.FitnessCetnar.service;

import com.example.FitnessCetnar.entity.FitnessCentar;
import com.example.FitnessCetnar.entity.Sala;
import com.example.FitnessCetnar.repository.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SalaService {

    Sala findOne(Long id);

    List<Sala> findAll();

    Sala create(Sala sala) throws Exception;

    Sala update(Sala fc) throws Exception;

    void delete(Long id);

    Sala save(Sala sala) throws Exception;

    public void editSala(Sala sala);

}
