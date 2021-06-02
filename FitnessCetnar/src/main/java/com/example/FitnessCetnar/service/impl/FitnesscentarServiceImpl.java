package com.example.FitnessCetnar.service.impl;

import com.example.FitnessCetnar.entity.FitnessCentar;
import com.example.FitnessCetnar.entity.Korisnik;
import com.example.FitnessCetnar.repository.FitnescentarRepository;
import com.example.FitnessCetnar.service.FitnescentarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FitnesscentarServiceImpl implements FitnescentarService {

    private  final FitnescentarRepository fitnescentarRepository;


    public FitnesscentarServiceImpl(FitnescentarRepository fitnescentarRepository){this.fitnescentarRepository=fitnescentarRepository;}

    @Override
    public FitnessCentar findOne(Long id){
        FitnessCentar fitnessCentar = this.fitnescentarRepository.getOne(id);
        return fitnessCentar;
    }

    @Override
    public List<FitnessCentar> findAll() {
        List<FitnessCentar> fitnessCentars = this.fitnescentarRepository.findAll();
        return fitnessCentars;
    }

    @Override
    public FitnessCentar create(FitnessCentar fitnessCentar)throws Exception{
        if(fitnessCentar.getId() != null) {
            throw new Exception("ID must be null!");
        }
        FitnessCentar newFitnes = this.fitnescentarRepository.save(fitnessCentar);
        return newFitnes;
    }

    @Override
    public FitnessCentar update(FitnessCentar fitnessCentar) throws Exception{
        FitnessCentar fitneskToUpdate = this.fitnescentarRepository.getOne(fitnessCentar.getId());
        if(fitneskToUpdate == null){
            throw new Exception("FitnesCentar doesn't exist!");
        }
        fitneskToUpdate.setNaziv(fitnessCentar.getNaziv());

        FitnessCentar savedFc = this.fitnescentarRepository.save(fitneskToUpdate);
        return savedFc;
    }

    public FitnessCentar save(FitnessCentar fitnessCentar) {
        return this.fitnescentarRepository.save(fitnessCentar);
    }

    @Override
    public void delete(Long id){this.fitnescentarRepository.deleteById(id);}
}
