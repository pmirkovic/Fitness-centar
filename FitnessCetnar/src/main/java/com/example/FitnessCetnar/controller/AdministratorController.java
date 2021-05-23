package com.example.FitnessCetnar.controller;

import com.example.FitnessCetnar.entity.FitnessCentar;
import com.example.FitnessCetnar.service.AdministratorServis;
import com.example.FitnessCetnar.service.FitnesCentarServis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AdministratorController {

    @Autowired
    private AdministratorServis administratorServis;

    @Autowired
    private FitnesCentarServis fitnesCentarServis;


    @PostMapping("/add_fitnesCentar")
    public ResponseEntity<?> add_fitnesCentar(FitnessCentar fitnessCentar){
        try{
            administratorServis.addFitnesCentar(fitnessCentar);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @PutMapping("edit_fitnesCentar")
    public ResponseEntity<?> edit_fitnesCentar(FitnessCentar fitnessCentar){
        try{
            this.administratorServis.editFitnesCentar(fitnessCentar);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete_fitnesCentar/{fitness_centar_id}")
    public ResponseEntity<?> delete_fitnesCentar(@PathVariable(name = "fitness_centar_id") Long fitness_centar_id){
        try{
            if(this.fitnesCentarServis.deleteById(fitness_centar_id))
                return  new ResponseEntity<>(HttpStatus.OK);
            else
                return new ResponseEntity<>(HttpStatus.CONFLICT);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
