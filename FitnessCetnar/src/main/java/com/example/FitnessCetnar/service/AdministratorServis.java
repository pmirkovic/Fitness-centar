package com.example.FitnessCetnar.service;

import com.example.FitnessCetnar.entity.FitnessCentar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class AdministratorServis {

    @Autowired
    private FitnesCentarServis fitnesCentarServis;

    public void addFitnesCentar(FitnesDTO fitnesDTO){
        FitnessCentar fitnessCentar = new FitnessCentar();
        this.fitnesCentarServis.save(fitnessCentar);
    }

    public void editFitnesCentar(FitnessCentar fitnessCentar){this.fitnesCentarServis.editFitnesCentar(fitnessCentar);}
}
