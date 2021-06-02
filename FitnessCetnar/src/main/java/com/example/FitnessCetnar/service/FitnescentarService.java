package com.example.FitnessCetnar.service;

import com.example.FitnessCetnar.entity.FitnessCentar;
import com.example.FitnessCetnar.repository.FitnescentarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FitnescentarService {
    @Autowired
    private FitnescentarRepository fitnescentarRepository;


    public FitnessCentar findOne(Long id){
        FitnessCentar fitnessCentar=this.fitnescentarRepository.findById(id).get();
        return fitnessCentar;
    }
    public List<FitnessCentar> findAll(){
        List<FitnessCentar>fitnessCentars=this.fitnescentarRepository.findAll();
        return fitnessCentars;
    }

    public FitnessCentar save(FitnessCentar fitnessCentar){return this.fitnescentarRepository.save(fitnessCentar);}
    public void editFitnescentar(FitnessCentar fitnessCentar){this.fitnescentarRepository.updateFitnescentar(fitnessCentar.getId(),fitnessCentar.getNaziv(),fitnessCentar.getAdresa());}
    public void deleteFitnescentar(Long id){
        this.fitnescentarRepository.deleteById(id);

    }

}
