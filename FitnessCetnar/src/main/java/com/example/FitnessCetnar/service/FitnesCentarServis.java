package com.example.FitnessCetnar.service;

import com.example.FitnessCetnar.entity.FitnessCentar;
import com.example.FitnessCetnar.repository.FitnesCentarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FitnesCentarServis {
    @Autowired
    private FitnesCentarRepository fitnesCentarRepository;

    public FitnessCentar findOne(Long id){
        FitnessCentar fitnessCentar = this.fitnesCentarRepository.findById(id).get();
        return fitnessCentar;
    }

    public List<FitnessCentar> findAll(){
        List<FitnessCentar> fitnessCentars = this.fitnesCentarRepository.findAll();
        return fitnessCentars;
    }

    public FitnessCentar save(FitnessCentar fitnessCentar){return this.fitnesCentarRepository.save(fitnessCentar);}
    public void editFitnesCentar(FitnessCentar fitnessCentar){this.fitnesCentarRepository.updateFitnesCentar(fitnessCentar.getId(),fitnessCentar.getNaziv());}
    public boolean deleteById(Long fitness_centar_id){
        try{
            FitnessCentar fitnessCentar = this.fitnesCentarRepository.findById(fitness_centar_id).get();
            this.fitnesCentarRepository.deleteById(fitness_centar_id);
            return true;
        }catch (Exception e){
            return false;
        }

    }

}
