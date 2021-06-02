package com.example.FitnessCetnar.controller;

import com.example.FitnessCetnar.entity.FitnessCentar;
import com.example.FitnessCetnar.entity.dto.FitnescentarDTO;
import com.example.FitnessCetnar.service.FitnescentarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class FitnessCentarController {
    @Autowired
    private FitnescentarService fitnescentarService;

    @GetMapping("/fitnesscentar")
    public String welcomef(Model model){
        List<FitnessCentar> fitnessCentars = this.fitnescentarService.findAll();
        model.addAttribute("fitnessCentars",fitnessCentars);
        return "fitnesscentars.html";
    }

    @PostMapping("/add-fitnesscentar")
    public ResponseEntity<?> add(@RequestBody FitnescentarDTO fitnescentarDTO){
        FitnessCentar fitnessCentar = fitnescentarService.save(FitnessCentar.getFitnessCentarByDTO(fitnescentarDTO));
        if(fitnessCentar == null)
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        return new ResponseEntity<FitnessCentar>(HttpStatus.OK);
    }

    @DeleteMapping("/delete_fitnescentar/{id}")
    public ResponseEntity<?> delete_fitnescentar(@PathVariable(name = "id") Long id){
        try{
            this.fitnescentarService.deleteFitnescentar(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/fitnesscentar/{id}")
    public String fitnesscentar(@PathVariable(name = "id")Long id,Model model){
        FitnessCentar fitnessCentar=this.fitnescentarService.findOne(id);
        model.addAttribute("fitnessCentar",fitnessCentar);
        return "fitnesscentar.html";
    }
    @PutMapping("/edit_fitnesscentar")
    public ResponseEntity<?> edit_fitnesscentar(@RequestBody FitnessCentar fitnessCentar){
        try{
            this.fitnescentarService.editFitnescentar(fitnessCentar);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
