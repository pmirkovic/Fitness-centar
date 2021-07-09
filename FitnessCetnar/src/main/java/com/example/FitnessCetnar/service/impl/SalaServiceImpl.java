package com.example.FitnessCetnar.service.impl;

import com.example.FitnessCetnar.entity.FitnessCentar;
import com.example.FitnessCetnar.entity.Sala;
import com.example.FitnessCetnar.repository.FitnescentarRepository;
import com.example.FitnessCetnar.repository.SalaRepository;
import com.example.FitnessCetnar.service.SalaService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SalaServiceImpl implements SalaService {
    private  final SalaRepository salaRepository;


    public SalaServiceImpl(SalaRepository salaRepository){this.salaRepository=salaRepository;}

    @Override
    public Sala findOne(Long id){
        Sala sala = this.salaRepository.getOne(id);
        return sala;
    }

    @Override
    public List<Sala> findAll() {
        List<Sala> salaList = this.salaRepository.findAll();
        return salaList;
    }

    @Override
    public Sala create(Sala sala) throws Exception{
        if(sala.getId() != null) {
            throw new Exception("ID must be null!");
        }
        Sala newSala = this.salaRepository.save(sala);
        return newSala;
    }

    public void editSala(Sala sala) {
        this.salaRepository.updateSala(sala.getId(),sala.getKapacitet(),sala.getOznakaSale());
    }

    @Override
    public Sala update(Sala sala) throws Exception{
        Sala sala1 = this.salaRepository.getOne(sala.getId());
        if(sala1 == null){
            throw new Exception("FitnesCentar doesn't exist!");
        }
        sala1.setKapacitet(sala.getKapacitet());

        Sala savedS = this.salaRepository.save(sala1);
        return savedS;
    }

    public Sala save(Sala sala) {

        return this.salaRepository.save(sala);
    }

    @Override
    public void delete(Long id){
        this.salaRepository.deleteById(id);}
}
