package com.example.FitnessCetnar.service;

import com.example.FitnessCetnar.entity.FitnessCentar;
import com.example.FitnessCetnar.entity.Sala;
import com.example.FitnessCetnar.repository.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaService {
   @Autowired
    private SalaRepository salaRepository;
    @Autowired
    private FitnescentarService fitnescentarService;

    public Sala findOne(Long id){
        Sala sala = this.salaRepository.findById(id).get();
        return sala;
    }
    public List<Sala> findAll(){
        List<Sala> salas = this.salaRepository.findAll();
        return salas;
    }
    public Sala save(Sala sala){return this.salaRepository.save(sala);}
    public void editSala(Sala sala){this.salaRepository.updateSala(sala.getId(),sala.getKapacitet(),sala.getOznakaSale());}
    public boolean deleteById(Long fitness_centar_id,Long sala_id){
        try {
            FitnessCentar fitnessCentar=this.fitnescentarService.findOne(fitness_centar_id);
            Sala sala=this.salaRepository.findById(sala_id).get();
            fitnessCentar.getSale().remove(sala);
            sala.getTrenings().clear();
            this.salaRepository.deleteById(sala_id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
